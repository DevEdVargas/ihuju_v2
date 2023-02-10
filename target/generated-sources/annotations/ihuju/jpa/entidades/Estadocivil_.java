package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estadocivil.class)
public abstract class Estadocivil_ {

	public static volatile SingularAttribute<Estadocivil, String> codigo;
	public static volatile SingularAttribute<Estadocivil, BigDecimal> pkEstadocivil;
	public static volatile ListAttribute<Estadocivil, Persona> personaList;
	public static volatile SingularAttribute<Estadocivil, String> decripcion;

}

