package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estadousuario.class)
public abstract class Estadousuario_ {

	public static volatile SingularAttribute<Estadousuario, Date> fechainicio;
	public static volatile SingularAttribute<Estadousuario, Estado> fkEstado;
	public static volatile SingularAttribute<Estadousuario, Usuario> fkUsuario;
	public static volatile SingularAttribute<Estadousuario, BigDecimal> pkEstadousuario;
	public static volatile SingularAttribute<Estadousuario, Date> fechafin;

}

