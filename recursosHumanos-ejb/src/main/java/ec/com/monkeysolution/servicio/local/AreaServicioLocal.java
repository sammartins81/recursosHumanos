package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Area;

@Local
public interface AreaServicioLocal {

	/**
	 * Metodo que obtiene las areas de un departamento
	 * @param departamento
	 * @return
	 */
	List<Area> obtenerAreaXDepartamento(Integer departamento);

}
