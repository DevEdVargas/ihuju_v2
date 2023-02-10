package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reserva.class)
public abstract class Reserva_ {

	public static volatile SingularAttribute<Reserva, BigInteger> canpersonas;
	public static volatile SingularAttribute<Reserva, Cliente> fkCliente;
	public static volatile SingularAttribute<Reserva, Evento> fkEvento;
	public static volatile SingularAttribute<Reserva, Date> hora;
	public static volatile SingularAttribute<Reserva, BigDecimal> pkReserva;

}

