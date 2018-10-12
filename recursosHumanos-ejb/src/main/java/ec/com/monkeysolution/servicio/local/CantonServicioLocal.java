package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Canton;

@Local
public interface CantonServicioLocal {

	/**
	 * Metodo que obtiene los cantones de una provincia
	 * @param provincia
	 * @return
	 */
	List<Canton> obtenerCantonesXProvincia(Integer provincia);

}
