/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;

import ihuju.jpa.entidades.Municipio;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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
public class MunicipioFacade extends AbstractFacade<Municipio> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipioFacade() {
        super(Municipio.class);
    }

    public ArrayList<Municipio> obtenerMunicipiosPorDepartamento(String codDepto) {
        Query consulta = em.createNamedQuery("Municipio.findDepartamento");
        consulta.setParameter("codDepartamento", codDepto);
        ArrayList<Municipio> lstMunicipios = new ArrayList();
        try {
            lstMunicipios = (ArrayList<Municipio>) consulta.getResultList();
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
        }
        return lstMunicipios;
    }

    public List<Municipio> obtenerMunicipiosporDepartamento(BigDecimal codDepartamento) {
        StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("SELECT * FROM MUNICIPIO M ");
        sbSQL.append("INNER JOIN DEPARTAMENTO D on (M.FK_DEPARTAMENTO = D.PK_DEPARTAMENTO)");
        sbSQL.append("WHERE D.CODIGO = '").append(codDepartamento);
        sbSQL.append("' ORDER BY M.nombre");

        Query consulta = em.createNamedQuery(sbSQL.toString(), Municipio.class);
        List<Municipio> lstMunicipios = new ArrayList<>();
        try {
            lstMunicipios = consulta.getResultList();
        } catch (NoResultException e) {
            System.err.println(e.getMessage());
        }
        return lstMunicipios;
    }
}
