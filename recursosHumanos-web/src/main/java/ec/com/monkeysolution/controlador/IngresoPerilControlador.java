package ec.com.monkeysolution.controlador;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UISelectOne;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseId;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import ec.com.monkeysolution.modelo.Area;
import ec.com.monkeysolution.modelo.Canton;
import ec.com.monkeysolution.modelo.Departamento;
import ec.com.monkeysolution.modelo.EstadoCivil;
import ec.com.monkeysolution.modelo.Nacionalidad;
import ec.com.monkeysolution.modelo.Pais;
import ec.com.monkeysolution.modelo.Parroquia;
import ec.com.monkeysolution.modelo.Persona;
import ec.com.monkeysolution.modelo.Provincia;
import ec.com.monkeysolution.modelo.Puesto;
import ec.com.monkeysolution.modelo.TipoIdentificacion;
import ec.com.monkeysolution.modelo.TipoPuesto;
import ec.com.monkeysolution.servicio.local.AreaServicioLocal;
import ec.com.monkeysolution.servicio.local.CantonServicioLocal;
import ec.com.monkeysolution.servicio.local.DepartamentoServicioLocal;
import ec.com.monkeysolution.servicio.local.EstadoCivilServicioLocal;
import ec.com.monkeysolution.servicio.local.NacionalidadServicioLocal;
import ec.com.monkeysolution.servicio.local.PaisServicioLocal;
import ec.com.monkeysolution.servicio.local.ParroquiaServicioLocal;
import ec.com.monkeysolution.servicio.local.ProvinciaServicioLocal;
import ec.com.monkeysolution.servicio.local.PuestoServicioLocal;
import ec.com.monkeysolution.servicio.local.TipoIdentificacionServicioLocal;
import ec.com.monkeysolution.servicio.local.TipoPuestoServicioLocal;

@Named
@ViewScoped
public class IngresoPerilControlador extends BaseControlador implements Serializable{

	private static final long serialVersionUID = -9087816913661846268L;
	
	private Persona nuevaPersona;
	private List<TipoIdentificacion> tipoIdentificaciones = new ArrayList<>();
	private Integer codTipoIdentificacion;
	private UploadedFile file;
	private List<Pais> paises = new ArrayList<>();
	private Integer codPais;
	private Integer codProvincia;
	private Integer codCanton;
	private Integer codParroquia;
	private Integer codNacionalidad;
	private Integer codEstadoCivil;
	private Integer codDepartamento;
	private Integer codArea;
	private Integer codTipoPuesto;
	private Integer codPuesto;
	private List<Provincia> provincias = new ArrayList<>();
	private List<Canton> cantones = new ArrayList<>();
	private List<Parroquia> parroquias = new ArrayList<>();
	private List<Nacionalidad> nacionalidades = new ArrayList<>();
	private List<EstadoCivil> estadoCivil = new ArrayList<>();
	private List<Departamento> departamentos = new ArrayList<>();
	private List<Area> areas = new ArrayList<>();
	private List<TipoPuesto> tipoPuesto = new ArrayList<>();
	private List<Puesto> puestos = new ArrayList<>();
	
	@EJB
	private TipoIdentificacionServicioLocal tipoIdentificacionServicioLocal;
	@EJB
	private PaisServicioLocal paisServicioLocal;
	@EJB
	private ProvinciaServicioLocal provinciaServicioLocal;
	@EJB
	private CantonServicioLocal cantonServicioLocal;
	@EJB
	private ParroquiaServicioLocal parroquiaServicioLocal;
	@EJB
	private NacionalidadServicioLocal nacionalidadServicioLocal;
	@EJB
	private EstadoCivilServicioLocal estadoCivilServicioLocal;
	@EJB
	private DepartamentoServicioLocal departamentoServicioLocal;
	@EJB
	private AreaServicioLocal areaServicioLocal;
	@EJB
	private TipoPuestoServicioLocal tipoPuestoServicioLocal;
	@EJB
	private PuestoServicioLocal puestoServicioLocal;
		
	@Inject
	private SessionControlador sessionControlador;
	
	@PostConstruct
	public void init()
	{
		nuevaPersona = new Persona();
		tipoIdentificaciones = tipoIdentificacionServicioLocal.obtenerTipoIdentificacion();
		codTipoIdentificacion = 0;
		paises = paisServicioLocal.obtenerPais();
		nacionalidades = nacionalidadServicioLocal.obtenerNacionalidades();
		estadoCivil = estadoCivilServicioLocal.obtenerEstadoCivil();
		departamentos = departamentoServicioLocal.obtenerDepartamentosXEmpresa(sessionControlador.getEmpresa().getId());
		tipoPuesto = tipoPuestoServicioLocal.obtenerTipoPuesto();
	}

