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
@Table(name = "PERSONA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByPkPersona", query = "SELECT p FROM Persona p WHERE p.pkPersona = :pkPersona")
    , @NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email")
    , @NamedQuery(name = "Persona.findByFechanacimiento", query = "SELECT p FROM Persona p WHERE p.fechanacimiento = :fechanacimiento")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_PERSONA", sequenceName = "SQ_PERSONA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERSONA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_PERSONA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "IDENTIFICACION", nullable = false, length = 200)
    private String identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NOMBRE", nullable = false, length = 500)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "APELLIDO", nullable = false, length = 500)
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL", length = 100)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHANACIMIENTO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechanacimiento;
    @JoinColumn(name = "FK_ESTADOCIVIL", referencedColumnName = "PK_ESTADOCIVIL")
    @ManyToOne
    private Estadocivil fkEstadocivil;
    @JoinColumn(name = "FK_GENERO", referencedColumnName = "PK_GENERO", nullable = false)
    @ManyToOne(optional = false)
    private Genero fkGenero;
    @JoinColumn(name = "FK_MUNICIPIO", referencedColumnName = "PK_MUNICIPIO", nullable = false)
    @ManyToOne(optional = false)
    private Municipio fkMunicipio;
    @JoinColumn(name = "FK_TIPOIDENTIFI", referencedColumnName = "PK_TIPOIDENTIFI", nullable = false)
    @ManyToOne(optional = false)
    private Tipoidentificacion fkTipoidentifi;
    @OneToMany(mappedBy = "fkPersona")
    private List<Usuario> usuarioList;
    @OneToMany(mappedBy = "fkPersona")
    private List<Telefono> telefonoList;

    public Persona() {
    }

    public Persona(BigDecimal pkPersona) {
        this.pkPersona = pkPersona;
    }

    public Persona(BigDecimal pkPersona, String identificacion, String nombre, String apellido, Date fechanacimiento) {
        this.pkPersona = pkPersona;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
    }

    public BigDecimal getPkPersona() {
        return pkPersona;
    }

    public void setPkPersona(BigDecimal pkPersona) {
        this.pkPersona = pkPersona;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Estadocivil getFkEstadocivil() {
        return fkEstadocivil;
    }

    public void setFkEstadocivil(Estadocivil fkEstadocivil) {
        this.fkEstadocivil = fkEstadocivil;
    }

    public Genero getFkGenero() {
        return fkGenero;
    }

    public void setFkGenero(Genero fkGenero) {
        this.fkGenero = fkGenero;
    }

    public Municipio getFkMunicipio() {
        return fkMunicipio;
    }

    public void setFkMunicipio(Municipio fkMunicipio) {
        this.fkMunicipio = fkMunicipio;
    }

    public Tipoidentificacion getFkTipoidentifi() {
        return fkTipoidentifi;
    }

    public void setFkTipoidentifi(Tipoidentificacion fkTipoidentifi) {
        this.fkTipoidentifi = fkTipoidentifi;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        hash += (pkPersona != null ? pkPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.pkPersona == null && other.pkPersona != null) || (this.pkPersona != null && !this.pkPersona.equals(other.pkPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return identificacion+"-"+nombre+"-"+apellido; 
    }
    
}
