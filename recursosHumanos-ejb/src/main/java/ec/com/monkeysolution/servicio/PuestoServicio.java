package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.PuestoFacadeLocal;
import ec.com.monkeysolution.modelo.Puesto;
import ec.com.monkeysolution.servicio.local.PuestoServicioLocal;

@Stateless
public class PuestoServicio implements PuestoServicioLocal{

	@EJB
	private PuestoFacadeLocal puestoFacadeLocal;
	
	@Override
    public List<Puesto> obtenerPuestosXTipo(Integer tipo, Integer area)
    {
		return puestoFacadeLocal.obtenerPuestosXTipo(tipo,area);
    }
	
}
