package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departamento.class)
public abstract class Departamento_ {

	public static volatile SingularAttribute<Departamento, String> codigo;
	public static volatile SingularAttribute<Departamento, Pais> fkPais;
	public static volatile ListAttribute<Departamento, Municipio> municipioList;
	public static volatile SingularAttribute<Departamento, BigDecimal> pkDepartamen;
	public static volatile SingularAttribute<Departamento, String> nombre;

}

