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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "ARTISTA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artista.findAll", query = "SELECT a FROM Artista a")
    , @NamedQuery(name = "Artista.findByPkArtista", query = "SELECT a FROM Artista a WHERE a.pkArtista = :pkArtista")
    , @NamedQuery(name = "Artista.findByfkUsuario", query = "SELECT d FROM Artista d WHERE d.fkUsuario.pkUsuario = :idUsuario")
    , @NamedQuery(name = "Artista.findByApodo", query = "SELECT a FROM Artista a WHERE a.apodo = :apodo")
    , @NamedQuery(name = "Artista.findByGeneromusical", query = "SELECT a FROM Artista a WHERE a.generomusical = :generomusical")
    , @NamedQuery(name = "Artista.findByExperiencia", query = "SELECT a FROM Artista a WHERE a.experiencia = :experiencia")})
public class Artista implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ARTISTA", sequenceName = "SQ_ARTISTA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARTISTA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ARTISTA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkArtista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "APODO", nullable = false, length = 100)
    private String apodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "GENEROMUSICAL", nullable = false, length = 100)
    private String generomusical;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EXPERIENCIA", nullable = false, length = 100)
    private String experiencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkArtista")
    private List<Participa> participaList;
    @JoinColumn(name = "FK_TIPARTIS", referencedColumnName = "PK_TIPARTIS")
    @ManyToOne
    private Tipoartista fkTipartis;
    @JoinColumn(name = "FK_USUARIO", referencedColumnName = "PK_USUARIO")
    @ManyToOne
    private Usuario fkUsuario;

    public Artista() {
    }

    public Artista(BigDecimal pkArtista) {
        this.pkArtista = pkArtista;
    }

    public Artista(BigDecimal pkArtista, String apodo, String generomusical, String experiencia) {
        this.pkArtista = pkArtista;
        this.apodo = apodo;
        this.generomusical = generomusical;
        this.experiencia = experiencia;
    }

    public BigDecimal getPkArtista() {
        return pkArtista;
    }

    public void setPkArtista(BigDecimal pkArtista) {
        this.pkArtista = pkArtista;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getGeneromusical() {
        return generomusical;
    }

    public void setGeneromusical(String generomusical) {
        this.generomusical = generomusical;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @XmlTransient
    public List<Participa> getParticipaList() {
        return participaList;
    }

    public void setParticipaList(List<Participa> participaList) {
        this.participaList = participaList;
    }

    public Tipoartista getFkTipartis() {
        return fkTipartis;
    }

    public void setFkTipartis(Tipoartista fkTipartis) {
        this.fkTipartis = fkTipartis;
    }

    public Usuario getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(Usuario fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkArtista != null ? pkArtista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.pkArtista == null && other.pkArtista != null) || (this.pkArtista != null && !this.pkArtista.equals(other.pkArtista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkArtista + "-" + fkTipartis.getNombre() + "-" + fkUsuario.getNombreusuario();
    }
    
}
