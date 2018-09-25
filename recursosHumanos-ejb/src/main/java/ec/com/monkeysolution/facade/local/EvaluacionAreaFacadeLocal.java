/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.EvaluacionArea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface EvaluacionAreaFacadeLocal {

    void create(EvaluacionArea evaluacionArea);

    void edit(EvaluacionArea evaluacionArea);

    void remove(EvaluacionArea evaluacionArea);

    EvaluacionArea find(Object id);

    List<EvaluacionArea> findAll();

    List<EvaluacionArea> findRange(int[] range);

    int count();
    
}
