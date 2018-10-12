/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.TipoPuestoFacadeLocal;
import ec.com.monkeysolution.modelo.TipoPuesto;

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
public class TipoPuestoFacade extends AbstractFacade<TipoPuesto> implements TipoPuestoFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPuestoFacade() {
        super(TipoPuesto.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<TipoPuesto> obtenerTipoPuesto()
    {
    	Query q = em.createQuery("Select tp from TipoPuesto tp where tp.estado = :estado order by tp.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
