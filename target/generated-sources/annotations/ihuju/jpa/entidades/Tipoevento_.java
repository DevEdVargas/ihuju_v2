package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tipoevento.class)
public abstract class Tipoevento_ {

	public static volatile SingularAttribute<Tipoevento, String> descripcion;
	public static volatile ListAttribute<Tipoevento, Evento> eventoList;
	public static volatile SingularAttribute<Tipoevento, BigDecimal> pkTipoevento;
	public static volatile SingularAttribute<Tipoevento, String> nombre;

}

