package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Municipio.class)
public abstract class Municipio_ {

	public static volatile SingularAttribute<Municipio, String> codigo;
	public static volatile ListAttribute<Municipio, Persona> personaList;
	public static volatile SingularAttribute<Municipio, Departamento> fkDepartamen;
	public static volatile ListAttribute<Municipio, Establecimiento> establecimientoList;
	public static volatile SingularAttribute<Municipio, BigDecimal> pkMunicipio;
	public static volatile SingularAttribute<Municipio, String> nombre;

}

