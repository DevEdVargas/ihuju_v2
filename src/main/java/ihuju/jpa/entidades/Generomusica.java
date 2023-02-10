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
@Table(name = "GENEROMUSICA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Generomusica.findAll", query = "SELECT g FROM Generomusica g")
    , @NamedQuery(name = "Generomusica.findByPkGeneromusica", query = "SELECT g FROM Generomusica g WHERE g.pkGeneromusica = :pkGeneromusica")
    , @NamedQuery(name = "Generomusica.findByNombre", query = "SELECT g FROM Generomusica g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Generomusica.findByDescripcion", query = "SELECT g FROM Generomusica g WHERE g.descripcion = :descripcion")})
public class Generomusica implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_GENEROMUSICA", sequenceName = "SQ_GENEROMUSICA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GENEROMUSICA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_GENEROMUSICA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkGeneromusica;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkGeneromusica")
    private List<Estagenmusi> estagenmusiList;

    public Generomusica() {
    }

    public Generomusica(BigDecimal pkGeneromusica) {
        this.pkGeneromusica = pkGeneromusica;
    }

    public Generomusica(BigDecimal pkGeneromusica, String nombre, String descripcion) {
        this.pkGeneromusica = pkGeneromusica;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkGeneromusica() {
        return pkGeneromusica;
    }

    public void setPkGeneromusica(BigDecimal pkGeneromusica) {
        this.pkGeneromusica = pkGeneromusica;
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
    public List<Estagenmusi> getEstagenmusiList() {
        return estagenmusiList;
    }

    public void setEstagenmusiList(List<Estagenmusi> estagenmusiList) {
        this.estagenmusiList = estagenmusiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkGeneromusica != null ? pkGeneromusica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generomusica)) {
            return false;
        }
        Generomusica other = (Generomusica) object;
        if ((this.pkGeneromusica == null && other.pkGeneromusica != null) || (this.pkGeneromusica != null && !this.pkGeneromusica.equals(other.pkGeneromusica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkGeneromusica + "-"+ descripcion;
    }
    
}
