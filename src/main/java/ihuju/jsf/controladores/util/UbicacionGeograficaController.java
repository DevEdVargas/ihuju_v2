package ihuju.jsf.controladores.util;

import ihuju.jpa.entidades.Departamento;
import ihuju.jpa.entidades.Municipio;
import ihuju.jpa.entidades.Pais;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

@Named("ubicacionGeograficaController")
@ViewScoped

public class UbicacionGeograficaController implements Serializable {

    @EJB
    private ihuju.ejb.fachadas.PaisFacade oPaisFacade;
    @EJB
    private ihuju.ejb.fachadas.DepartamentoFacade oDepartamentoFacade;
    @EJB
    private ihuju.ejb.fachadas.MunicipioFacade oMunicipioFacade;

    private List<Pais> paises;
    private List<Departamento> departamentos;
    private List<Municipio> municipios;

    public List<Pais> getPaises() {
        if (paises == null) {
            paises = oPaisFacade.findAll();
        }
        return paises;
    }

    public void onPaisChange(Pais pais) {
        if (pais != null) {
            departamentos = oDepartamentoFacade.obtenerDepartamentosPorPais(pais.getCodigo());
        } else {
            departamentos = null;
        }
    }

    public List<Departamento> getDepartamentos() {
        if (departamentos == null) {
            departamentos = oDepartamentoFacade.findAll();
        }
        return departamentos;
    }

    public void onDepartamentChange(Departamento depto) {
        if (depto != null) {
            municipios = oMunicipioFacade.obtenerMunicipiosPorDepartamento(depto.getCodigo());
        } else {
            municipios = null;
        }
    }

    public List<Municipio> getMunicipios() {
        if (municipios == null) {
            municipios = oMunicipioFacade.findAll();
        }
        return municipios;
    }

}
