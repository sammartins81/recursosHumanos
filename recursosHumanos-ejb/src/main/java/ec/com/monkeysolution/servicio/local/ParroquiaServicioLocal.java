package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Parroquia;

@Local
public interface ParroquiaServicioLocal {

	/**
	 * Metodo que obtiene las parroquias de un canton
	 * @param canton
	 * @return
	 */
	List<Parroquia> obtenerParroquiaXCanton(Integer canton);

}
