package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Pais;

@Local
public interface PaisServicioLocal {

	/**
	 * Metodo que obtiene todos los paises
	 * @return
	 */
	List<Pais> obtenerPais();

}
