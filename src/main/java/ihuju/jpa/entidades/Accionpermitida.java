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
@Table(name = "ACCIONPERMITIDA", catalog = "", schema = "IHUJU", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CODIGO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accionpermitida.findAll", query = "SELECT a FROM Accionpermitida a")
    , @NamedQuery(name = "Accionpermitida.findByPkAccipermitida", query = "SELECT a FROM Accionpermitida a WHERE a.pkAccipermitida = :pkAccipermitida")
    , @NamedQuery(name = "Accionpermitida.findByCodigo", query = "SELECT a FROM Accionpermitida a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Accionpermitida.findByDescripcion", query = "SELECT a FROM Accionpermitida a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Accionpermitida.findByRuta", query = "SELECT a FROM Accionpermitida a WHERE a.ruta = :ruta")})
public class Accionpermitida implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_ACCIPERMITIDA", sequenceName = "SQ_ACCIPERMITIDA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACCIPERMITIDA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_ACCIPERMITIDA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkAccipermitida;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO", nullable = false, length = 20)
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESCRIPCION", nullable = false, length = 500)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "RUTA", nullable = false, length = 500)
    private String ruta;
    @OneToMany(mappedBy = "fkAccipermitida")
    private List<Accionpermitida> accionpermitidaList;
    @JoinColumn(name = "FK_ACCIPERMITIDA", referencedColumnName = "PK_ACCIPERMITIDA")
    @ManyToOne
    private Accionpermitida fkAccipermitida;
    @OneToMany(mappedBy = "fkAccipermitida")
    private List<Accperplan> accperplanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAccipermitida")
    private List<Accperusu> accperusuList;

    public Accionpermitida() {
    }

    public Accionpermitida(BigDecimal pkAccipermitida) {
        this.pkAccipermitida = pkAccipermitida;
    }

    public Accionpermitida(BigDecimal pkAccipermitida, String codigo, String descripcion, String ruta) {
        this.pkAccipermitida = pkAccipermitida;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.ruta = ruta;
    }

    public BigDecimal getPkAccipermitida() {
        return pkAccipermitida;
    }

    public void setPkAccipermitida(BigDecimal pkAccipermitida) {
        this.pkAccipermitida = pkAccipermitida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @XmlTransient
    public List<Accionpermitida> getAccionpermitidaList() {
        return accionpermitidaList;
    }

    public void setAccionpermitidaList(List<Accionpermitida> accionpermitidaList) {
        this.accionpermitidaList = accionpermitidaList;
    }

    public Accionpermitida getFkAccipermitida() {
        return fkAccipermitida;
    }

    public void setFkAccipermitida(Accionpermitida fkAccipermitida) {
        this.fkAccipermitida = fkAccipermitida;
    }

    @XmlTransient
    public List<Accperplan> getAccperplanList() {
        return accperplanList;
    }

    public void setAccperplanList(List<Accperplan> accperplanList) {
        this.accperplanList = accperplanList;
    }

    @XmlTransient
    public List<Accperusu> getAccperusuList() {
        return accperusuList;
    }

    public void setAccperusuList(List<Accperusu> accperusuList) {
        this.accperusuList = accperusuList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAccipermitida != null ? pkAccipermitida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accionpermitida)) {
            return false;
        }
        Accionpermitida other = (Accionpermitida) object;
        if ((this.pkAccipermitida == null && other.pkAccipermitida != null) || (this.pkAccipermitida != null && !this.pkAccipermitida.equals(other.pkAccipermitida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkAccipermitida + "-" + codigo + "-" + descripcion + "-" + ruta;
    }
    
}
