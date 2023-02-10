/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "ESTABLECIMIENTO", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Establecimiento.findAll", query = "SELECT e FROM Establecimiento e")
    , @NamedQuery(name = "Establecimiento.findByPkEstablec", query = "SELECT e FROM Establecimiento e WHERE e.pkEstablec = :pkEstablec")
    , @NamedQuery(name = "Establecimiento.findByDireccion", query = "SELECT e FROM Establecimiento e WHERE e.direccion = :direccion")
    , @NamedQuery(name = "Establecimiento.findByNombre", query = "SELECT e FROM Establecimiento e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Establecimiento.findByNit", query = "SELECT e FROM Establecimiento e WHERE e.nit = :nit")
    , @NamedQuery(name = "Establecimiento.findByCapacidad", query = "SELECT e FROM Establecimiento e WHERE e.capacidad = :capacidad")
    , @NamedQuery(name = "Establecimiento.findByPrecio", query = "SELECT e FROM Establecimiento e WHERE e.precio = :precio")})
public class Establecimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ESTABLECIMIENTO", sequenceName = "SQ_ESTABLECIMIENTO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTABLECIMIENTO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ESTABLEC", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkEstablec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DIRECCION", nullable = false, length = 500)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBRE", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NIT", nullable = false, length = 200)
    private String nit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAPACIDAD", nullable = false)
    private BigInteger capacidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRECIO", nullable = false)
    private BigInteger precio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstablec")
    private List<Evento> eventoList;
    @JoinColumn(name = "FK_DUENIO", referencedColumnName = "PK_DUENIO", nullable = false)
    @ManyToOne(optional = false)
    private Duenio fkDuenio;
    @JoinColumn(name = "FK_MUNICILUGAR", referencedColumnName = "PK_MUNICIPIO", nullable = false)
    @ManyToOne(optional = false)
    private Municipio fkMunicilugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstablec")
    private List<Estatipgen> estatipgenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstablec")
    private List<Estagenmusi> estagenmusiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkEstablec")
    private List<Estadispo> estadispoList;

    public Establecimiento() {
    }

    public Establecimiento(BigDecimal pkEstablec) {
        this.pkEstablec = pkEstablec;
    }

    public Establecimiento(BigDecimal pkEstablec, String direccion, String nombre, String nit, BigInteger capacidad, BigInteger precio) {
        this.pkEstablec = pkEstablec;
        this.direccion = direccion;
        this.nombre = nombre;
        this.nit = nit;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public BigDecimal getPkEstablec() {
        return pkEstablec;
    }

    public void setPkEstablec(BigDecimal pkEstablec) {
        this.pkEstablec = pkEstablec;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    public Duenio getFkDuenio() {
        return fkDuenio;
    }

    public void setFkDuenio(Duenio fkDuenio) {
        this.fkDuenio = fkDuenio;
    }

    public Municipio getFkMunicilugar() {
        return fkMunicilugar;
    }

    public void setFkMunicilugar(Municipio fkMunicilugar) {
        this.fkMunicilugar = fkMunicilugar;
    }

    @XmlTransient
    public List<Estatipgen> getEstatipgenList() {
        return estatipgenList;
    }

    public void setEstatipgenList(List<Estatipgen> estatipgenList) {
        this.estatipgenList = estatipgenList;
    }

    @XmlTransient
    public List<Estagenmusi> getEstagenmusiList() {
        return estagenmusiList;
    }

    public void setEstagenmusiList(List<Estagenmusi> estagenmusiList) {
        this.estagenmusiList = estagenmusiList;
    }

    @XmlTransient
    public List<Estadispo> getEstadispoList() {
        return estadispoList;
    }

    public void setEstadispoList(List<Estadispo> estadispoList) {
        this.estadispoList = estadispoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEstablec != null ? pkEstablec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Establecimiento)) {
            return false;
        }
        Establecimiento other = (Establecimiento) object;
        if ((this.pkEstablec == null && other.pkEstablec != null) || (this.pkEstablec != null && !this.pkEstablec.equals(other.pkEstablec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkEstablec + "-" + nombre;
    }
    
}
