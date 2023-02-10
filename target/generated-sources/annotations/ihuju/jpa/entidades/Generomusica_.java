package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Generomusica.class)
public abstract class Generomusica_ {

	public static volatile SingularAttribute<Generomusica, String> descripcion;
	public static volatile SingularAttribute<Generomusica, BigDecimal> pkGeneromusica;
	public static volatile ListAttribute<Generomusica, Estagenmusi> estagenmusiList;
	public static volatile SingularAttribute<Generomusica, String> nombre;

}

