/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
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
@Table(name = "ACCPERPLAN", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accperplan.findAll", query = "SELECT a FROM Accperplan a")
    , @NamedQuery(name = "Accperplan.findByPkAcciperpla", query = "SELECT a FROM Accperplan a WHERE a.pkAcciperpla = :pkAcciperpla")})
public class Accperplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SQ_ACCIPERPLAN", sequenceName = "SQ_ACCIPERPLAN", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCIPERPLAN")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ACCIPERPLA", nullable = false)
    private Integer pkAcciperpla;
    @JoinColumn(name = "FK_ACCIPERMITIDA", referencedColumnName = "PK_ACCIPERMITIDA")
    @ManyToOne
    private Accionpermitida fkAccipermitida;
    @JoinColumn(name = "FK_PLANTILLA", referencedColumnName = "PK_PLANTILLA", nullable = false)
    @ManyToOne(optional = false)
    private Plantilla fkPlantilla;

    public Accperplan() {
    }

    public Accperplan(Integer pkAcciperpla) {
        this.pkAcciperpla = pkAcciperpla;
    }

    public Integer getPkAcciperpla() {
        return pkAcciperpla;
    }

    public void setPkAcciperpla(Integer pkAcciperpla) {
        this.pkAcciperpla = pkAcciperpla;
    }

    public Accionpermitida getFkAccipermitida() {
        return fkAccipermitida;
    }

    public void setFkAccipermitida(Accionpermitida fkAccipermitida) {
        this.fkAccipermitida = fkAccipermitida;
    }

    public Plantilla getFkPlantilla() {
        return fkPlantilla;
    }

    public void setFkPlantilla(Plantilla fkPlantilla) {
        this.fkPlantilla = fkPlantilla;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAcciperpla != null ? pkAcciperpla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accperplan)) {
            return false;
        }
        Accperplan other = (Accperplan) object;
        if ((this.pkAcciperpla == null && other.pkAcciperpla != null) || (this.pkAcciperpla != null && !this.pkAcciperpla.equals(other.pkAcciperpla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkAcciperpla + "-" + fkAccipermitida.getDescripcion() + "-" +fkPlantilla.getDescripcion();
    }
    
}
