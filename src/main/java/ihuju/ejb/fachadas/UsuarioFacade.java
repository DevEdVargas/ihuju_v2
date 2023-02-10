/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;

import ihuju.jpa.entidades.Usuario;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario buscarUsuario(String login, String pass) {
        Query consulta = em.createNamedQuery("Usuario.findByNombreusuario");
        consulta.setParameter("nombreusuario", login);
        consulta.setParameter("contrasena", pass);

        try {
            Usuario oUsuario = (Usuario) consulta.getSingleResult();
            em.refresh(oUsuario);
            return oUsuario;
        } catch (NoResultException e) {
            return null;
        }
    }

    public String obtenerNombreCompletoUsuarioPorId(BigDecimal UsuarioId) {
        StringBuilder sbSQL = new StringBuilder(" Select login from U where pk_Usuario = ");
        sbSQL.append(UsuarioId);
        Query consulta = em.createNamedQuery(sbSQL.toString());
        String strNombreCompleto = "";

        try {
            strNombreCompleto = consulta.getSingleResult().toString();
        } catch (NoResultException e) {
            return strNombreCompleto;
        }
        return strNombreCompleto;

    }

    public Usuario autenticar(String login, String password,
            ihuju.ejb.fachadas.EstadousuarioFacade fachadaEstadoUsuario) {

        FacesMessage msg = null;
        Usuario oUsuario = buscarUsuario(login, password);
        if (oUsuario != null) {
            boolean blnEstadoUsuario= fachadaEstadoUsuario.estadoUsuario(oUsuario.getPkUsuario());
            if (blnEstadoUsuario) {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, " Bienvenido", login);
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return oUsuario;
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario Inactivo", login);

            }

        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Credenciales Inválidas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
    }
    
    public boolean validarUsuario(String usuario) {
        Usuario x = null;
        try {
            x = em.createNamedQuery("Usuario.findByNombreusu", Usuario.class).setParameter("nombre", usuario).getSingleResult();
        } catch (Exception e) {
        }
        return x == null;
    }

    
    
    
}
