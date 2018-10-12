package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.EstadoCivil;

@Local
public interface EstadoCivilServicioLocal {

	/**
	 * Metodo que obtiene los estados civiles
	 * @return
	 */
	List<EstadoCivil> obtenerEstadoCivil();

}
