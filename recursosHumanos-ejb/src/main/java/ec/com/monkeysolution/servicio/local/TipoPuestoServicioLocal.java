package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.TipoPuesto;

@Local
public interface TipoPuestoServicioLocal {

	/**
	 * Metodo que obtiene los tipos de puesto
	 * @return
	 */
	List<TipoPuesto> obtenerTipoPuesto();

}
