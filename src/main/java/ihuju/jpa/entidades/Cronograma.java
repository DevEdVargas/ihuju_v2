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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "CRONOGRAMA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cronograma.findAll", query = "SELECT c FROM Cronograma c")
    , @NamedQuery(name = "Cronograma.findByPkCronogra", query = "SELECT c FROM Cronograma c WHERE c.pkCronogra = :pkCronogra")
    , @NamedQuery(name = "Cronograma.findByHora", query = "SELECT c FROM Cronograma c WHERE c.hora = :hora")
    , @NamedQuery(name = "Cronograma.findByDescripcion", query = "SELECT c FROM Cronograma c WHERE c.descripcion = :descripcion")})
public class Cronograma implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_CRONOGRAMA", sequenceName = "SQ_CRONOGRAMA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CRONOGRAMA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_CRONOGRA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkCronogra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCronogra")
    private List<Participa> participaList;

    public Cronograma() {
    }

    public Cronograma(BigDecimal pkCronogra) {
        this.pkCronogra = pkCronogra;
    }

    public Cronograma(BigDecimal pkCronogra, Date hora, String descripcion) {
        this.pkCronogra = pkCronogra;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkCronogra() {
        return pkCronogra;
    }

    public void setPkCronogra(BigDecimal pkCronogra) {
        this.pkCronogra = pkCronogra;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Participa> getParticipaList() {
        return participaList;
    }

    public void setParticipaList(List<Participa> participaList) {
        this.participaList = participaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCronogra != null ? pkCronogra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cronograma)) {
            return false;
        }
        Cronograma other = (Cronograma) object;
        if ((this.pkCronogra == null && other.pkCronogra != null) || (this.pkCronogra != null && !this.pkCronogra.equals(other.pkCronogra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkCronogra + " ]";
    }
    
}
