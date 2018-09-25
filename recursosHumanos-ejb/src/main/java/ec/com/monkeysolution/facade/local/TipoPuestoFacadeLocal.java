/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.TipoPuesto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoPuestoFacadeLocal {

    void create(TipoPuesto tipoPuesto);

    void edit(TipoPuesto tipoPuesto);

    void remove(TipoPuesto tipoPuesto);

    TipoPuesto find(Object id);

    List<TipoPuesto> findAll();

    List<TipoPuesto> findRange(int[] range);

    int count();
    
}
