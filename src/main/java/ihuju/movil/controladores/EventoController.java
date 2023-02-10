package ihuju.movil.controladores;

import ihuju.ejb.fachadas.EventoFacade;
import ihuju.jpa.entidades.Evento;
import ihuju.movil.controladores.util.ExtJSReturnUtil;
import ihuju.movil.controladores.util.JsonRequestMapping;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Alejandro
 */
@Stateless
@Path("eventocontroller")
public class EventoController {

    private static final Log log = LogFactory.getLog(EventoController.class);

    @EJB
    private EventoFacade eventoFacade;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Evento> findAll() {
        return eventoFacade.findAll();
    }

//    @GET
//    @JsonRequestMapping(value = "/findAll0")
//    public @ResponseBody
//    Map<String, Object> findAll0() {
//        try {
//            List<Evento> lista = eventoFacade.findAll();
//            return ExtJSReturnUtil.mapOK(lista);
//        } catch (Exception e) {
//            log.error("Error en findall", e);
//            return ExtJSReturnUtil.mapError(e.getMessage());
//        }
//    }

}
