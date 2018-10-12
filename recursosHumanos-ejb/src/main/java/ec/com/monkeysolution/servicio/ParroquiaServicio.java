package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.ParroquiaFacadeLocal;
import ec.com.monkeysolution.modelo.Parroquia;
import ec.com.monkeysolution.servicio.local.ParroquiaServicioLocal;

@Stateless
public class ParroquiaServicio implements ParroquiaServicioLocal{

	@EJB
	private ParroquiaFacadeLocal parroquiaFacadeLocal;
	
	@Override
    public List<Parroquia> obtenerParroquiaXCanton(Integer canton)
    {
		return parroquiaFacadeLocal.obtenerParroquiaXCanton(canton);
    }
	
}
