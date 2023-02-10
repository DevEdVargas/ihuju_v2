package ihuju.jsf.controladores.util;

import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import ihuju.jpa.entidades.Usuario;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import ihuju.jpa.entidades.Departamento;
import ihuju.jpa.entidades.Disponibilidad;
import ihuju.jpa.entidades.Duenio;
import ihuju.jpa.entidades.Establecimiento;
import ihuju.jpa.entidades.Estadispo;
import ihuju.jpa.entidades.Estagenmusi;
import ihuju.jpa.entidades.Estatipgen;
import ihuju.jpa.entidades.Generomusica;
import ihuju.jpa.entidades.Persona;
import ihuju.jpa.entidades.Tipogenero;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.SystemException;

@Named("registroEventoController")
@SessionScoped
public class RegistroEventoController implements Serializable {

    private Usuario currentUsuario;
    private Duenio currentDuenio;
    private Establecimiento currentEstablecimiento;


    @Resource
    protected UserTransaction oTransaction;

    @EJB
    private ihuju.ejb.fachadas.DuenioFacade ejbFacadeDuenioFacade;

    @EJB
    private ihuju.ejb.fachadas.UsuarioFacade ejbFacadeUsuarioFacade;

    @EJB
    private ihuju.ejb.fachadas.EstablecimientoFacade ejbFacadeEstablecimientoFacade;

    @EJB
    private ihuju.ejb.fachadas.GeneromusicaFacade ejbFacadeGeneromusicaFacade;

    @EJB
    private ihuju.ejb.fachadas.EstatipgenFacade oEjbEstatipgenFacade;

    @EJB
    private ihuju.ejb.fachadas.EstagenmusiFacade ejbFacadeEstagenmusiFacade;

    @EJB
    private ihuju.ejb.fachadas.EstadispoFacade ejbFacadeEstadispoFacade;

    @EJB
    private ihuju.ejb.fachadas.TipogeneroFacade ejbFacadeTipogeneroFacade;

    @EJB
    private ihuju.ejb.fachadas.DisponibilidadFacade ejbFacadeDisponibilidadFacade;

    @EJB
    private ihuju.ejb.fachadas.DepartamentoFacade oEjbFacadeDepartamentoFacade;

    private Session oSession;

    

    public RegistroEventoController() {
        oSession = new Session();
    }
    
    
    public Session getoSession() {
        return oSession;
    }

