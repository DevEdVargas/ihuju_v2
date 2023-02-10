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
@Table(name = "ESTATIPGEN", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estatipgen.findAll", query = "SELECT e FROM Estatipgen e")
    , @NamedQuery(name = "Estatipgen.findByPkEstatipgen", query = "SELECT e FROM Estatipgen e WHERE e.pkEstatipgen = :pkEstatipgen")})
public class Estatipgen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ESTATIPGEN", sequenceName = "SQ_ESTATIPGEN", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ESTATIPGEN")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ESTATIPGEN", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkEstatipgen;
    @JoinColumn(name = "FK_ESTABLEC", referencedColumnName = "PK_ESTABLEC", nullable = false)
    @ManyToOne(optional = false)
    private Establecimiento fkEstablec;
    @JoinColumn(name = "FK_TIPOGENERO", referencedColumnName = "PK_TIPOGENERO", nullable = false)
    @ManyToOne(optional = false)
    private Tipogenero fkTipogenero;

    public Estatipgen() {
    }

    public Estatipgen(BigDecimal pkEstatipgen) {
        this.pkEstatipgen = pkEstatipgen;
    }

    public BigDecimal getPkEstatipgen() {
        return pkEstatipgen;
    }

    public void setPkEstatipgen(BigDecimal pkEstatipgen) {
        this.pkEstatipgen = pkEstatipgen;
    }

    public Establecimiento getFkEstablec() {
        return fkEstablec;
    }

    public void setFkEstablec(Establecimiento fkEstablec) {
        this.fkEstablec = fkEstablec;
    }

    public Tipogenero getFkTipogenero() {
        return fkTipogenero;
    }

    public void setFkTipogenero(Tipogenero fkTipogenero) {
        this.fkTipogenero = fkTipogenero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEstatipgen != null ? pkEstatipgen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estatipgen)) {
            return false;
        }
        Estatipgen other = (Estatipgen) object;
        if ((this.pkEstatipgen == null && other.pkEstatipgen != null) || (this.pkEstatipgen != null && !this.pkEstatipgen.equals(other.pkEstatipgen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkEstatipgen + " ]";
    }
    
}
