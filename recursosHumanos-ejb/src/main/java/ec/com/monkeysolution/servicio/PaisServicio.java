package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.PaisFacadeLocal;
import ec.com.monkeysolution.modelo.Pais;
import ec.com.monkeysolution.servicio.local.PaisServicioLocal;

@Stateless
public class PaisServicio implements PaisServicioLocal{

	@EJB
	private PaisFacadeLocal paisFacadeLocal;
	
	@Override
    public List<Pais> obtenerPais()
    {
		return paisFacadeLocal.obtenerPais();
    }
	
}
