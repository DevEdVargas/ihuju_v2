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
@Table(name = "TIPOIDENTIFICACION", catalog = "", schema = "IHUJU", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoidentificacion.findAll", query = "SELECT t FROM Tipoidentificacion t")
    , @NamedQuery(name = "Tipoidentificacion.findByPkTipoidentifi", query = "SELECT t FROM Tipoidentificacion t WHERE t.pkTipoidentifi = :pkTipoidentifi")
    , @NamedQuery(name = "Tipoidentificacion.findByCodigo", query = "SELECT t FROM Tipoidentificacion t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Tipoidentificacion.findByDescripcion", query = "SELECT t FROM Tipoidentificacion t WHERE t.descripcion = :descripcion")})
public class Tipoidentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_TIPOIDENTIFICACION", sequenceName = "SQ_TIPOIDENTIFICACION", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPOIDENTIFICACION")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_TIPOIDENTIFI", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkTipoidentifi;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkTipoidentifi")
    private List<Persona> personaList;

    public Tipoidentificacion() {
    }

    public Tipoidentificacion(BigDecimal pkTipoidentifi) {
        this.pkTipoidentifi = pkTipoidentifi;
    }

    public Tipoidentificacion(BigDecimal pkTipoidentifi, String codigo, String descripcion) {
        this.pkTipoidentifi = pkTipoidentifi;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkTipoidentifi() {
        return pkTipoidentifi;
    }

    public void setPkTipoidentifi(BigDecimal pkTipoidentifi) {
        this.pkTipoidentifi = pkTipoidentifi;
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
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipoidentifi != null ? pkTipoidentifi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoidentificacion)) {
            return false;
        }
        Tipoidentificacion other = (Tipoidentificacion) object;
        if ((this.pkTipoidentifi == null && other.pkTipoidentifi != null) || (this.pkTipoidentifi != null && !this.pkTipoidentifi.equals(other.pkTipoidentifi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion+"-";
    }
    
}
