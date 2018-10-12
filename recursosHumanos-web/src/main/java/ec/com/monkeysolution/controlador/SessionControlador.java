package ec.com.monkeysolution.controlador;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.com.monkeysolution.modelo.Empresa;
import ec.com.monkeysolution.modelo.Persona;

@Named
@SessionScoped
public class SessionControlador extends BaseControlador implements Serializable {

	private static final long serialVersionUID = 4424154438468275671L;

	private String nombreUsuario;
	private boolean logueoCorrecto;
	private String identificacionUsuario;
	private boolean administrador;
	private Persona persona;
	private byte[] fotoTemp;
	private Empresa empresa;

	@PostConstruct
	public void init() {

	}

	public void cerrarSesion() {
		logueoCorrecto = false;
		getHttpRequest().getSession().invalidate();
		redireccionarPagina("");
	}
	
	public StreamedContent getImagen()
	{
		 FacesContext context = FacesContext.getCurrentInstance();

	        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	            return new DefaultStreamedContent();
	        }
	        else {
	        	StreamedContent a = new DefaultStreamedContent(new ByteArrayInputStream(persona.getFoto()),
	    				"image/png");
	    		return a;
	        }
	}
	
	public StreamedContent getImagenTemp()
	{
		 FacesContext context = FacesContext.getCurrentInstance();

	        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	            return new DefaultStreamedContent();
	        }
	        else {
	        	StreamedContent a = new DefaultStreamedContent(new ByteArrayInputStream(fotoTemp),
	    				"image/png");
	    		return a;
	        }
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public boolean isLogueoCorrecto() {
		return logueoCorrecto;
	}

	public void setLogueoCorrecto(boolean logueoCorrecto) {
		this.logueoCorrecto = logueoCorrecto;
	}

	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public byte[] getFotoTemp() {
		return fotoTemp;
	}

	public void setFotoTemp(byte[] fotoTemp) {
		this.fotoTemp = fotoTemp;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
