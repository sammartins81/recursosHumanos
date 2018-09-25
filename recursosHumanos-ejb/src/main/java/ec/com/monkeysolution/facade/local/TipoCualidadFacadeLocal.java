/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.TipoCualidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoCualidadFacadeLocal {

    void create(TipoCualidad tipoCualidad);

    void edit(TipoCualidad tipoCualidad);

    void remove(TipoCualidad tipoCualidad);

    TipoCualidad find(Object id);

    List<TipoCualidad> findAll();

    List<TipoCualidad> findRange(int[] range);

    int count();
    
}
