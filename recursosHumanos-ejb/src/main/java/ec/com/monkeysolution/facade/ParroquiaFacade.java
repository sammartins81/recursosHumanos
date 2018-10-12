/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.ParroquiaFacadeLocal;
import ec.com.monkeysolution.modelo.Parroquia;

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
public class ParroquiaFacade extends AbstractFacade<Parroquia> implements ParroquiaFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParroquiaFacade() {
        super(Parroquia.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Parroquia> obtenerParroquiaXCanton(Integer canton)
    {
    	Query q = em.createQuery("Select p from Parroquia p where p.estado = :estado and p.canton.id = :canton order by p.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("canton", canton);
    	return q.getResultList();
    }
    
}
