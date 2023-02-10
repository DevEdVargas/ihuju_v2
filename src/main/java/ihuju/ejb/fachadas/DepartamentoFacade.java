/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;

import ihuju.jpa.entidades.Departamento;
import java.util.ArrayList;
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
public class DepartamentoFacade extends AbstractFacade<Departamento> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
    public ArrayList<Departamento> obtenerDepartamentosPorPais(String codPais) {
        Query consulta = em.createNamedQuery("Departamento.findPais");
        consulta.setParameter("codPais", codPais);
        ArrayList<Departamento> lstDepartamentos = new ArrayList();
        try {
            lstDepartamentos = (ArrayList<Departamento>) consulta.getResultList();
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
        }
        return lstDepartamentos;
    }

}
