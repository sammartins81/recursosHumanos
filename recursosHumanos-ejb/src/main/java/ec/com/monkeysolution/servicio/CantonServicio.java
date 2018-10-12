package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.CantonFacadeLocal;
import ec.com.monkeysolution.modelo.Canton;
import ec.com.monkeysolution.servicio.local.CantonServicioLocal;

@Stateless
public class CantonServicio implements CantonServicioLocal{

	@EJB
	private CantonFacadeLocal cantonFacadeLocal;
	
	@Override
    public List<Canton> obtenerCantonesXProvincia(Integer provincia)
    {
		return cantonFacadeLocal.obtenerCantonesXProvincia(provincia);
    }
	
}
