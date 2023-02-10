/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "USUARIO", catalog = "", schema = "IHUJU", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOMBREUSUARIO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByPkUsuario", query = "SELECT u FROM Usuario u WHERE u.pkUsuario = :pkUsuario")
    , @NamedQuery(name = "Usuario.findByNombreusuario", query = "SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario and u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByNombreusu", query = "SELECT u FROM Usuario u WHERE u.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "Usuario.findByTipousuarioenum", query = "SELECT u FROM Usuario u WHERE u.tipousuarioenum = :tipousuarioenum")
    , @NamedQuery(name = "Usuario.findByUltimoacceso", query = "SELECT u FROM Usuario u WHERE u.ultimoacceso = :ultimoacceso")
    , @NamedQuery(name = "Usuario.findByCodactivacion", query = "SELECT u FROM Usuario u WHERE u.codactivacion = :codactivacion")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_USUARIO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "NOMBREUSUARIO", nullable = false, length = 200)
    private String nombreusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "CONTRASENA", nullable = false, length = 500)
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPOUSUARIOENUM", nullable = false)
    private BigInteger tipousuarioenum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ULTIMOACCESO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoacceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CODACTIVACION", nullable = false, length = 45)
    private String codactivacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUsuario")
    private List<Estadousuario> estadousuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUsuario")
    private List<Cliente> clienteList;
    @JoinColumn(name = "FK_PERSONA", referencedColumnName = "PK_PERSONA")
    @ManyToOne
    private Persona fkPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUsuario")
    private List<Duenio> duenioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkUsuario")
    private List<Accperusu> accperusuList;
    @OneToMany(mappedBy = "fkUsuario")
    private List<Artista> artistaList;

    public Usuario() {
    }

    public Usuario(BigDecimal pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public Usuario(BigDecimal pkUsuario, String nombreusuario, String contrasena, BigInteger tipousuarioenum, Date ultimoacceso, String codactivacion) {
        this.pkUsuario = pkUsuario;
        this.nombreusuario = nombreusuario;
        this.contrasena = contrasena;
        this.tipousuarioenum = tipousuarioenum;
        this.ultimoacceso = ultimoacceso;
        this.codactivacion = codactivacion;
    }

    public BigDecimal getPkUsuario() {
        return pkUsuario;
    }

    public void setPkUsuario(BigDecimal pkUsuario) {
        this.pkUsuario = pkUsuario;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public BigInteger getTipousuarioenum() {
        return tipousuarioenum;
    }

    public void setTipousuarioenum(BigInteger tipousuarioenum) {
        this.tipousuarioenum = tipousuarioenum;
    }

    public Date getUltimoacceso() {
        return ultimoacceso;
    }

    public void setUltimoacceso(Date ultimoacceso) {
        this.ultimoacceso = ultimoacceso;
    }

    public String getCodactivacion() {
        return codactivacion;
    }

    public void setCodactivacion(String codactivacion) {
        this.codactivacion = codactivacion;
    }

    @XmlTransient
    public List<Estadousuario> getEstadousuarioList() {
        return estadousuarioList;
    }

    public void setEstadousuarioList(List<Estadousuario> estadousuarioList) {
        this.estadousuarioList = estadousuarioList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Persona getFkPersona() {
        return fkPersona;
    }

    public void setFkPersona(Persona fkPersona) {
        this.fkPersona = fkPersona;
    }

    @XmlTransient
    public List<Duenio> getDuenioList() {
        return duenioList;
    }

    public void setDuenioList(List<Duenio> duenioList) {
        this.duenioList = duenioList;
    }

    @XmlTransient
    public List<Accperusu> getAccperusuList() {
        return accperusuList;
    }

    public void setAccperusuList(List<Accperusu> accperusuList) {
        this.accperusuList = accperusuList;
    }

    @XmlTransient
    public List<Artista> getArtistaList() {
        return artistaList;
    }

    public void setArtistaList(List<Artista> artistaList) {
        this.artistaList = artistaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkUsuario != null ? pkUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.pkUsuario == null && other.pkUsuario != null) || (this.pkUsuario != null && !this.pkUsuario.equals(other.pkUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkUsuario + "-" +nombreusuario;
    }
    
}
