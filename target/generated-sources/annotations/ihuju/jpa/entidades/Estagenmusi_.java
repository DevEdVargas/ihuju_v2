package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estagenmusi.class)
public abstract class Estagenmusi_ {

	public static volatile SingularAttribute<Estagenmusi, Generomusica> fkGeneromusica;
	public static volatile SingularAttribute<Estagenmusi, Establecimiento> fkEstablec;
	public static volatile SingularAttribute<Estagenmusi, BigDecimal> pkEstagenmusi;

}

