package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Asiste.class)
public abstract class Asiste_ {

	public static volatile SingularAttribute<Asiste, Cliente> fkCliente;
	public static volatile SingularAttribute<Asiste, Evento> fkEvento;
	public static volatile SingularAttribute<Asiste, BigDecimal> pkAsiste;

}

