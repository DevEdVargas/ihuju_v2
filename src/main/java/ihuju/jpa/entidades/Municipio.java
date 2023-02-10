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
@Table(name = "MUNICIPIO", catalog = "", schema = "IHUJU", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m")    
    , @NamedQuery(name = "Municipio.findDepartamento", query = "SELECT m FROM Municipio m WHERE m.fkDepartamen.codigo = :codDepartamento order by m.nombre")
    , @NamedQuery(name = "Municipio.findByPkMunicipio", query = "SELECT m FROM Municipio m WHERE m.pkMunicipio = :pkMunicipio")
    , @NamedQuery(name = "Municipio.findByCodigo", query = "SELECT m FROM Municipio m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Municipio.findByNombre", query = "SELECT m FROM Municipio m WHERE m.nombre = :nombre")})

public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_MUNICIPIO", sequenceName = "SQ_MUNICIPIO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MUNICIPIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_MUNICIPIO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkMunicipio;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMunicipio")
    private List<Persona> personaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMunicilugar")
    private List<Establecimiento> establecimientoList;
    @JoinColumn(name = "FK_DEPARTAMEN", referencedColumnName = "PK_DEPARTAMEN", nullable = false)
    @ManyToOne(optional = false)
    private Departamento fkDepartamen;

    public Municipio() {
    }

    public Municipio(BigDecimal pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
    }

    public Municipio(BigDecimal pkMunicipio, String codigo, String nombre) {
        this.pkMunicipio = pkMunicipio;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public BigDecimal getPkMunicipio() {
        return pkMunicipio;
    }

    public void setPkMunicipio(BigDecimal pkMunicipio) {
        this.pkMunicipio = pkMunicipio;
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

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @XmlTransient
    public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }

    public Departamento getFkDepartamen() {
        return fkDepartamen;
    }

    public void setFkDepartamen(Departamento fkDepartamen) {
        this.fkDepartamen = fkDepartamen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkMunicipio != null ? pkMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.pkMunicipio == null && other.pkMunicipio != null) || (this.pkMunicipio != null && !this.pkMunicipio.equals(other.pkMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo+ " - "+ nombre;
    }
    
}
