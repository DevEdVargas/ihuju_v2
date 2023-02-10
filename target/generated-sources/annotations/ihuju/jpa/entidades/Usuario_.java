package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Usuario.class)
public abstract class Usuario_ {

	public static volatile SingularAttribute<Usuario, String> nombreusuario;
	public static volatile ListAttribute<Usuario, Cliente> clienteList;
	public static volatile SingularAttribute<Usuario, BigInteger> tipousuarioenum;
	public static volatile ListAttribute<Usuario, Estadousuario> estadousuarioList;
	public static volatile SingularAttribute<Usuario, String> codactivacion;
	public static volatile ListAttribute<Usuario, Accperusu> accperusuList;
	public static volatile ListAttribute<Usuario, Duenio> duenioList;
	public static volatile SingularAttribute<Usuario, BigDecimal> pkUsuario;
	public static volatile SingularAttribute<Usuario, String> contrasena;
	public static volatile ListAttribute<Usuario, Artista> artistaList;
	public static volatile SingularAttribute<Usuario, Persona> fkPersona;
	public static volatile SingularAttribute<Usuario, Date> ultimoacceso;

}

