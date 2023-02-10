/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.jsf.controladores.util;

import ihuju.jpa.entidades.Usuario;
import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laura Vidal
 */
public class Session {
 
    private HttpServletRequest oRequest;
    private HttpSession oSession;
    private FacesContext oFctx;
    private ExternalContext oEctx;

    public HttpSession getoSession() {
        return oSession;
    }

    public Session() {
    }

    public void crearSesion_JSF_HTTP(boolean blnCrearSesion) {
        oRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (!blnCrearSesion) {
            oSession.invalidate();
        }
        oSession = oRequest.getSession(blnCrearSesion);
    }

    public void redireccionarUrl(String strUrlMenu) throws IOException {
        oFctx = FacesContext.getCurrentInstance();
        oEctx = oFctx.getExternalContext();
        String strUrlBase = oEctx.getRequestContextPath();
        try {
            oEctx.redirect(strUrlBase + strUrlMenu);
        } catch (IOException e) {
            e.getMessage();
        }
        oFctx.responseComplete();
    }

    public Usuario obtenerUsuarioLogueado() {
        HttpServletRequest request = (HttpServletRequest)
        FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        Usuario usuarioBO = (Usuario) session.getAttribute("oSesionUsuario");
        return usuarioBO;
    }
}

    

