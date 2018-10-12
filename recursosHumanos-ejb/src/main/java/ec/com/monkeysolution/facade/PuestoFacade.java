/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.PuestoFacadeLocal;
import ec.com.monkeysolution.modelo.Puesto;

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
public class PuestoFacade extends AbstractFacade<Puesto> implements PuestoFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PuestoFacade() {
        super(Puesto.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Puesto> obtenerPuestosXTipo(Integer tipo, Integer area)
    {
    	Query q = em.createQuery("Select p from Puesto p where p.estado = :estado and p.tipoPuesto.id = :tipo and p.area.id = :area");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("tipo", tipo);
    	q.setParameter("area", area);
    	return q.getResultList();
    }
    
}
