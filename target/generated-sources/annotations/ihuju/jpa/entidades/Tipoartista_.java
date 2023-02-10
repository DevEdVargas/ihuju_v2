package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tipoartista.class)
public abstract class Tipoartista_ {

	public static volatile SingularAttribute<Tipoartista, String> descripcion;
	public static volatile SingularAttribute<Tipoartista, BigDecimal> pkTipartis;
	public static volatile ListAttribute<Tipoartista, Artista> artistaList;
	public static volatile SingularAttribute<Tipoartista, String> nombre;

}

