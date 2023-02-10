/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "EVENTO", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e")
    , @NamedQuery(name = "Evento.findByPkEvento", query = "SELECT e FROM Evento e WHERE e.pkEvento = :pkEvento")
    , @NamedQuery(name = "Evento.findByFecha", query = "SELECT e FROM Evento e WHERE e.fecha = :fecha")
    , @NamedQuery(name = "Evento.findByCapacidad", query = "SELECT e FROM Evento e WHERE e.capacidad = :capacidad")
    , @NamedQuery(name = "Evento.findByPrecio", query = "SELECT e FROM Evento e WHERE e.precio = :precio")})
public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_EVENTO", sequenceName = "SQ_EVENTO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENTO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_EVENTO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDAD", nullable = false)
    private BigInteger capacidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO", nullable = false)
    private BigInteger precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEvento")
    private List<Participa> participaList;
    @JoinColumn(name = "FK_ESTABLEC", referencedColumnName = "PK_ESTABLEC", nullable = false)
    @ManyToOne(optional = false)
    private Establecimiento fkEstablec;
    @JoinColumn(name = "FK_TIPOEVENTO", referencedColumnName = "PK_TIPOEVENTO", nullable = false)
    @ManyToOne(optional = false)
    private Tipoevento fkTipoevento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEvento")
    private List<Asiste> asisteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEvento")
    private List<Reserva> reservaList;

    public Evento() {
    }

    public Evento(BigDecimal pkEvento) {
        this.pkEvento = pkEvento;
    }

    public Evento(BigDecimal pkEvento, Date fecha, String descripcion, BigInteger capacidad, BigInteger precio) {
        this.pkEvento = pkEvento;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public BigDecimal getPkEvento() {
        return pkEvento;
    }

    public void setPkEvento(BigDecimal pkEvento) {
        this.pkEvento = pkEvento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(BigInteger capacidad) {
        this.capacidad = capacidad;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    @XmlTransient
    public List<Participa> getParticipaList() {
        return participaList;
    }

    public void setParticipaList(List<Participa> participaList) {
        this.participaList = participaList;
    }

    public Establecimiento getFkEstablec() {
        return fkEstablec;
    }

    public void setFkEstablec(Establecimiento fkEstablec) {
        this.fkEstablec = fkEstablec;
    }

    public Tipoevento getFkTipoevento() {
        return fkTipoevento;
    }

    public void setFkTipoevento(Tipoevento fkTipoevento) {
        this.fkTipoevento = fkTipoevento;
    }

    @XmlTransient
    public List<Asiste> getAsisteList() {
        return asisteList;
    }

    public void setAsisteList(List<Asiste> asisteList) {
        this.asisteList = asisteList;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEvento != null ? pkEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.pkEvento == null && other.pkEvento != null) || (this.pkEvento != null && !this.pkEvento.equals(other.pkEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion + "-" + fkEstablec.getNombre() + "- " + fecha;
    }
    
}