	public StreamedContent getImagen()
	{
		 FacesContext context = FacesContext.getCurrentInstance();

	        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	            return new DefaultStreamedContent();
	        }
	        else {
	        	StreamedContent a = new DefaultStreamedContent(new ByteArrayInputStream(nuevaPersona.getFoto()),
	    				"image/png");
	    		return a;
	        }
	}
	
	public void cargarDocumento(FileUploadEvent event) {
		file = event.getFile();
		System.out.println("extension: "+file.getContentType());
		System.out.println("nombre: "+file.getFileName());
		System.out.println("tamaño: "+file.getContents().length);
		nuevaPersona.setFoto(file.getContents());
		sessionControlador.setFotoTemp(file.getContents());
		System.out.println("OK");
	}
	
	public void mostrarCargaFoto()
	{
		System.out.println("abriiiir");
		abrirModal("imagenDlg");
	}
	
	public void cargarProvincias(AjaxBehaviorEvent event) {
		codPais = (Integer) ((UISelectOne) event.getComponent()).getValue();
		if(codPais != null)
		{
			provincias = provinciaServicioLocal.obtenerProvinciaXPais(codPais);
		}	
	}
	
	public void cargarCantones(AjaxBehaviorEvent event) {
		codProvincia = (Integer) ((UISelectOne) event.getComponent()).getValue();
		if(codProvincia != null)
		{
			cantones = cantonServicioLocal.obtenerCantonesXProvincia(codProvincia);
		}	
	}
	
	public void cargarParroquias(AjaxBehaviorEvent event) {
		codCanton = (Integer) ((UISelectOne) event.getComponent()).getValue();
		if(codCanton != null)
		{
			parroquias = parroquiaServicioLocal.obtenerParroquiaXCanton(codCanton);
		}	
	}
	
	public void cargarAreas(AjaxBehaviorEvent event) {
		codDepartamento = (Integer) ((UISelectOne) event.getComponent()).getValue();
		if(codDepartamento != null)
		{
			areas = areaServicioLocal.obtenerAreaXDepartamento(codDepartamento);
		}	
	}
	
	public void cargarPuestos(AjaxBehaviorEvent event) {
		System.out.println("area: "+codArea);
		codTipoPuesto = (Integer) ((UISelectOne) event.getComponent()).getValue();
		if(codTipoPuesto != null)
		{
			puestos = puestoServicioLocal.obtenerPuestosXTipo(codTipoPuesto,codArea);
		}	
	}
	
	public void guardar()
	{
		System.out.println("GUARDAR");
	}
	
	public Persona getNuevaPersona() {
		return nuevaPersona;
	}

	public void setNuevaPersona(Persona nuevaPersona) {
		this.nuevaPersona = nuevaPersona;
	}

	public List<TipoIdentificacion> getTipoIdentificaciones() {
		return tipoIdentificaciones;
	}

	public void setTipoIdentificaciones(List<TipoIdentificacion> tipoIdentificaciones) {
		this.tipoIdentificaciones = tipoIdentificaciones;
	}

	public Integer getCodTipoIdentificacion() {
		return codTipoIdentificacion;
	}

	public void setCodTipoIdentificacion(Integer codTipoIdentificacion) {
		this.codTipoIdentificacion = codTipoIdentificacion;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public Integer getCodPais() {
		return codPais;
	}

	public void setCodPais(Integer codPais) {
		this.codPais = codPais;
	}

	public Integer getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(Integer codProvincia) {
		this.codProvincia = codProvincia;
	}

	public Integer getCodCanton() {
		return codCanton;
	}

	public void setCodCanton(Integer codCanton) {
		this.codCanton = codCanton;
	}

	public Integer getCodParroquia() {
		return codParroquia;
	}

	public void setCodParroquia(Integer codParroquia) {
		this.codParroquia = codParroquia;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	public List<Canton> getCantones() {
		return cantones;
	}

	public void setCantones(List<Canton> cantones) {
		this.cantones = cantones;
	}

	public List<Parroquia> getParroquias() {
		return parroquias;
	}

	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}

	public Integer getCodNacionalidad() {
		return codNacionalidad;
	}

	public void setCodNacionalidad(Integer codNacionalidad) {
		this.codNacionalidad = codNacionalidad;
	}

	public List<Nacionalidad> getNacionalidades() {
		return nacionalidades;
	}

	public void setNacionalidades(List<Nacionalidad> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

	public Integer getCodEstadoCivil() {
		return codEstadoCivil;
	}

	public void setCodEstadoCivil(Integer codEstadoCivil) {
		this.codEstadoCivil = codEstadoCivil;
	}

	public List<EstadoCivil> getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(List<EstadoCivil> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Integer getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(Integer codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Integer getCodArea() {
		return codArea;
	}

	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Integer getCodTipoPuesto() {
		return codTipoPuesto;
	}

	public void setCodTipoPuesto(Integer codTipoPuesto) {
		this.codTipoPuesto = codTipoPuesto;
	}

	public Integer getCodPuesto() {
		return codPuesto;
	}

	public void setCodPuesto(Integer codPuesto) {
		this.codPuesto = codPuesto;
	}

	public List<TipoPuesto> getTipoPuesto() {
		return tipoPuesto;
	}

	public void setTipoPuesto(List<TipoPuesto> tipoPuesto) {
		this.tipoPuesto = tipoPuesto;
	}

	public List<Puesto> getPuestos() {
		return puestos;
	}

	public void setPuestos(List<Puesto> puestos) {
		this.puestos = puestos;
	}

}
