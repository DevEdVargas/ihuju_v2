package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Duenio.class)
public abstract class Duenio_ {

	public static volatile SingularAttribute<Duenio, BigDecimal> pkDuenio;
	public static volatile SingularAttribute<Duenio, Usuario> fkUsuario;
	public static volatile ListAttribute<Duenio, Establecimiento> establecimientoList;

}

