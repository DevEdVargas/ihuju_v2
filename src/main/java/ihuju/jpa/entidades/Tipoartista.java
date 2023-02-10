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
@Table(name = "TIPOARTISTA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoartista.findAll", query = "SELECT t FROM Tipoartista t")
    , @NamedQuery(name = "Tipoartista.findByPkTipartis", query = "SELECT t FROM Tipoartista t WHERE t.pkTipartis = :pkTipartis")
    , @NamedQuery(name = "Tipoartista.findByNombre", query = "SELECT t FROM Tipoartista t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tipoartista.findByDescripcion", query = "SELECT t FROM Tipoartista t WHERE t.descripcion = :descripcion")})
public class Tipoartista implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_TIPOARTISTA", sequenceName = "SQ_TIPOARTISTA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPOARTISTA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_TIPARTIS", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkTipartis;
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
    @OneToMany(mappedBy = "fkTipartis")
    private List<Artista> artistaList;

    public Tipoartista() {
    }

    public Tipoartista(BigDecimal pkTipartis) {
        this.pkTipartis = pkTipartis;
    }

    public Tipoartista(BigDecimal pkTipartis, String nombre, String descripcion) {
        this.pkTipartis = pkTipartis;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public BigDecimal getPkTipartis() {
        return pkTipartis;
    }

    public void setPkTipartis(BigDecimal pkTipartis) {
        this.pkTipartis = pkTipartis;
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
    public List<Artista> getArtistaList() {
        return artistaList;
    }

    public void setArtistaList(List<Artista> artistaList) {
        this.artistaList = artistaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkTipartis != null ? pkTipartis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoartista)) {
            return false;
        }
        Tipoartista other = (Tipoartista) object;
        if ((this.pkTipartis == null && other.pkTipartis != null) || (this.pkTipartis != null && !this.pkTipartis.equals(other.pkTipartis))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkTipartis + "-" + nombre;
    }
    
}
