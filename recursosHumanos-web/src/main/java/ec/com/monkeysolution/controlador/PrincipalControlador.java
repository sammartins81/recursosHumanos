package ec.com.monkeysolution.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ec.com.monkeysolution.servicio.local.PersonaServicioLocal;

@Named
@ViewScoped
public class PrincipalControlador extends BaseControlador implements Serializable{

	private static final long serialVersionUID = -4885325953570794625L;
	private UploadedFile file;
	List<String> notificaciones = new ArrayList<>();
	
	@Inject
	private SessionControlador sessionControlador;
	
	@EJB
	private PersonaServicioLocal personaServicioLocal;
	
	@PostConstruct
	public void init()
	{
		notificaciones = personaServicioLocal.obtenerCumpleañeros();
		System.out.println("cumple: "+notificaciones.size());
	}
	
	
	public void cargarDocumento(FileUploadEvent event) {
		file = event.getFile();
		System.out.println("extension: "+file.getContentType());
		System.out.println("nombre: "+file.getFileName());
		System.out.println("tamaño: "+file.getContents().length);
		sessionControlador.getPersona().setFoto(file.getContents());
		personaServicioLocal.actualizar(sessionControlador.getPersona());
		System.out.println("OK");
	}


	public List<String> getNotificaciones() {
		return notificaciones;
	}


	public void setNotificaciones(List<String> notificaciones) {
		this.notificaciones = notificaciones;
	}

}
