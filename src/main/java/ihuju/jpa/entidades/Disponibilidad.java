/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "DISPONIBILIDAD", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disponibilidad.findAll", query = "SELECT d FROM Disponibilidad d")
    , @NamedQuery(name = "Disponibilidad.findByPkDisponibilidad", query = "SELECT d FROM Disponibilidad d WHERE d.pkDisponibilidad = :pkDisponibilidad")
    , @NamedQuery(name = "Disponibilidad.findByHorario", query = "SELECT d FROM Disponibilidad d WHERE d.horario = :horario")})
public class Disponibilidad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_DISPONIBILIDAD", sequenceName = "SQ_DISPONIBILIDAD", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DISPONIBILIDAD")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_DISPONIBILIDAD", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkDisponibilidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORARIO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDisponibilidad")
    private List<Estadispo> estadispoList;

    public Disponibilidad() {
    }

    public Disponibilidad(BigDecimal pkDisponibilidad) {
        this.pkDisponibilidad = pkDisponibilidad;
    }

    public Disponibilidad(BigDecimal pkDisponibilidad, Date horario) {
        this.pkDisponibilidad = pkDisponibilidad;
        this.horario = horario;
    }

    public BigDecimal getPkDisponibilidad() {
        return pkDisponibilidad;
    }

    public void setPkDisponibilidad(BigDecimal pkDisponibilidad) {
        this.pkDisponibilidad = pkDisponibilidad;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
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
        hash += (pkDisponibilidad != null ? pkDisponibilidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disponibilidad)) {
            return false;
        }
        Disponibilidad other = (Disponibilidad) object;
        if ((this.pkDisponibilidad == null && other.pkDisponibilidad != null) || (this.pkDisponibilidad != null && !this.pkDisponibilidad.equals(other.pkDisponibilidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkDisponibilidad+ "-" +horario;
    }
    
}