    public void setoSession(Session oSession) {
        this.oSession = oSession;
    }
    

//    public Departamento getSelectedDepartamento() {
//        if (departamento == null) {
//            departamento = new Departamento();
//        }
//        return departamento;
//    }
//
//    public Usuario getSelectedUsuario() {
//        if (currentUsuario == null) {
//            currentUsuario = new Usuario();
//        }
//        return currentUsuario;
//    }
//
//    public Duenio getSelectedDuenio() {
//        if (currentDuenio == null) {
//            currentDuenio = new Duenio();
//        }
//        return currentDuenio;
//    }
//
//    public Establecimiento getSelectedEstablecimiento() {
//        if (currentEstablecimiento == null) {
//            currentEstablecimiento = new Establecimiento();
//        }
//        return currentEstablecimiento;
//    }
//
//    public Generomusica getSelectedGeneromusica() {
//        if (currentGeneromusica == null) {
//            currentGeneromusica = new Generomusica();
//        }
//        return currentGeneromusica;
//    }
//
//    public Estatipgen getSelectedEstatipgen() {
//        if (currentEstatipgen == null) {
//            currentEstatipgen = new Estatipgen();
//        }
//        return currentEstatipgen;
//    }
//
//    public Estagenmusi getSelectedEstagenmusi() {
//        if (currentEstagenmusi == null) {
//            currentEstagenmusi = new Estagenmusi();
//        }
//        return currentEstagenmusi;
//    }
//
//    public Tipogenero getSelectedTipogenero() {
//        if (currentTipogenero == null) {
//            currentTipogenero = new Tipogenero();
//        }
//        return currentTipogenero;
//    }
//
//    public Estadispo getCurrentEstadispo() {
//        if (currentEstadispo == null) {
//            currentEstadispo = new Estadispo();
//        }
//        return currentEstadispo;
//    }
//
//    public Disponibilidad getSelectedDisponibilidad() {
//        if (currentDisponibilidad == null) {
//            currentDisponibilidad = new Disponibilidad();
//        }
//        return currentDisponibilidad;
//    }
//
//    public String prepareCreate() {
//        currentUsuario = new Usuario();
//        currentDuenio = new Duenio();
//        currentEstablecimiento = new Establecimiento();
//        currentGeneromusica = new Generomusica();
//        currentEstatipgen = new Estatipgen();
//        currentEstagenmusi = new Estagenmusi();
//        currentTipogenero = new Tipogenero();
//        currentEstadispo = new Estadispo();
//        currentDisponibilidad = new Disponibilidad();
//        departamento = null;
//
//        return "menuUsuario";
//    }
//    
//    public Usuario obtenerUsuarioLogueado() {
//        return oSession.obtenerUsuarioLogueado();
//    }
//
//    public String create() throws IOException {
//        
//        try {
//            
//            
//            
//            
//            oTransaction.begin();
//            //registro Dueño
//            currentDuenio = new Duenio();
//            currentUsuario = (Usuario) obtenerUsuarioLogueado();
//            currentDuenio.setFkUsuario(currentUsuario);
//            String msg = "";
//            if (!getEjbFacadeDuenioFacade().validarUsuario(currentUsuario.getPkUsuario())) {
//                msg += "Tipo Dueño ya existe.<br>";
//            }
//             if (!msg.equals("")) {
//                throw new Exception(msg);
//            }
//            getEjbFacadeDuenioFacade().create(currentDuenio);
//            //registro establesimiento
//            currentEstablecimiento.setFkDuenio(currentDuenio);
//            getEjbFacadeEstablecimientoFacade().create(currentEstablecimiento);
//            //registro establesimiento tipo genero
//            currentEstatipgen.setFkEstablec(currentEstablecimiento);
//            getoEjbEstatipgenFacade().create(currentEstatipgen);
//            //registro establesimiento tipo musica
//            currentEstagenmusi.setFkEstablec(currentEstablecimiento);
//            getEjbFacadeEstagenmusiFacade().create(currentEstagenmusi);
//           
//            oTransaction.commit();
//            
//            JsfUtil.addSuccessMessage("Guardado");
//            return prepareCreate();
//        } catch (Exception e) {
//            //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("mensajes/Bundle").getString("PersistenceErrorOccured"));
//            try {
//                //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("mensajes/Bundle").getString("PersistenceErrorOccured"));++
//                oTransaction.rollback();
//                return null;
//            } catch (SecurityException ex) {
//                Logger.getLogger(RegistroDuenoController.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SystemException ex) {
//                Logger.getLogger(RegistroDuenoController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            JsfUtil.addErrorMessage(e, e.getMessage());
//            return null;
//        }
//
//    }
//
//    /**
//     * @return the ejbFacadeDuenioFacade
//     */
//    public ihuju.ejb.fachadas.DuenioFacade getEjbFacadeDuenioFacade() {
//        return ejbFacadeDuenioFacade;
//    }
//
//    /**
//     * @return the ejbFacadeUsuarioFacade
//     */
//    public ihuju.ejb.fachadas.UsuarioFacade getEjbFacadeUsuarioFacade() {
//        return ejbFacadeUsuarioFacade;
//    }
//
//    /**
//     * @return the ejbFacadeEstablecimientoFacade
//     */
//    public ihuju.ejb.fachadas.EstablecimientoFacade getEjbFacadeEstablecimientoFacade() {
//        return ejbFacadeEstablecimientoFacade;
//    }
//
//    /**
//     * @return the ejbFacadeGeneromusicaFacade
//     */
//    public ihuju.ejb.fachadas.GeneromusicaFacade getEjbFacadeGeneromusicaFacade() {
//        return ejbFacadeGeneromusicaFacade;
//    }
//
//    /**
//     * @return the oEjbEstatipgenFacade
//     */
//    public ihuju.ejb.fachadas.EstatipgenFacade getoEjbEstatipgenFacade() {
//        return oEjbEstatipgenFacade;
//    }
//
//    /**
//     * @return the ejbFacadeEstagenmusiFacade
//     */
//    public ihuju.ejb.fachadas.EstagenmusiFacade getEjbFacadeEstagenmusiFacade() {
//        return ejbFacadeEstagenmusiFacade;
//    }
//
//    /**
//     * @return the ejbFacadeEstadispoFacade
//     */
//    public ihuju.ejb.fachadas.EstadispoFacade getEjbFacadeEstadispoFacade() {
//        return ejbFacadeEstadispoFacade;
//    }
//
//    /**
//     * @return the ejbFacadeTipogeneroFacade
//     */
//    public ihuju.ejb.fachadas.TipogeneroFacade getEjbFacadeTipogeneroFacade() {
//        return ejbFacadeTipogeneroFacade;
//    }
//
//    /**
//     * @return the ejbFacadeDisponibilidadFacade
//     */
//    public ihuju.ejb.fachadas.DisponibilidadFacade getEjbFacadeDisponibilidadFacade() {
//        return ejbFacadeDisponibilidadFacade;
//    }
//
//    /**
//     * @return the oEjbFacadeDepartamentoFacade
//     */
//    public ihuju.ejb.fachadas.DepartamentoFacade getoEjbFacadeDepartamentoFacade() {
//        return oEjbFacadeDepartamentoFacade;
//    }
//
//    

}
