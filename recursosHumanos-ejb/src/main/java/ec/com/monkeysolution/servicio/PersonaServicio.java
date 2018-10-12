package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.PersonaFacadeLocal;
import ec.com.monkeysolution.modelo.Persona;
import ec.com.monkeysolution.servicio.local.PersonaServicioLocal;

@Stateless
public class PersonaServicio implements PersonaServicioLocal{

	@EJB
	private PersonaFacadeLocal personaFacadeLocal;
	
	@Override
    public Persona obtenerPersonaXIdentificacion(String identificacion)
    {
		return personaFacadeLocal.obtenerPersonaXIdentificacion(identificacion);
    }
	
	@Override
	public void crear(Persona persona)
	{
		personaFacadeLocal.create(persona);;
	}
	
	@Override
	public void actualizar(Persona persona)
	{
		personaFacadeLocal.edit(persona);
	}
	
	@Override
    public List<String> obtenerCumpleañeros()
    {
		return personaFacadeLocal.obtenerCumpleañeros();
    }
}
