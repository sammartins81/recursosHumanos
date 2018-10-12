package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.TipoIdentificacion;

@Local
public interface TipoIdentificacionServicioLocal {

	/**
	 * Metodo que obtiene le tipo de identificacion
	 * @return
	 */
	List<TipoIdentificacion> obtenerTipoIdentificacion();

}
