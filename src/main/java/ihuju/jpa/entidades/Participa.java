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
@Table(name = "PARTICIPA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participa.findAll", query = "SELECT p FROM Participa p")
    , @NamedQuery(name = "Participa.findByPkParticipa", query = "SELECT p FROM Participa p WHERE p.pkParticipa = :pkParticipa")})
public class Participa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_PARTICIPA", sequenceName = "SQ_PARTICIPA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PARTICIPA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_PARTICIPA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkParticipa;
    @JoinColumn(name = "FK_ARTISTA", referencedColumnName = "PK_ARTISTA", nullable = false)
    @ManyToOne(optional = false)
    private Artista fkArtista;
    @JoinColumn(name = "FK_CRONOGRA", referencedColumnName = "PK_CRONOGRA", nullable = false)
    @ManyToOne(optional = false)
    private Cronograma fkCronogra;
    @JoinColumn(name = "FK_EVENTO", referencedColumnName = "PK_EVENTO", nullable = false)
    @ManyToOne(optional = false)
    private Evento fkEvento;

    public Participa() {
    }

    public Participa(BigDecimal pkParticipa) {
        this.pkParticipa = pkParticipa;
    }

    public BigDecimal getPkParticipa() {
        return pkParticipa;
    }

    public void setPkParticipa(BigDecimal pkParticipa) {
        this.pkParticipa = pkParticipa;
    }

    public Artista getFkArtista() {
        return fkArtista;
    }

    public void setFkArtista(Artista fkArtista) {
        this.fkArtista = fkArtista;
    }

    public Cronograma getFkCronogra() {
        return fkCronogra;
    }

    public void setFkCronogra(Cronograma fkCronogra) {
        this.fkCronogra = fkCronogra;
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
        hash += (pkParticipa != null ? pkParticipa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participa)) {
            return false;
        }
        Participa other = (Participa) object;
        if ((this.pkParticipa == null && other.pkParticipa != null) || (this.pkParticipa != null && !this.pkParticipa.equals(other.pkParticipa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkParticipa + "-";
    }
    
}
