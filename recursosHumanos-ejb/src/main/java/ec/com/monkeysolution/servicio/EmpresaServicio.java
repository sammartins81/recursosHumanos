package ec.com.monkeysolution.servicio;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.EmpresaFacadeLocal;
import ec.com.monkeysolution.modelo.Empresa;
import ec.com.monkeysolution.servicio.local.EmpresaServicioLocal;

@Stateless
public class EmpresaServicio implements EmpresaServicioLocal{

	@EJB
	private EmpresaFacadeLocal empresaFacadeLocal;
	
	@Override
    public Empresa obtenerEmpresaXPersona(Integer persona)
    {
		return empresaFacadeLocal.obtenerEmpresaXPersona(persona);
    }
	
	@Override
	public Empresa obtenerXId(Integer id)
	{
		return empresaFacadeLocal.find(id);
	}
}
