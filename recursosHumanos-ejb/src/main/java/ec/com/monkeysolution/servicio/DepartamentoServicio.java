package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.DepartamentoFacadeLocal;
import ec.com.monkeysolution.modelo.Departamento;
import ec.com.monkeysolution.servicio.local.DepartamentoServicioLocal;

@Stateless
public class DepartamentoServicio implements DepartamentoServicioLocal{

	@EJB
	private DepartamentoFacadeLocal departamentoFacadeLocal;
	
	@Override
    public List<Departamento> obtenerDepartamentosXEmpresa(Integer empresa)
    {
		return departamentoFacadeLocal.obtenerDepartamentosXEmpresa(empresa);
    }
	
}
