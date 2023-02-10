package ihuju.jsf.controladores.util;

import javax.annotation.Resource;
import javax.transaction.UserTransaction;
import ihuju.jpa.entidades.Persona;
import ihuju.jpa.entidades.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import ihuju.jpa.entidades.Estadousuario;
import ihuju.jpa.entidades.Departamento;
import ihuju.jpa.entidades.Cliente;
import ihuju.jpa.entidades.Estado;
import ihuju.jpa.entidades.Pais;
import ihuju.jpa.entidades.Telefono;
import ihuju.jpa.entidades.Tipotelefono;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.SystemException;

@Named("registroController")
@SessionScoped
public class RegistroController implements Serializable {

    private Persona currentPersona;
    private Usuario currentUsuario;
    private Estadousuario currentEstadousuario;
    private Cliente currentCliente;
    private Estado currentEstado;
    private Telefono currentTelefono;

    @EJB
    private ihuju.ejb.fachadas.PersonaFacade ejbFacadePersona;
    @EJB
    private ihuju.ejb.fachadas.UsuarioFacade ejbFacadeUsuario;
    @EJB
    private ihuju.ejb.fachadas.EstadousuarioFacade ejbFacadeEstadousuario;
    @EJB
    private ihuju.ejb.fachadas.ClienteFacade ejbFacadeCliente;

    @EJB
    private ihuju.ejb.fachadas.EstadoFacade oEjbFacadeEstado;

    @EJB
    private ihuju.ejb.fachadas.TelefonoFacade ejbFacadeTelefono;

    private Pais pais;
    private Departamento departamento;
    private Tipotelefono tipotelefono;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    @Resource
    protected UserTransaction oTransaction;

    public RegistroController() {
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Tipotelefono getTipotelefono() {
        return tipotelefono;
    }

    public void setTipotelefono(Tipotelefono tipotelefono) {
        this.tipotelefono = tipotelefono;
    }

    public Persona getSelectedPersona() {
        if (currentPersona == null) {
            currentPersona = new Persona();

        }
        return currentPersona;
    }

    public Usuario getSelectedUsuario() {
        if (currentUsuario == null) {
            currentUsuario = new Usuario();

        }
        return currentUsuario;
    }

    public Estadousuario getSelectedEstadousuario() {
        if (currentEstadousuario == null) {
            currentEstadousuario = new Estadousuario();

        }
        return currentEstadousuario;
    }

    public Cliente getSelectedCliente() {
        if (currentCliente == null) {
            currentCliente = new Cliente();

        }
        return currentCliente;
    }

    public Estado getSelectedEstado() {
        if (currentEstado == null) {
            currentEstado = new Estado();

        }
        return currentEstado;
    }

    public Telefono getSelectedTelefono() {
        if (currentTelefono == null) {
            currentTelefono = new Telefono();

        }
        return currentTelefono;
    }

    /**
     * @return the ejbFacadePersona
     */
    private ihuju.ejb.fachadas.PersonaFacade getEjbFacadePersona() {
        return ejbFacadePersona;
    }

    /**
     * @return the ejbFacadeUsuario
     */
    private ihuju.ejb.fachadas.UsuarioFacade getEjbFacadeUsuario() {
        return ejbFacadeUsuario;
    }

    /**
     * @return the ejbFacadeEstadousuario
     */
    private ihuju.ejb.fachadas.EstadousuarioFacade getEjbFacadeEstadousuario() {
        return ejbFacadeEstadousuario;
    }

    /**
     * @return the ejbFacadeCliente
     */
    private ihuju.ejb.fachadas.ClienteFacade getEjbFacadeCliente() {
        return ejbFacadeCliente;
    }

    /**
     * @return the oEjbFacadeEstado
     */
    public ihuju.ejb.fachadas.EstadoFacade getoEjbFacadeEstado() {
        return oEjbFacadeEstado;
    }

    /**
     * @return the oEjbFacadeTelefono
     */
    private ihuju.ejb.fachadas.TelefonoFacade getejbFacadeTelefono() {
        return ejbFacadeTelefono;
    }

    public String prepareCreate() {
        currentPersona = null;
        currentUsuario = null;
        currentEstadousuario = null;
        currentEstado = null;
        currentCliente = null;
        pais = null;
        departamento = null;
        tipotelefono = null;
        currentTelefono = null;
        return "index";
    }

    public void cifrarContraseña() throws IOException {
        String strContrasena = currentUsuario.getContrasena();
        String strContrasenaMD5 = AlgoritmoMD5.cifrarMD5(strContrasena);
        currentUsuario.setContrasena(strContrasenaMD5);
    }

    public Date sumarRestarDiasFecha(Date fecha, int dias) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de horas a añadir, o restar en caso de horas<0

        return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas

    }

    public Date sumarRestarAñosFecha(Date fecha, int anos) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.YEAR, anos);  // numero de horas a añadir, o restar en caso de horas<0

        return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas

    }

    public String create() throws IllegalStateException, SystemException {

        Integer tipoUsunum = 1;
        try {
            oTransaction.begin();
            //Guardar persona
            String msg = "";
            if (!getEjbFacadePersona().validarEmail(currentPersona.getEmail())) {
                msg = "Correo ya existe.<br>";
            }
            if (!getEjbFacadePersona().validarIdentificacion(currentPersona.getIdentificacion())) {
                msg += "Identificacion ya existe.<br>";

            }

            if (!getEjbFacadeUsuario().validarUsuario(currentUsuario.getNombreusuario())) {
                msg += "usuario ya existe.<br>";
            }

            if (!msg.equals("")) {
                throw new Exception(msg);
            }

            //
            getEjbFacadePersona().create(currentPersona);

            //Guardar usuario
            currentUsuario.setFkPersona(currentPersona);

            String strContrasena = currentUsuario.getContrasena();
            String strContrasenaMD5 = AlgoritmoMD5.cifrarMD5(strContrasena);
            currentUsuario.setContrasena(strContrasenaMD5);

            currentUsuario.setTipousuarioenum(BigInteger.valueOf(1));

            java.util.Date fecha = new Date();

            currentUsuario.setUltimoacceso(fecha);
            currentUsuario.setCodactivacion("1");

            getEjbFacadeUsuario().create(currentUsuario);

            // registrar telefono
            getSelectedTelefono();
            currentTelefono.setFkPersona(currentPersona);
            getejbFacadeTelefono().create(currentTelefono);

            //guardar Estado Usuario 
            getSelectedEstadousuario();
            getSelectedEstado();

            currentEstadousuario.setFkUsuario(currentUsuario);
            currentEstado = (Estado) getoEjbFacadeEstado().estadoAtivo();

            currentEstadousuario.setFkEstado(currentEstado);
            currentEstadousuario.setFechainicio(sumarRestarDiasFecha(fecha, -5));
            currentEstadousuario.setFechafin(sumarRestarAñosFecha(fecha, 10));

            getEjbFacadeEstadousuario().create(currentEstadousuario);

            //guardar Cliente
            // getSelectedCliente();
            currentCliente = new Cliente();
            currentCliente.setFkUsuario(currentUsuario);
            getEjbFacadeCliente().create(currentCliente);

            oTransaction.commit();

            JsfUtil.addSuccessMessage("Guardado");
            return prepareCreate();
        } catch (Exception e) {
            //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("mensajes/Bundle").getString("PersistenceErrorOccured"));
            try {
                //JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("mensajes/Bundle").getString("PersistenceErrorOccured"));++
                oTransaction.rollback();
                return null;
            } catch (SecurityException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            JsfUtil.addErrorMessage(e, e.getMessage());
            return null;
        }
    }

}
