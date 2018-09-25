/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.EstadoEducacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface EstadoEducacionFacadeLocal {

    void create(EstadoEducacion estadoEducacion);

    void edit(EstadoEducacion estadoEducacion);

    void remove(EstadoEducacion estadoEducacion);

    EstadoEducacion find(Object id);

    List<EstadoEducacion> findAll();

    List<EstadoEducacion> findRange(int[] range);

    int count();
    
}
