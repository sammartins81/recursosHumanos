/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.PaisFacadeLocal;
import ec.com.monkeysolution.modelo.Pais;

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
public class PaisFacade extends AbstractFacade<Pais> implements PaisFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Pais> obtenerPais()
    {
    	Query q = em.createQuery("Select p from Pais p where p.estado = :estado order by p.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
