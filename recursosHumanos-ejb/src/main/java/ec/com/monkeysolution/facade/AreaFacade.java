/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.AreaFacadeLocal;
import ec.com.monkeysolution.modelo.Area;

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
public class AreaFacade extends AbstractFacade<Area> implements AreaFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AreaFacade() {
        super(Area.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Area> obtenerAreaXDepartamento(Integer departamento)
    {
    	Query q = em.createQuery("Select a from Area a where a.estado = :estado and a.departamento.id = :departamento order by a.nombre");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("departamento", departamento);
    	return q.getResultList();
    }
    
}
