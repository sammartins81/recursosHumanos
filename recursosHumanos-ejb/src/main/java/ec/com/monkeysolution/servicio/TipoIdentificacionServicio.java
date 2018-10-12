package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.TipoIdentificacionFacadeLocal;
import ec.com.monkeysolution.modelo.TipoIdentificacion;
import ec.com.monkeysolution.servicio.local.TipoIdentificacionServicioLocal;

@Stateless
public class TipoIdentificacionServicio implements TipoIdentificacionServicioLocal{

	@EJB
	private TipoIdentificacionFacadeLocal tipoIdentificacionFacadeLocal;
	
	@Override
    public List<TipoIdentificacion> obtenerTipoIdentificacion()
    {
		return tipoIdentificacionFacadeLocal.obtenerTipoIdentificacion();
    }
	
}
