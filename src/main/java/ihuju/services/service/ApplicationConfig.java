/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.services.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Alejandro
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ihuju.movil.controladores.EventoController.class);
        resources.add(ihuju.services.service.AccionpermitidaFacadeREST.class);
        resources.add(ihuju.services.service.AccperplanFacadeREST.class);
        resources.add(ihuju.services.service.AccperusuFacadeREST.class);
        resources.add(ihuju.services.service.ArtistaFacadeREST.class);
        resources.add(ihuju.services.service.AsisteFacadeREST.class);
        resources.add(ihuju.services.service.ClienteFacadeREST.class);
        resources.add(ihuju.services.service.CronogramaFacadeREST.class);
        resources.add(ihuju.services.service.DepartamentoFacadeREST.class);
        resources.add(ihuju.services.service.DisponibilidadFacadeREST.class);
        resources.add(ihuju.services.service.DuenioFacadeREST.class);
        resources.add(ihuju.services.service.EstablecimientoFacadeREST.class);
        resources.add(ihuju.services.service.EstadispoFacadeREST.class);
        resources.add(ihuju.services.service.EstadoFacadeREST.class);
        resources.add(ihuju.services.service.EstadocivilFacadeREST.class);
        resources.add(ihuju.services.service.EstadousuarioFacadeREST.class);
        resources.add(ihuju.services.service.EstagenmusiFacadeREST.class);
        resources.add(ihuju.services.service.EstatipgenFacadeREST.class);
        resources.add(ihuju.services.service.EventoFacadeREST.class);
        resources.add(ihuju.services.service.GeneroFacadeREST.class);
        resources.add(ihuju.services.service.GeneromusicaFacadeREST.class);
        resources.add(ihuju.services.service.MunicipioFacadeREST.class);
        resources.add(ihuju.services.service.PaisFacadeREST.class);
        resources.add(ihuju.services.service.ParticipaFacadeREST.class);
        resources.add(ihuju.services.service.PersonaFacadeREST.class);
        resources.add(ihuju.services.service.PlantillaFacadeREST.class);
        resources.add(ihuju.services.service.ReservaFacadeREST.class);
        resources.add(ihuju.services.service.TelefonoFacadeREST.class);
        resources.add(ihuju.services.service.TipoartistaFacadeREST.class);
        resources.add(ihuju.services.service.TipoeventoFacadeREST.class);
        resources.add(ihuju.services.service.TipogeneroFacadeREST.class);
        resources.add(ihuju.services.service.TipoidentificacionFacadeREST.class);
        resources.add(ihuju.services.service.TipotelefonoFacadeREST.class);
        resources.add(ihuju.services.service.UsuarioFacadeREST.class);
    }
    
}
