package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Participa.class)
public abstract class Participa_ {

	public static volatile SingularAttribute<Participa, BigDecimal> pkParticipa;
	public static volatile SingularAttribute<Participa, Cronograma> fkCronogra;
	public static volatile SingularAttribute<Participa, Evento> fkEvento;
	public static volatile SingularAttribute<Participa, Artista> fkArtista;

}

