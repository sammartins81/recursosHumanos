package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.NacionalidadFacadeLocal;
import ec.com.monkeysolution.modelo.Nacionalidad;
import ec.com.monkeysolution.servicio.local.NacionalidadServicioLocal;

@Stateless
public class NacionalidadServicio implements NacionalidadServicioLocal{

	@EJB
	private NacionalidadFacadeLocal nacionalidadFacadeLocal;
	
	@Override
    public List<Nacionalidad> obtenerNacionalidades()
    {
		return nacionalidadFacadeLocal.obtenerNacionalidades();
    }
	
}
