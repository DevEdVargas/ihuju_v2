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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DEPARTAMENTO", catalog = "", schema = "IHUJU", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")
    , @NamedQuery(name = "Departamento.findPais", query = "SELECT d FROM Departamento d WHERE d.fkPais.codigo = :codPais order by d.nombre")
    , @NamedQuery(name = "Departamento.findByPkDepartamen", query = "SELECT d FROM Departamento d WHERE d.pkDepartamen = :pkDepartamen")
    , @NamedQuery(name = "Departamento.findByCodigo", query = "SELECT d FROM Departamento d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre")})
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_DEPARTAMENTO", sequenceName = "SQ_DEPARTAMENTO", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DEPARTAMENTO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_DEPARTAMEN", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkDepartamen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO", nullable = false, length = 20)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @JoinColumn(name = "FK_PAIS", referencedColumnName = "PK_PAIS", nullable = false)
    @ManyToOne(optional = false)
    private Pais fkPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDepartamen")
    private List<Municipio> municipioList;

    public Departamento() {
    }

    public Departamento(BigDecimal pkDepartamen) {
        this.pkDepartamen = pkDepartamen;
    }

    public Departamento(BigDecimal pkDepartamen, String codigo, String nombre) {
        this.pkDepartamen = pkDepartamen;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public BigDecimal getPkDepartamen() {
        return pkDepartamen;
    }

    public void setPkDepartamen(BigDecimal pkDepartamen) {
        this.pkDepartamen = pkDepartamen;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getFkPais() {
        return fkPais;
    }

    public void setFkPais(Pais fkPais) {
        this.fkPais = fkPais;
    }

    @XmlTransient
    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkDepartamen != null ? pkDepartamen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.pkDepartamen == null && other.pkDepartamen != null) || (this.pkDepartamen != null && !this.pkDepartamen.equals(other.pkDepartamen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }

}
