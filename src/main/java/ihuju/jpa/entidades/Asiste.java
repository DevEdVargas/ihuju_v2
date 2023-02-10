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
@Table(name = "ASISTE", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asiste.findAll", query = "SELECT a FROM Asiste a")
    , @NamedQuery(name = "Asiste.findByPkAsiste", query = "SELECT a FROM Asiste a WHERE a.pkAsiste = :pkAsiste")})
public class Asiste implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ASISTE", sequenceName = "SQ_ASISTE", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ASISTE")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ASISTE", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkAsiste;
    @JoinColumn(name = "FK_CLIENTE", referencedColumnName = "PK_CLIENTE", nullable = false)
    @ManyToOne(optional = false)
    private Cliente fkCliente;
    @JoinColumn(name = "FK_EVENTO", referencedColumnName = "PK_EVENTO", nullable = false)
    @ManyToOne(optional = false)
    private Evento fkEvento;

    public Asiste() {
    }

    public Asiste(BigDecimal pkAsiste) {
        this.pkAsiste = pkAsiste;
    }

    public BigDecimal getPkAsiste() {
        return pkAsiste;
    }

    public void setPkAsiste(BigDecimal pkAsiste) {
        this.pkAsiste = pkAsiste;
    }

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Evento getFkEvento() {
        return fkEvento;
    }

    public void setFkEvento(Evento fkEvento) {
        this.fkEvento = fkEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAsiste != null ? pkAsiste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asiste)) {
            return false;
        }
        Asiste other = (Asiste) object;
        if ((this.pkAsiste == null && other.pkAsiste != null) || (this.pkAsiste != null && !this.pkAsiste.equals(other.pkAsiste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fkCliente.getFkUsuario().getFkPersona().getIdentificacion() + " - "+  fkCliente.getFkUsuario().getFkPersona().getNombre();
    }
    
}
