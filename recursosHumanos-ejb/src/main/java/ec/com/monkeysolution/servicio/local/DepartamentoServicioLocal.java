package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Departamento;

@Local
public interface DepartamentoServicioLocal {

	/**
	 * Metodo que obtiene los departamentos de una empresa
	 * @param empresa
	 * @return
	 */
	List<Departamento> obtenerDepartamentosXEmpresa(Integer empresa);

}
