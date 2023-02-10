package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estado.class)
public abstract class Estado_ {

	public static volatile SingularAttribute<Estado, String> descripcion;
	public static volatile SingularAttribute<Estado, String> codigo;
	public static volatile ListAttribute<Estado, Estadousuario> estadousuarioList;
	public static volatile SingularAttribute<Estado, BigDecimal> pkEstado;

}

