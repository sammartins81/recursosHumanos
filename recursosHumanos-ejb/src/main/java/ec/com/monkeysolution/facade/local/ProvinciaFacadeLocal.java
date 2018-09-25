/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.Provincia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ProvinciaFacadeLocal {

    void create(Provincia provincia);

    void edit(Provincia provincia);

    void remove(Provincia provincia);

    Provincia find(Object id);

    List<Provincia> findAll();

    List<Provincia> findRange(int[] range);

    int count();
    
}
