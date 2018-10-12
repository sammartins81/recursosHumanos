/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.TipoIdentificacionFacadeLocal;
import ec.com.monkeysolution.modelo.TipoIdentificacion;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class TipoIdentificacionFacade extends AbstractFacade<TipoIdentificacion> implements TipoIdentificacionFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoIdentificacionFacade() {
        super(TipoIdentificacion.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<TipoIdentificacion> obtenerTipoIdentificacion()
    {
    	Query q = em.createQuery("Select ti from TipoIdentificacion ti where ti.estado = :estado order by ti.nombre asc");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	return q.getResultList();
    }
    
}
