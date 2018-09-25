/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade.local;

import ec.com.monkeysolution.modelo.ExperienciaLaboral;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author luisp.araujo
 */
@Local
public interface ExperienciaLaboralFacadeLocal {

    void create(ExperienciaLaboral experienciaLaboral);

    void edit(ExperienciaLaboral experienciaLaboral);

    void remove(ExperienciaLaboral experienciaLaboral);

    ExperienciaLaboral find(Object id);

    List<ExperienciaLaboral> findAll();

    List<ExperienciaLaboral> findRange(int[] range);

    int count();
    
}
