package ec.com.monkeysolution.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ec.com.monkeysolution.facade.local.TipoPuestoFacadeLocal;
import ec.com.monkeysolution.modelo.TipoPuesto;
import ec.com.monkeysolution.servicio.local.TipoPuestoServicioLocal;

@Stateless
public class TipoPuestoServicio implements TipoPuestoServicioLocal{

	@EJB
	private TipoPuestoFacadeLocal tipoPuestoFacadeLocal;
	
	@Override
    public List<TipoPuesto> obtenerTipoPuesto()
    {
		return tipoPuestoFacadeLocal.obtenerTipoPuesto();
    }
	
}
