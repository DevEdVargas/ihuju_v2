/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jpa.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alejandro
 */
@Entity
@Table(name = "RESERVA", catalog = "", schema = "IHUJU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByPkReserva", query = "SELECT r FROM Reserva r WHERE r.pkReserva = :pkReserva")
    , @NamedQuery(name = "Reserva.findByHora", query = "SELECT r FROM Reserva r WHERE r.hora = :hora")
    , @NamedQuery(name = "Reserva.findByCanpersonas", query = "SELECT r FROM Reserva r WHERE r.canpersonas = :canpersonas")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "SQ_RESERVA", sequenceName = "SQ_RESERVA", initialValue = 1, allocationSize = 1) 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RESERVA")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PK_RESERVA", nullable = false, precision = 0, scale = -127)
    private BigDecimal pkReserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANPERSONAS", nullable = false)
    private BigInteger canpersonas;
    @JoinColumn(name = "FK_CLIENTE", referencedColumnName = "PK_CLIENTE", nullable = false)
    @ManyToOne(optional = false)
    private Cliente fkCliente;
    @JoinColumn(name = "FK_EVENTO", referencedColumnName = "PK_EVENTO", nullable = false)
    @ManyToOne(optional = false)
    private Evento fkEvento;

    public Reserva() {
    }

    public Reserva(BigDecimal pkReserva) {
        this.pkReserva = pkReserva;
    }

    public Reserva(BigDecimal pkReserva, Date hora, BigInteger canpersonas) {
        this.pkReserva = pkReserva;
        this.hora = hora;
        this.canpersonas = canpersonas;
    }

    public BigDecimal getPkReserva() {
        return pkReserva;
    }

    public void setPkReserva(BigDecimal pkReserva) {
        this.pkReserva = pkReserva;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public BigInteger getCanpersonas() {
        return canpersonas;
    }

    public void setCanpersonas(BigInteger canpersonas) {
        this.canpersonas = canpersonas;
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
        hash += (pkReserva != null ? pkReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.pkReserva == null && other.pkReserva != null) || (this.pkReserva != null && !this.pkReserva.equals(other.pkReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pkReserva + "-";
    }
    
}
