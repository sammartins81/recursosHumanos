/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.Nacionalidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface NacionalidadFacadeLocal {

    void create(Nacionalidad nacionalidad);

    void edit(Nacionalidad nacionalidad);

    void remove(Nacionalidad nacionalidad);

    Nacionalidad find(Object id);

    List<Nacionalidad> findAll();

    List<Nacionalidad> findRange(int[] range);

    int count();

    /**
     * Metodo que obtiene las nacionalidades
     * @return
     */
	List<Nacionalidad> obtenerNacionalidades();
    
}
