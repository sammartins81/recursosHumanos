/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.Canton;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface CantonFacadeLocal {

    void create(Canton canton);

    void edit(Canton canton);

    void remove(Canton canton);

    Canton find(Object id);

    List<Canton> findAll();

    List<Canton> findRange(int[] range);

    int count();
    
}
