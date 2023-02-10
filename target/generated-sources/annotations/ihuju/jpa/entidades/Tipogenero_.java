package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tipogenero.class)
public abstract class Tipogenero_ {

	public static volatile SingularAttribute<Tipogenero, String> descripcion;
	public static volatile ListAttribute<Tipogenero, Estatipgen> estatipgenList;
	public static volatile SingularAttribute<Tipogenero, BigDecimal> pkTipogenero;
	public static volatile SingularAttribute<Tipogenero, String> nombre;

}

