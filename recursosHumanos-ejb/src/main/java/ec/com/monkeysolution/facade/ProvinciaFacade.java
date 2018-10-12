/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.ProvinciaFacadeLocal;
import ec.com.monkeysolution.modelo.Provincia;

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
public class ProvinciaFacade extends AbstractFacade<Provincia> implements ProvinciaFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciaFacade() {
        super(Provincia.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Provincia> obtenerProvinciaXPais(Integer pais)
    {
    	Query q = em.createQuery("Select pr from Provincia pr where pr.estado = :estado and pr.pais.id = :pais order by pr.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("pais", pais);
    	return q.getResultList();
    }
    
}
