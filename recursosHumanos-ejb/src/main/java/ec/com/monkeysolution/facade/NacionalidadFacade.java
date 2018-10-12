/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.NacionalidadFacadeLocal;
import ec.com.monkeysolution.modelo.Nacionalidad;

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
public class NacionalidadFacade extends AbstractFacade<Nacionalidad> implements NacionalidadFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NacionalidadFacade() {
        super(Nacionalidad.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Nacionalidad> obtenerNacionalidades()
    {
    	Query q = em.createQuery("Select n from Nacionalidad n where n.estado = :estado order by n.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
