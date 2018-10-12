/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import java.util.List;

import javax.ejb.Local;

import ec.com.monkeysolution.modelo.Persona;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface PersonaFacadeLocal {

    void create(Persona persona);

    void edit(Persona persona);

    void remove(Persona persona);

    Persona find(Object id);

    List<Persona> findAll();

    List<Persona> findRange(int[] range);

    int count();

    /**
     * Metodo que obtiene la persona por identificacion
     * @param identificacion
     * @return
     */
	Persona obtenerPersonaXIdentificacion(String identificacion);

	/**
	 * Metodo que obtiene los cumpleañeros
	 * @return
	 */
	List<String> obtenerCumpleañeros();
    
}
