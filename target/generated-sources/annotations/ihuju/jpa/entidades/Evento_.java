package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evento.class)
public abstract class Evento_ {

	public static volatile SingularAttribute<Evento, String> descripcion;
	public static volatile SingularAttribute<Evento, Date> fecha;
	public static volatile SingularAttribute<Evento, BigInteger> precio;
	public static volatile ListAttribute<Evento, Participa> participaList;
	public static volatile ListAttribute<Evento, Asiste> asisteList;
	public static volatile ListAttribute<Evento, Reserva> reservaList;
	public static volatile SingularAttribute<Evento, Tipoevento> fkTipoevento;
	public static volatile SingularAttribute<Evento, Establecimiento> fkEstablec;
	public static volatile SingularAttribute<Evento, BigDecimal> pkEvento;
	public static volatile SingularAttribute<Evento, BigInteger> capacidad;

}

