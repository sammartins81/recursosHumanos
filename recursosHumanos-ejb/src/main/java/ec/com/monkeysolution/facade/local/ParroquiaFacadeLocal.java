/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.Parroquia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ParroquiaFacadeLocal {

    void create(Parroquia parroquia);

    void edit(Parroquia parroquia);

    void remove(Parroquia parroquia);

    Parroquia find(Object id);

    List<Parroquia> findAll();

    List<Parroquia> findRange(int[] range);

    int count();
    
}
