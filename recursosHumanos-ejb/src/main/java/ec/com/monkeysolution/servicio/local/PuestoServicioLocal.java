package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Puesto;

@Local
public interface PuestoServicioLocal {

	/**
	 * Metodo que obtiene los puestos
	 * @param tipo
	 * @return
	 */
	List<Puesto> obtenerPuestosXTipo(Integer tipo, Integer area);

}
