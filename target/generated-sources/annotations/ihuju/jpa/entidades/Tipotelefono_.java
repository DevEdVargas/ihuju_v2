package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tipotelefono.class)
public abstract class Tipotelefono_ {

	public static volatile SingularAttribute<Tipotelefono, String> descripcion;
	public static volatile SingularAttribute<Tipotelefono, BigDecimal> pkTiptelefono;
	public static volatile SingularAttribute<Tipotelefono, String> codigo;
	public static volatile ListAttribute<Tipotelefono, Telefono> telefonoList;

}

