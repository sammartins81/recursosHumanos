package ec.com.monkeysolution.servicio.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Persona;

@Local
public interface PersonaServicioLocal {

	/**
	 * Metodo que obtiene la persona por identificacion
	 * @param identificacion
	 * @return
	 */
	Persona obtenerPersonaXIdentificacion(String identificacion);

	/**
	 * Metodo que crea un registro de persona
	 * @param persona
	 */
	void crear(Persona persona);

	/**
	 * Metodo que actualiza un registro de una persona
	 * @param persona
	 */
	void actualizar(Persona persona);

	/**
	 * Metodo que obtiene los cumpleañeros
	 * @return
	 */
	List<String> obtenerCumpleañeros();

}
