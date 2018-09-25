/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.Seccion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface SeccionFacadeLocal {

    void create(Seccion seccion);

    void edit(Seccion seccion);

    void remove(Seccion seccion);

    Seccion find(Object id);

    List<Seccion> findAll();

    List<Seccion> findRange(int[] range);

    int count();
    
}
