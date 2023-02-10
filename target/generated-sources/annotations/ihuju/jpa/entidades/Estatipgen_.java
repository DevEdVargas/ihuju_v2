package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estatipgen.class)
public abstract class Estatipgen_ {

	public static volatile SingularAttribute<Estatipgen, BigDecimal> pkEstatipgen;
	public static volatile SingularAttribute<Estatipgen, Establecimiento> fkEstablec;
	public static volatile SingularAttribute<Estatipgen, Tipogenero> fkTipogenero;

}

