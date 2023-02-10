package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Plantilla.class)
public abstract class Plantilla_ {

	public static volatile SingularAttribute<Plantilla, String> descripcion;
	public static volatile SingularAttribute<Plantilla, String> codigo;
	public static volatile ListAttribute<Plantilla, Accperplan> accperplanList;
	public static volatile SingularAttribute<Plantilla, BigDecimal> pkPlantilla;

}

