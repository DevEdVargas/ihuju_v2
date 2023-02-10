/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;

import ihuju.jpa.entidades.Estado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alejandro
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    
    public Estado estadoAtivo() {
        
        String descripcion="ACTIVO";
        
        Query consulta = em.createNamedQuery("Estado.findByDescripcion");
        
        consulta.setParameter("descripcion", descripcion);
        

        try {
            Estado oEstado = (Estado) consulta.getSingleResult();
            em.refresh(oEstado);
            return oEstado;
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
