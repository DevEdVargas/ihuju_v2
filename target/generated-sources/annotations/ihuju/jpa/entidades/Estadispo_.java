package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estadispo.class)
public abstract class Estadispo_ {

	public static volatile SingularAttribute<Estadispo, BigDecimal> pkEstadispo;
	public static volatile SingularAttribute<Estadispo, Disponibilidad> fkDisponibilidad;
	public static volatile SingularAttribute<Estadispo, Establecimiento> fkEstablec;

}

