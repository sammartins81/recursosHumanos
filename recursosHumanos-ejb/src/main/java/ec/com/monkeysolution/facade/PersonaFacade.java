/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.monkeysolution.enumerador.EstadoEnum;
import ec.com.monkeysolution.facade.local.PersonaFacadeLocal;
import ec.com.monkeysolution.modelo.Persona;

/**
 *
 * @author luisp.araujo
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "recursosHumanosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }
    
    @Override
    public Persona obtenerPersonaXIdentificacion(String identificacion)
    {
    	try {
    		Query q = em.createQuery("Select p from Persona p inner join fetch p.puesto pu "
    				+ "inner join fetch p.area a inner join fetch a.departamento d inner join fetch d.empresa e "
    				+ "where p.identificacion = :identificacion and p.estado = :estado");
        	q.setParameter("identificacion", identificacion);
        	q.setParameter("estado", EstadoEnum.ACTIVO.getValor());
        	return (Persona) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public List<String> obtenerCumpleañeros()
    {
    	List<String> cumpleañeros = new ArrayList<>();
    	Query q = em.createNativeQuery("select p.nombre, a.nombre as area from persona p inner join area a on p.area = a.id where p.estado = 'A' and to_char(fecha_nacimiento,'mm-dd') = to_char(current_date,'mm-dd')");
    	List<Object[]> result = q.getResultList();
		for(Object[] o : result)
		{
			String mensaje= "Hoy es el cumpleaños de "+o[0].toString()+" perteneciente al area de "+o[1].toString();
			cumpleañeros.add(mensaje);
		}
    	return cumpleañeros;
    }
    
}
