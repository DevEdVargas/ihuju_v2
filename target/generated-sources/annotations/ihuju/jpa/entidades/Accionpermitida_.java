package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Accionpermitida.class)
public abstract class Accionpermitida_ {

	public static volatile SingularAttribute<Accionpermitida, String> descripcion;
	public static volatile SingularAttribute<Accionpermitida, String> codigo;
	public static volatile SingularAttribute<Accionpermitida, String> ruta;
	public static volatile ListAttribute<Accionpermitida, Accperplan> accperplanList;
	public static volatile ListAttribute<Accionpermitida, Accperusu> accperusuList;
	public static volatile ListAttribute<Accionpermitida, Accionpermitida> accionpermitidaList;
	public static volatile SingularAttribute<Accionpermitida, BigDecimal> pkAccipermitida;
	public static volatile SingularAttribute<Accionpermitida, Accionpermitida> fkAccipermitida;

}

