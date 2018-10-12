package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Nacionalidad;

@Local
public interface NacionalidadServicioLocal {

	/**
	 * Metodo que obtiene las nacionalidades
	 * @return
	 */
	List<Nacionalidad> obtenerNacionalidades();

}
