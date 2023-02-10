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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "TIPOTELEFONO", catalog = "", schema = "IHUJU", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipotelefono.findAll", query = "SELECT t FROM Tipotelefono t")
    , @NamedQuery(name = "Tipotelefono.findByPkTiptelefono", query = "SELECT t FROM Tipotelefono t WHERE t.pkTiptelefono = :pkTiptelefono")
    , @NamedQuery(name = "Tipotelefono.findByCodigo", query = "SELECT t FROM Tipotelefono t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipotelefono.findByDescripcion", query = "SELECT t FROM Tipotelefono t WHERE t.descripcion = :descripcion")})
public class Tipotelefono implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_TIPOTELEFONO", sequenceName = "SQ_TIPOTELEFONO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPOTELEFONO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_TIPTELEFONO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkTiptelefono;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTiptelefono")
    private List<Telefono> telefonoList;

    public Tipotelefono() {
    }

    public Tipotelefono(BigDecimal pkTiptelefono) {
        this.pkTiptelefono = pkTiptelefono;
    }

    public Tipotelefono(BigDecimal pkTiptelefono, String codigo, String descripcion) {
        this.pkTiptelefono = pkTiptelefono;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkTiptelefono() {
        return pkTiptelefono;
    }

    public void setPkTiptelefono(BigDecimal pkTiptelefono) {
        this.pkTiptelefono = pkTiptelefono;
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
    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTiptelefono != null ? pkTiptelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipotelefono)) {
            return false;
        }
        Tipotelefono other = (Tipotelefono) object;
        if ((this.pkTiptelefono == null && other.pkTiptelefono != null) || (this.pkTiptelefono != null && !this.pkTiptelefono.equals(other.pkTiptelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "-" + descripcion;
    }
    
}
