package ec.com.monkeysolution.servicio.local;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Empresa;

@Local
public interface EmpresaServicioLocal {

	/**
	 * Metodo que obtiene la empresa de una persona
	 * @param persona
	 * @return
	 */
	Empresa obtenerEmpresaXPersona(Integer persona);

	/**
	 * Metodo que obtiene la empresa por id
	 * @param id
	 * @return
	 */
	Empresa obtenerXId(Integer id);

}
