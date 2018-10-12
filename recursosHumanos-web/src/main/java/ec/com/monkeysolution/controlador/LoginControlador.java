/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ec.com.monkeysolution.security.EducacionUserSecurity;
import ec.com.monkeysolution.servicio.local.EmpresaServicioLocal;
import ec.com.monkeysolution.servicio.local.PersonaServicioLocal;

@Named
@ViewScoped
public class LoginControlador extends BaseControlador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8967637270135230046L;

	@Inject
	private SessionControlador sesionControlador;
	@EJB
	private PersonaServicioLocal personaServicioLocal;
	@EJB
	private EmpresaServicioLocal empresaServicioLocal;

	private String usuario;
	private String contrasenia;
	private Boolean logueoIncorrecto;
	private String mensajeNoLogueo;

	@PostConstruct
	private void init() {

	}

	public void iniciarSesion() {
		logueoIncorrecto = null;
		mensajeNoLogueo = null;
		try {
			WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(
					(ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext());
			AuthenticationManager am = (AuthenticationManager) context.getBean("authenticationManager");
			Authentication request = new UsernamePasswordAuthenticationToken(this.getUsuario(), this.getContrasenia());
			Authentication result = am.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
			EducacionUserSecurity userSecurity = (EducacionUserSecurity) result.getPrincipal();
			sesionControlador.setNombreUsuario(userSecurity.getNombreCompleto());
			sesionControlador.setIdentificacionUsuario(userSecurity.getUsername());
			sesionControlador.setLogueoCorrecto(true);
			sesionControlador.setPersona(personaServicioLocal.obtenerPersonaXIdentificacion(userSecurity.getUsername()));
			sesionControlador.setEmpresa(empresaServicioLocal.obtenerXId(sesionControlador.getPersona().getArea().getDepartamento().getEmpresa().getId()));
			// sesionControlador.asaignar();
			redireccionarPagina("/faces/paginas/principal.xhtml");
		} catch (BadCredentialsException e) {
			logueoIncorrecto = true;
			mensajeNoLogueo = "Credenciales incorrectas. Por favor verifique.";
		} catch (AuthenticationServiceException badCredentialsException) {
			logueoIncorrecto = true;
			mensajeNoLogueo = "Error de autenticación. Por favor verifique.";
		} catch (LockedException lockedException) {
			logueoIncorrecto = true;
			mensajeNoLogueo = "Usuario bloqueado. Por favor verifique.";
		} catch (DisabledException disabledException) {
			logueoIncorrecto = true;
			mensajeNoLogueo = "Usuario deshabilitado. Por favor verifique.";
		} catch (Exception e) {
			e.printStackTrace();
			logueoIncorrecto = true;
			mensajeNoLogueo = "Error al iniciar sesión. Por favor comuníquese con el administrador del sistema.";
		}
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Boolean getLogueoIncorrecto() {
		return logueoIncorrecto;
	}

	public void setLogueoIncorrecto(Boolean logueoIncorrecto) {
		this.logueoIncorrecto = logueoIncorrecto;
	}

	public String getMensajeNoLogueo() {
		return mensajeNoLogueo;
	}

	public void setMensajeNoLogueo(String mensajeNoLogueo) {
		this.mensajeNoLogueo = mensajeNoLogueo;
	}

}
