package ihuju.jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Accperplan.class)
public abstract class Accperplan_ {

	public static volatile SingularAttribute<Accperplan, Plantilla> fkPlantilla;
	public static volatile SingularAttribute<Accperplan, Integer> pkAcciperpla;
	public static volatile SingularAttribute<Accperplan, Accionpermitida> fkAccipermitida;

}

