package ihuju.jsf.controladores.util;

import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import ihuju.jpa.entidades.Usuario;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import ihuju.jpa.entidades.Artista;
import ihuju.jpa.entidades.Tipoartista;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.SystemException;

@Named("registroArtistaController")
@SessionScoped
public class RegistroArtistaController implements Serializable {

    private Usuario currentUsuario;
    private Artista currentArtista;
    private Tipoartista currentTipoArtista;

    @Resource
    private UserTransaction oTransaction;

    @EJB
    private ihuju.ejb.fachadas.UsuarioFacade ejbFacadeUsuarioFacade;

    @EJB
    private ihuju.ejb.fachadas.ArtistaFacade ejbFacadeArtistaFacade;

    @EJB
    private ihuju.ejb.fachadas.TipoartistaFacade ejbTipoartistaFacade;

    private Session oSession;

    public RegistroArtistaController() {
        oSession = new Session();
    }

    public Session getoSession() {
        return oSession;
    }

    public void setoSession(Session oSession) {
        this.oSession = oSession;
    }

    public Usuario getSelectedUsuario() {
        if (currentUsuario == null) {
            currentUsuario = new Usuario();
        }
        return currentUsuario;
    }

    public Artista getSeletedArtista() {
        if (currentArtista == null) {
            currentArtista = new Artista();
        }
        return currentArtista;
    }

    public Tipoartista getSelecTipoartista() {
        if (currentTipoArtista == null) {
            currentTipoArtista = new Tipoartista();
        }
        return currentTipoArtista;
    }

    
    
    public String prepareCreate() {
        currentUsuario = new Usuario();
        currentArtista = new Artista();
        currentTipoArtista = new Tipoartista();

        return "menuUsuario";
    }

    public Usuario obtenerUsuarioLogueado() {
        return getoSession().obtenerUsuarioLogueado();
    }

    public String create() throws IOException {

        try {
            oTransaction.begin();
            //registro Artista
            

            currentUsuario = (Usuario) obtenerUsuarioLogueado();
            String msg = "";
            if (!getEjbFacadeArtistaFacade().validarUsuario(currentUsuario.getPkUsuario())) {
                msg += "Tipo Artista ya existe.<br>";
            }
             if (!msg.equals("")) {
                throw new Exception(msg);
            }
            getCurrentArtista().setFkUsuario(currentUsuario);
            getEjbFacadeArtistaFacade().create(currentArtista);
            
       
            
            oTransaction.commit();
            
            JsfUtil.addSuccessMessage("Guardado");
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage("error");
            //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("mensajes/Bundle").getString("PersistenceErrorOccured"));
            try {
                //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("mensajes/Bundle").getString("PersistenceErrorOccured"));++
                oTransaction.rollback();
                return null;
            } catch (SecurityException ex) {
                Logger.getLogger(RegistroArtistaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(RegistroArtistaController.class.getName()).log(Level.SEVERE, null, ex);
            }
            JsfUtil.addErrorMessage(e, e.getMessage());
            return null;
        }

    }

    /**
     * @return the currentUsuario
     */
    public Usuario getCurrentUsuario() {
        return currentUsuario;
    }

    /**
     * @return the currentArtista
     */
    public Artista getCurrentArtista() {
        return currentArtista;
    }

    /**
     * @return the oTransaction
     */
    public UserTransaction getoTransaction() {
        return oTransaction;
    }

    /**
     * @return the ejbFacadeUsuarioFacade
     */
    public ihuju.ejb.fachadas.UsuarioFacade getEjbFacadeUsuarioFacade() {
        return ejbFacadeUsuarioFacade;
    }

    /**
     * @return the ejbFacadeArtistaFacade
     */
    public ihuju.ejb.fachadas.ArtistaFacade getEjbFacadeArtistaFacade() {
        return ejbFacadeArtistaFacade;
    }

    /**
     * @return the ejbTipoartistaFacade
     */
    public ihuju.ejb.fachadas.TipoartistaFacade getEjbTipoartistaFacade() {
        return ejbTipoartistaFacade;
    }

}
