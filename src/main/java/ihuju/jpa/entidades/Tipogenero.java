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
@Table(name = "TIPOGENERO", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipogenero.findAll", query = "SELECT t FROM Tipogenero t")
    , @NamedQuery(name = "Tipogenero.findByPkTipogenero", query = "SELECT t FROM Tipogenero t WHERE t.pkTipogenero = :pkTipogenero")
    , @NamedQuery(name = "Tipogenero.findByNombre", query = "SELECT t FROM Tipogenero t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tipogenero.findByDescripcion", query = "SELECT t FROM Tipogenero t WHERE t.descripcion = :descripcion")})
public class Tipogenero implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_TIPOGENERO", sequenceName = "SQ_TIPOGENERO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPOGENERO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_TIPOGENERO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkTipogenero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipogenero")
    private List<Estatipgen> estatipgenList;

    public Tipogenero() {
    }

    public Tipogenero(BigDecimal pkTipogenero) {
        this.pkTipogenero = pkTipogenero;
    }

    public Tipogenero(BigDecimal pkTipogenero, String nombre, String descripcion) {
        this.pkTipogenero = pkTipogenero;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkTipogenero() {
        return pkTipogenero;
    }

    public void setPkTipogenero(BigDecimal pkTipogenero) {
        this.pkTipogenero = pkTipogenero;
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
    public List<Estatipgen> getEstatipgenList() {
        return estatipgenList;
    }

    public void setEstatipgenList(List<Estatipgen> estatipgenList) {
        this.estatipgenList = estatipgenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipogenero != null ? pkTipogenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipogenero)) {
            return false;
        }
        Tipogenero other = (Tipogenero) object;
        if ((this.pkTipogenero == null && other.pkTipogenero != null) || (this.pkTipogenero != null && !this.pkTipogenero.equals(other.pkTipogenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkTipogenero + "-" + nombre + "-" +descripcion;
    }
    
}
