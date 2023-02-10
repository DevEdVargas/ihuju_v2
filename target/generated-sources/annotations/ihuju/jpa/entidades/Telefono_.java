package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Telefono.class)
public abstract class Telefono_ {

	public static volatile SingularAttribute<Telefono, BigDecimal> pkTelefono;
	public static volatile SingularAttribute<Telefono, BigInteger> numero;
	public static volatile SingularAttribute<Telefono, Persona> fkPersona;
	public static volatile SingularAttribute<Telefono, Tipotelefono> fkTiptelefono;

}

