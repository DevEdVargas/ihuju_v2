/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "ACCPERUSU", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accperusu.findAll", query = "SELECT a FROM Accperusu a")
    , @NamedQuery(name = "Accperusu.findByPkAcciperusu", query = "SELECT a FROM Accperusu a WHERE a.pkAcciperusu = :pkAcciperusu")})
public class Accperusu implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ACCIONPERUSUARIO", sequenceName = "SQ_ACCIONPERUSUARIO", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCIONPERUSUARIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ACCIPERUSU", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkAcciperusu;
    @JoinColumn(name = "FK_ACCIPERMITIDA", referencedColumnName = "PK_ACCIPERMITIDA", nullable = false)
    @ManyToOne(optional = false)
    private Accionpermitida fkAccipermitida;
    @JoinColumn(name = "FK_USUARIO", referencedColumnName = "PK_USUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuario fkUsuario;

    public Accperusu() {
    }

    public Accperusu(BigDecimal pkAcciperusu) {
        this.pkAcciperusu = pkAcciperusu;
    }

    public BigDecimal getPkAcciperusu() {
        return pkAcciperusu;
    }

    public void setPkAcciperusu(BigDecimal pkAcciperusu) {
        this.pkAcciperusu = pkAcciperusu;
    }

    public Accionpermitida getFkAccipermitida() {
        return fkAccipermitida;
    }

    public void setFkAccipermitida(Accionpermitida fkAccipermitida) {
        this.fkAccipermitida = fkAccipermitida;
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
        hash += (pkAcciperusu != null ? pkAcciperusu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accperusu)) {
            return false;
        }
        Accperusu other = (Accperusu) object;
        if ((this.pkAcciperusu == null && other.pkAcciperusu != null) || (this.pkAcciperusu != null && !this.pkAcciperusu.equals(other.pkAcciperusu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkAcciperusu + "-" + fkAccipermitida + "-" + fkUsuario;
    }
    
}
