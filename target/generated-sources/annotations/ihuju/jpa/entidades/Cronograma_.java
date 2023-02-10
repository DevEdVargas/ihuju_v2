package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cronograma.class)
public abstract class Cronograma_ {

	public static volatile SingularAttribute<Cronograma, String> descripcion;
	public static volatile ListAttribute<Cronograma, Participa> participaList;
	public static volatile SingularAttribute<Cronograma, Date> hora;
	public static volatile SingularAttribute<Cronograma, BigDecimal> pkCronogra;

}

