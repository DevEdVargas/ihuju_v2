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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "DUENIO", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Duenio.findAll", query = "SELECT d FROM Duenio d")
    ,@NamedQuery(name = "Duenio.findByfkDueni", query = "SELECT d FROM Duenio d WHERE d.fkUsuario.pkUsuario = :idUsuario")
    , @NamedQuery(name = "Duenio.findByPkDuenio", query = "SELECT d FROM Duenio d WHERE d.pkDuenio = :pkDuenio")})
public class Duenio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_DUENIO", sequenceName = "SQ_DUENIO", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DUENIO")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_DUENIO", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkDuenio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkDuenio")
    private List<Establecimiento> establecimientoList;
    @JoinColumn(name = "FK_USUARIO", referencedColumnName = "PK_USUARIO", nullable = false)
    @ManyToOne(optional = false)
    private Usuario fkUsuario;

    public Duenio() {
    }

    public Duenio(BigDecimal pkDuenio) {
        this.pkDuenio = pkDuenio;
    }

    public BigDecimal getPkDuenio() {
        return pkDuenio;
    }

    public void setPkDuenio(BigDecimal pkDuenio) {
        this.pkDuenio = pkDuenio;
    }

    @XmlTransient
    public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
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
        hash += (pkDuenio != null ? pkDuenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Duenio)) {
            return false;
        }
        Duenio other = (Duenio) object;
        if ((this.pkDuenio == null && other.pkDuenio != null) || (this.pkDuenio != null && !this.pkDuenio.equals(other.pkDuenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkDuenio + "-";
    }

}
