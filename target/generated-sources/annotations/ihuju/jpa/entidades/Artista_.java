package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Artista.class)
public abstract class Artista_ {

	public static volatile SingularAttribute<Artista, BigDecimal> pkArtista;
	public static volatile SingularAttribute<Artista, String> apodo;
	public static volatile SingularAttribute<Artista, String> generomusical;
	public static volatile ListAttribute<Artista, Participa> participaList;
	public static volatile SingularAttribute<Artista, Usuario> fkUsuario;
	public static volatile SingularAttribute<Artista, String> experiencia;
	public static volatile SingularAttribute<Artista, Tipoartista> fkTipartis;

}

