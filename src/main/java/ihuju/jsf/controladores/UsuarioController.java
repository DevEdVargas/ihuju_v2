package ihuju.jsf.controladores;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import ihuju.jpa.entidades.Usuario;
import ihuju.jsf.controladores.util.JsfUtil;
import ihuju.jsf.controladores.util.PaginationHelper;
import ihuju.ejb.fachadas.UsuarioFacade;
import ihuju.jsf.controladores.util.AlgoritmoMD5;
import ihuju.jsf.controladores.util.Session;
import java.io.File;
import java.io.IOException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    private Usuario current;
    private DataModel items = null;
    @EJB
    private ihuju.ejb.fachadas.UsuarioFacade ejbFacade;
    @EJB
    private ihuju.ejb.fachadas.EstadousuarioFacade oEstadoUsuarioFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private Session oSession;

    public UsuarioController() {
        oSession = new Session();
    }

    public int getSelectedItemIndex() {
        return selectedItemIndex;
    }

    public void setSelectedItemIndex(int selectedItemIndex) {
        this.selectedItemIndex = selectedItemIndex;
    }

    public Session getoSession() {
        return oSession;
    }

    public void setoSession(Session oSession) {
        this.oSession = oSession;
    }

    public Usuario getSelected() {
        if (current == null) {
            current = new Usuario();
            selectedItemIndex = -1;
        }
        return current;
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String logo = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "assets" + File.separator + "fete.png";

        pdf.add(Image.getInstance(logo));

        Paragraph titulo = new Paragraph("ihuju", new Font(Font.HELVETICA, 25));
        titulo.setAlignment("center");
        titulo.setSpacingAfter(10);
        pdf.add(titulo);

        Paragraph subtitulo = new Paragraph("usuario", new Font(Font.HELVETICA, 15));
        titulo.setAlignment("center");
        titulo.setSpacingAfter(10);
        pdf.add(subtitulo);

    }

    private UsuarioFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Usuario) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Usuario();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            cifrarContraseña();
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("UsuarioCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Usuario) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("UsuarioUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Usuario) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle").getString("UsuarioDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Usuario getUsuario(java.math.BigDecimal id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Usuario.class)
    public static class UsuarioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuarioController controller = (UsuarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuarioController");
            return controller.getUsuario(getKey(value));
        }

        java.math.BigDecimal getKey(String value) {
            java.math.BigDecimal key;
            key = new java.math.BigDecimal(value);
            return key;
        }

        String getStringKey(java.math.BigDecimal value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuario) {
                Usuario o = (Usuario) object;
                return getStringKey(o.getPkUsuario());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Usuario.class.getName());
            }
        }
    }

    public void cifrarContraseña() throws IOException {
        String strContrasena = current.getContrasena();
        String strContrasenaMD5 = AlgoritmoMD5.cifrarMD5(strContrasena);
        current.setContrasena(strContrasenaMD5);
    }

    public void autenticarUsuario() throws IOException {

        String strContrasena = current.getContrasena();
        String strContrasenaMD5 = AlgoritmoMD5.cifrarMD5(strContrasena);
        Usuario oUsuario = ejbFacade.autenticar(current.getNombreusuario(),
                strContrasenaMD5, oEstadoUsuarioFacade);
        String strUrlMenu = null;

        if (oUsuario != null) {
            strUrlMenu = obtenerRutaMenuPrincipal(oUsuario);
            if (oSession != null) {
                oSession.crearSesion_JSF_HTTP(true);
                oSession.getoSession().setAttribute("oSesionUsuario", oUsuario);
                oSession.redireccionarUrl(strUrlMenu);
            }
        }
    }

    public void cerrarSesion() throws IOException {
        if (oSession != null) {
            oSession.crearSesion_JSF_HTTP(false);
            oSession.redireccionarUrl("/faces/index.xhtml");
        }
    }

    public String obtenerRutaMenuPrincipal() {

        String strRutaActual = "/faces/index.xhtml";
        if (oSession.getoSession() != null) {
            Usuario oU = (Usuario) oSession.getoSession().getAttribute("oSesionUsuario");
            int intTipoUsuario = oU.getTipousuarioenum().intValue();
            switch (intTipoUsuario) {
                case 0:
                    // Administrador

                    strRutaActual
                            = "/faces/catalogos/templateAdmin.xhtml?faces-redirect=true";
                    break;
                case 1:
                    // Usuario

                    strRutaActual = "/faces/catalogos/templateAdmin.xhtml?faces-redirect=true";
                    break;
                default:
                    break;
            }
        }
        return strRutaActual;
    }

    public String obtenerRutaMenuPrincipal(Usuario oU) {

        String strRutaActual = "/faces/index.xhtml";
        int intTipoUsuario = oU.getTipousuarioenum().intValue();
        switch (intTipoUsuario) {
            case 0:
                // Administrador

                strRutaActual
                        = "/faces/catalogos/templateAdmin.xhtml?faces-redirect=true";
                break;
            case 1:
                // Usuario

                strRutaActual = "/faces/catalogos/templateAdmin.xhtml?faces-redirect=true";
                break;
            default:
                break;
        }

        return strRutaActual;
    }

    public Usuario obtenerUsuarioLogueado() {
        return oSession.obtenerUsuarioLogueado();
    }

    public String obtenerNombreCompletoUsuarioPorId(BigDecimal UsuarioId) {
        return ejbFacade.obtenerNombreCompletoUsuarioPorId(UsuarioId);
    }
}
