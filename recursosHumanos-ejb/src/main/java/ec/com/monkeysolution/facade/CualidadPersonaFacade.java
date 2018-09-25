/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.facade.local.CualidadPersonaFacadeLocal;
import ec.com.monkeysolution.modelo.CualidadPersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class CualidadPersonaFacade extends AbstractFacade<CualidadPersona> implements CualidadPersonaFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CualidadPersonaFacade() {
        super(CualidadPersona.class);
    }
    
}
