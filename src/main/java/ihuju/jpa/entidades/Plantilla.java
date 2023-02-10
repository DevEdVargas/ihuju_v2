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
@Table(name = "PLANTILLA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plantilla.findAll", query = "SELECT p FROM Plantilla p")
    , @NamedQuery(name = "Plantilla.findByPkPlantilla", query = "SELECT p FROM Plantilla p WHERE p.pkPlantilla = :pkPlantilla")
    , @NamedQuery(name = "Plantilla.findByCodigo", query = "SELECT p FROM Plantilla p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Plantilla.findByDescripcion", query = "SELECT p FROM Plantilla p WHERE p.descripcion = :descripcion")})
public class Plantilla implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_PLANTILLA", sequenceName = "SQ_PLANTILLA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PLANTILLA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_PLANTILLA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkPlantilla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO", nullable = false, length = 20)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPlantilla")
    private List<Accperplan> accperplanList;

    public Plantilla() {
    }

    public Plantilla(BigDecimal pkPlantilla) {
        this.pkPlantilla = pkPlantilla;
    }

    public Plantilla(BigDecimal pkPlantilla, String codigo, String descripcion) {
        this.pkPlantilla = pkPlantilla;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkPlantilla() {
        return pkPlantilla;
    }

    public void setPkPlantilla(BigDecimal pkPlantilla) {
        this.pkPlantilla = pkPlantilla;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Accperplan> getAccperplanList() {
        return accperplanList;
    }

    public void setAccperplanList(List<Accperplan> accperplanList) {
        this.accperplanList = accperplanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPlantilla != null ? pkPlantilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plantilla)) {
            return false;
        }
        Plantilla other = (Plantilla) object;
        if ((this.pkPlantilla == null && other.pkPlantilla != null) || (this.pkPlantilla != null && !this.pkPlantilla.equals(other.pkPlantilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkPlantilla + "-" + codigo + "-" + descripcion;
    }
    
}
