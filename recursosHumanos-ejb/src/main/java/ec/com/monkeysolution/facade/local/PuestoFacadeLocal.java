/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.Puesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface PuestoFacadeLocal {

    void create(Puesto puesto);

    void edit(Puesto puesto);

    void remove(Puesto puesto);

    Puesto find(Object id);

    List<Puesto> findAll();

    List<Puesto> findRange(int[] range);

    int count();
    
}
