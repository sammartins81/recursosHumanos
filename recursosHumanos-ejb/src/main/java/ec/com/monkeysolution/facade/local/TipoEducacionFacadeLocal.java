/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.TipoEducacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoEducacionFacadeLocal {

    void create(TipoEducacion tipoEducacion);

    void edit(TipoEducacion tipoEducacion);

    void remove(TipoEducacion tipoEducacion);

    TipoEducacion find(Object id);

    List<TipoEducacion> findAll();

    List<TipoEducacion> findRange(int[] range);

    int count();
    
}
