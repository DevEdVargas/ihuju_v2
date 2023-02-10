/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "ESTADISPO", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadispo.findAll", query = "SELECT e FROM Estadispo e")
    , @NamedQuery(name = "Estadispo.findByPkEstadispo", query = "SELECT e FROM Estadispo e WHERE e.pkEstadispo = :pkEstadispo")})
public class Estadispo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ESTADISPO", sequenceName = "SQ_ESTADISPO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTADISPO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ESTADISPO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkEstadispo;
    @JoinColumn(name = "FK_DISPONIBILIDAD", referencedColumnName = "PK_DISPONIBILIDAD", nullable = false)
    @ManyToOne(optional = false)
    private Disponibilidad fkDisponibilidad;
    @JoinColumn(name = "FK_ESTABLEC", referencedColumnName = "PK_ESTABLEC", nullable = false)
    @ManyToOne(optional = false)
    private Establecimiento fkEstablec;

    public Estadispo() {
    }

    public Estadispo(BigDecimal pkEstadispo) {
        this.pkEstadispo = pkEstadispo;
    }

    public BigDecimal getPkEstadispo() {
        return pkEstadispo;
    }

    public void setPkEstadispo(BigDecimal pkEstadispo) {
        this.pkEstadispo = pkEstadispo;
    }

    public Disponibilidad getFkDisponibilidad() {
        return fkDisponibilidad;
    }

    public void setFkDisponibilidad(Disponibilidad fkDisponibilidad) {
        this.fkDisponibilidad = fkDisponibilidad;
    }

    public Establecimiento getFkEstablec() {
        return fkEstablec;
    }

    public void setFkEstablec(Establecimiento fkEstablec) {
        this.fkEstablec = fkEstablec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEstadispo != null ? pkEstadispo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadispo)) {
            return false;
        }
        Estadispo other = (Estadispo) object;
        if ((this.pkEstadispo == null && other.pkEstadispo != null) || (this.pkEstadispo != null && !this.pkEstadispo.equals(other.pkEstadispo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkEstadispo + "-";
    }
    
}
