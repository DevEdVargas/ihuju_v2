/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "TIPOEVENTO", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoevento.findAll", query = "SELECT t FROM Tipoevento t")
    , @NamedQuery(name = "Tipoevento.findByPkTipoevento", query = "SELECT t FROM Tipoevento t WHERE t.pkTipoevento = :pkTipoevento")
    , @NamedQuery(name = "Tipoevento.findByNombre", query = "SELECT t FROM Tipoevento t WHERE t.nombre = :nombre")})
public class Tipoevento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_TIPOEVENTO", sequenceName = "SQ_TIPOEVENTO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPOEVENTO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_TIPOEVENTO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkTipoevento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoevento")
    private List<Evento> eventoList;

    public Tipoevento() {
    }

    public Tipoevento(BigDecimal pkTipoevento) {
        this.pkTipoevento = pkTipoevento;
    }

    public Tipoevento(BigDecimal pkTipoevento, String nombre, String descripcion) {
        this.pkTipoevento = pkTipoevento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkTipoevento() {
        return pkTipoevento;
    }

    public void setPkTipoevento(BigDecimal pkTipoevento) {
        this.pkTipoevento = pkTipoevento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Evento> getEventoList() {
        return eventoList;
    }

    public void setEventoList(List<Evento> eventoList) {
        this.eventoList = eventoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipoevento != null ? pkTipoevento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoevento)) {
            return false;
        }
        Tipoevento other = (Tipoevento) object;
        if ((this.pkTipoevento == null && other.pkTipoevento != null) || (this.pkTipoevento != null && !this.pkTipoevento.equals(other.pkTipoevento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkTipoevento + "-" + nombre;
    }
    
}
