/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.CantonFacadeLocal;
import ec.com.monkeysolution.modelo.Canton;

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
public class CantonFacade extends AbstractFacade<Canton> implements CantonFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CantonFacade() {
        super(Canton.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Canton> obtenerCantonesXProvincia(Integer provincia)
    {
    	Query q = em.createQuery("Select c from Canton c where c.estado = :estado and c.provincia.id = :provincia order by c.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("provincia", provincia);
    	return q.getResultList();
    }
    
}
