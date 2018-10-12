package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.AreaFacadeLocal;
import ec.com.monkeysolution.modelo.Area;
import ec.com.monkeysolution.servicio.local.AreaServicioLocal;

@Stateless
public class AreaServicio implements AreaServicioLocal{

	@EJB
	private AreaFacadeLocal areaFacadeLocal;
	
	@Override
    public List<Area> obtenerAreaXDepartamento(Integer departamento)
    {
		return areaFacadeLocal.obtenerAreaXDepartamento(departamento);
    }
	
}
