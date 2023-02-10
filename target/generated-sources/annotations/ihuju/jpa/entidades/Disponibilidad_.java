package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Disponibilidad.class)
public abstract class Disponibilidad_ {

	public static volatile SingularAttribute<Disponibilidad, BigDecimal> pkDisponibilidad;
	public static volatile SingularAttribute<Disponibilidad, Date> horario;
	public static volatile ListAttribute<Disponibilidad, Estadispo> estadispoList;

}

