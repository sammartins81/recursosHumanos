package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.EstadoCivilFacadeLocal;
import ec.com.monkeysolution.modelo.EstadoCivil;
import ec.com.monkeysolution.servicio.local.EstadoCivilServicioLocal;

@Stateless
public class EstadoCivilServicio implements EstadoCivilServicioLocal{

	@EJB
	private EstadoCivilFacadeLocal estadoCivilFacadeLocal;
	
	@Override
    public List<EstadoCivil> obtenerEstadoCivil()
    {
		return estadoCivilFacadeLocal.obtenerEstadoCivil();
    }
	
}
