/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.Pais;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface PaisFacadeLocal {

    void create(Pais pais);

    void edit(Pais pais);

    void remove(Pais pais);

    Pais find(Object id);

    List<Pais> findAll();

    List<Pais> findRange(int[] range);

    int count();

    /**
     * Metodo que obtiene los paises
     * @return
     */
	List<Pais> obtenerPais();
    
}
