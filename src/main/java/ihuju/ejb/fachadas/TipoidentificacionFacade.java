/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;

import ihuju.jpa.entidades.Tipoidentificacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alejandro
 */
@Stateless
public class TipoidentificacionFacade extends AbstractFacade<Tipoidentificacion> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoidentificacionFacade() {
        super(Tipoidentificacion.class);
    }
    
}
