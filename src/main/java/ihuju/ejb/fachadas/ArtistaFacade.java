/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;

import ihuju.jpa.entidades.Artista;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alejandro
 */
@Stateless
public class ArtistaFacade extends AbstractFacade<Artista> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtistaFacade() {
        super(Artista.class);
    }
    
    public boolean validarUsuario(BigDecimal idUsuario) {
        Artista x = null;
        
        try {
            x = em.createNamedQuery("Artista.findByfkUsuario", Artista.class).setParameter("idUsuario", idUsuario).getSingleResult();
        } catch (Exception e) {   
            System.out.println(e);
        }
        return x == null;
    }
    
}
