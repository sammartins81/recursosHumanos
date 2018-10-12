/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import ec.com.monkeysolution.facade.local.EmpresaFacadeLocal;
import ec.com.monkeysolution.modelo.Empresa;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class EmpresaFacade extends AbstractFacade<Empresa> implements EmpresaFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpresaFacade() {
        super(Empresa.class);
    }
    
    @Override
    public Empresa obtenerEmpresaXPersona(Integer persona)
    {
    	try {
    		Query q = em.createQuery("Select e from Persona p inner join fetch p.area a inner join fetch a.departamento d inner join fetch d.empresa e where p.id = :persona");
        	q.setParameter("persona", persona);
        	return (Empresa) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}
