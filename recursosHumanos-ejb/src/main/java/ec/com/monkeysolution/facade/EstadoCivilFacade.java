/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.EstadoCivilFacadeLocal;
import ec.com.monkeysolution.modelo.EstadoCivil;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class EstadoCivilFacade extends AbstractFacade<EstadoCivil> implements EstadoCivilFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoCivilFacade() {
        super(EstadoCivil.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<EstadoCivil> obtenerEstadoCivil()
    {
    	Query q = em.createQuery("Select e from EstadoCivil e where e.estado = :estado order by e.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
