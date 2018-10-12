package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Provincia;

@Local
public interface ProvinciaServicioLocal {

	/**
	 * Metodo que obtiene las provincias de un pais
	 * @param pais
	 * @return
	 */
	List<Provincia> obtenerProvinciaXPais(Integer pais);

}
