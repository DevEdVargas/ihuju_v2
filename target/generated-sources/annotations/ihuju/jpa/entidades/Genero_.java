package ihuju.jpa.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Genero.class)
public abstract class Genero_ {

	public static volatile SingularAttribute<Genero, String> descripcion;
	public static volatile SingularAttribute<Genero, String> codigo;
	public static volatile SingularAttribute<Genero, Integer> pkGenero;
	public static volatile ListAttribute<Genero, Persona> personaList;

}

