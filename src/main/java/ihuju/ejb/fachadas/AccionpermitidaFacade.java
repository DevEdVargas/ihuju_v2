/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihuju.ejb.fachadas;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ihuju.jpa.entidades.Accionpermitida;
import ihuju.dto.menu.ItemMenu;







/**
 *
 * @author Alejandro
 */
@Stateless
public class AccionpermitidaFacade extends AbstractFacade<Accionpermitida> {

    @PersistenceContext(unitName = "sena.ccys.1564184_ihuju_war_1.0.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccionpermitidaFacade() {
        super(Accionpermitida.class);
    }

    public List<ItemMenu> obtenerArbolAPPorUsuario(BigDecimal UsuarioId) {
        StringBuilder sbSQL = new StringBuilder();

        sbSQL.append(" SELECT LEVEL,ACCIONES.* ");
        sbSQL.append(" FROM (");
        sbSQL.append(" SELECT ap.pk_accipermitida, ap.codigo, ap.descripcion,"
                + "ap.ruta, ap.fk_accipermitida ");
        sbSQL.append(" FROM ACCIONPERMITIDA AP ");
        sbSQL.append(" INNER JOIN ACCPERUSU AU ON"
                + "(ap.pk_accipermitida=AU.FK_ACCIPERMITIDA) ");
        sbSQL.append(" WHERE au.fk_usuario=").append(UsuarioId);
        sbSQL.append(" )ACCIONES ");
        sbSQL.append(" START WITH FK_ACCIPERMITIDA is NULL ");
        sbSQL.append(" CONNECT BY PRIOR PK_ACCIPERMITIDA = FK_ACCIPERMITIDA");
        sbSQL.append(" order by codigo");

        try{
            List<ItemMenu> listaMenu= new ArrayList<>();
            Query consulta = em.createNativeQuery(sbSQL.toString());
            
            List<Object[]> listaAcciones = consulta.getResultList();
            for(Object [] accion : listaAcciones){
                ItemMenu item = new ItemMenu();
                item.setLevel(((BigDecimal) accion[0]).intValue());
                item.setId(((BigDecimal) accion[1]).intValue());
                item.setCodigo((String) accion[2]);
                item.setDescripcion((String) accion[3]);
                item.setRuta((String) accion[4]);
                listaMenu.add(item);
            }
            return listaMenu;
        }catch(NoResultException e){
            return null;
        }

    }

}
