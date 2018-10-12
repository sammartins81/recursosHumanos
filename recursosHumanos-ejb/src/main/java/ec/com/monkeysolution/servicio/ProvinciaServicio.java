package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.ProvinciaFacadeLocal;
import ec.com.monkeysolution.modelo.Provincia;
import ec.com.monkeysolution.servicio.local.ProvinciaServicioLocal;

@Stateless
public class ProvinciaServicio implements ProvinciaServicioLocal{

	@EJB
	private ProvinciaFacadeLocal provinciaFacadeLocal;
	
	@Override
    public List<Provincia> obtenerProvinciaXPais(Integer pais)
    {
		return provinciaFacadeLocal.obtenerProvinciaXPais(pais);
    }
	
}
