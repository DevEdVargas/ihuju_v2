package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pais.class)
public abstract class Pais_ {

	public static volatile ListAttribute<Pais, Departamento> departamentoList;
	public static volatile SingularAttribute<Pais, String> codigo;
	public static volatile SingularAttribute<Pais, String> nombre;
	public static volatile SingularAttribute<Pais, BigDecimal> pkPais;

}

