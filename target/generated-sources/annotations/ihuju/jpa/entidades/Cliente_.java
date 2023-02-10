package ihuju.jpa.entidades;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile ListAttribute<Cliente, Asiste> asisteList;
	public static volatile ListAttribute<Cliente, Reserva> reservaList;
	public static volatile SingularAttribute<Cliente, Usuario> fkUsuario;
	public static volatile SingularAttribute<Cliente, BigDecimal> pkCliente;

}

