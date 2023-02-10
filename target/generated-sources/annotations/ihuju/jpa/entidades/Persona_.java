package ihuju.jpa.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, Estadocivil> fkEstadocivil;
	public static volatile ListAttribute<Persona, Usuario> usuarioList;
	public static volatile SingularAttribute<Persona, Date> fechanacimiento;
	public static volatile SingularAttribute<Persona, BigDecimal> pkPersona;
	public static volatile SingularAttribute<Persona, String> apellido;
	public static volatile SingularAttribute<Persona, Municipio> fkMunicipio;
	public static volatile ListAttribute<Persona, Telefono> telefonoList;
	public static volatile SingularAttribute<Persona, String> identificacion;
	public static volatile SingularAttribute<Persona, Genero> fkGenero;
	public static volatile SingularAttribute<Persona, Tipoidentificacion> fkTipoidentifi;
	public static volatile SingularAttribute<Persona, String> nombre;
	public static volatile SingularAttribute<Persona, String> email;

}

