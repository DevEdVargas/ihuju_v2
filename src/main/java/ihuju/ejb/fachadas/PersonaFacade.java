/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;

import ihuju.jpa.entidades.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alejandro
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    public boolean validarEmail(String email) {
        Persona x = null;
        try {
            x = em.createNamedQuery("Persona.findByEmail", Persona.class).setParameter("email", email).getSingleResult();
        } catch (Exception e) {
        }
        return x == null;
    }

    public boolean validarIdentificacion(String identificacion) {
        Persona x = null;
        try {
            x = em.createNamedQuery("Persona.findByIdentificacion", Persona.class).setParameter("identificacion", identificacion).getSingleResult();
        } catch (Exception e) {
        }
        return x == null;
    }
}
