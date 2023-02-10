package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tipoidentificacion.class)
public abstract class Tipoidentificacion_ {

	public static volatile SingularAttribute<Tipoidentificacion, String> descripcion;
	public static volatile SingularAttribute<Tipoidentificacion, BigDecimal> pkTipoidentifi;
	public static volatile SingularAttribute<Tipoidentificacion, String> codigo;
	public static volatile ListAttribute<Tipoidentificacion, Persona> personaList;

}

