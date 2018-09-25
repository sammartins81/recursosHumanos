/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.TipoSolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface TipoSolicitudFacadeLocal {

    void create(TipoSolicitud tipoSolicitud);

    void edit(TipoSolicitud tipoSolicitud);

    void remove(TipoSolicitud tipoSolicitud);

    TipoSolicitud find(Object id);

    List<TipoSolicitud> findAll();

    List<TipoSolicitud> findRange(int[] range);

    int count();
    
}
