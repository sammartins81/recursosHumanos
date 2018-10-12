/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.DepartamentoFacadeLocal;
import ec.com.monkeysolution.modelo.Departamento;

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
public class DepartamentoFacade extends AbstractFacade<Departamento> implements DepartamentoFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<Departamento> obtenerDepartamentosXEmpresa(Integer empresa)
    {
    	Query q = em.createQuery("Select d from Departamento d where d.estado = :estado and d.empresa.id = :empresa");
    	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
    	q.setParameter("empresa", empresa);
    	return q.getResultList();
    }
    
}
