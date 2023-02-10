package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Establecimiento.class)
public abstract class Establecimiento_ {

	public static volatile SingularAttribute<Establecimiento, Municipio> fkMunicilugar;
	public static volatile SingularAttribute<Establecimiento, BigInteger> precio;
	public static volatile ListAttribute<Establecimiento, Estatipgen> estatipgenList;
	public static volatile ListAttribute<Establecimiento, Estadispo> estadispoList;
	public static volatile SingularAttribute<Establecimiento, String> direccion;
	public static volatile SingularAttribute<Establecimiento, String> nit;
	public static volatile ListAttribute<Establecimiento, Evento> eventoList;
	public static volatile SingularAttribute<Establecimiento, Duenio> fkDuenio;
	public static volatile ListAttribute<Establecimiento, Estagenmusi> estagenmusiList;
	public static volatile SingularAttribute<Establecimiento, String> nombre;
	public static volatile SingularAttribute<Establecimiento, BigDecimal> pkEstablec;
	public static volatile SingularAttribute<Establecimiento, BigInteger> capacidad;

}

