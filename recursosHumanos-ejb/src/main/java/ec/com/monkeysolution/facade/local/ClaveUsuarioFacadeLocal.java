/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.ClaveUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ClaveUsuarioFacadeLocal {

    void create(ClaveUsuario claveUsuario);

    void edit(ClaveUsuario claveUsuario);

    void remove(ClaveUsuario claveUsuario);

    ClaveUsuario find(Object id);

    List<ClaveUsuario> findAll();

    List<ClaveUsuario> findRange(int[] range);

    int count();
    
}
