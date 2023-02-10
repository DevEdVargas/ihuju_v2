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
@Table(name = "ESTAGENMUSI", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estagenmusi.findAll", query = "SELECT e FROM Estagenmusi e")
    , @NamedQuery(name = "Estagenmusi.findByPkEstagenmusi", query = "SELECT e FROM Estagenmusi e WHERE e.pkEstagenmusi = :pkEstagenmusi")})
public class Estagenmusi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ESTAGENMUSI", sequenceName = "SQ_ESTAGENMUSI", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTAGENMUSI")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ESTAGENMUSI", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkEstagenmusi;
    @JoinColumn(name = "FK_ESTABLEC", referencedColumnName = "PK_ESTABLEC", nullable = false)
    @ManyToOne(optional = false)
    private Establecimiento fkEstablec;
    @JoinColumn(name = "FK_GENEROMUSICA", referencedColumnName = "PK_GENEROMUSICA", nullable = false)
    @ManyToOne(optional = false)
    private Generomusica fkGeneromusica;

    public Estagenmusi() {
    }

    public Estagenmusi(BigDecimal pkEstagenmusi) {
        this.pkEstagenmusi = pkEstagenmusi;
    }

    public BigDecimal getPkEstagenmusi() {
        return pkEstagenmusi;
    }

    public void setPkEstagenmusi(BigDecimal pkEstagenmusi) {
        this.pkEstagenmusi = pkEstagenmusi;
    }

    public Establecimiento getFkEstablec() {
        return fkEstablec;
    }

    public void setFkEstablec(Establecimiento fkEstablec) {
        this.fkEstablec = fkEstablec;
    }

    public Generomusica getFkGeneromusica() {
        return fkGeneromusica;
    }

    public void setFkGeneromusica(Generomusica fkGeneromusica) {
        this.fkGeneromusica = fkGeneromusica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEstagenmusi != null ? pkEstagenmusi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estagenmusi)) {
            return false;
        }
        Estagenmusi other = (Estagenmusi) object;
        if ((this.pkEstagenmusi == null && other.pkEstagenmusi != null) || (this.pkEstagenmusi != null && !this.pkEstagenmusi.equals(other.pkEstagenmusi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkEstagenmusi + " ]";
    }
    
}
