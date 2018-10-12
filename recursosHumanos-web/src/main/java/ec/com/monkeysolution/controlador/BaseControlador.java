package ec.com.monkeysolution.controlador;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

public class BaseControlador {

	/**
	 * Metodo que muestra un mensaje de error
	 *
	 * @param resumen
	 * @param detalle
	 */
	protected void agregarMensajeError(String resumen, String detalle) {
		FacesMessage errorMessage = new FacesMessage();
		errorMessage.setSummary(resumen);
		errorMessage.setDetail(detalle == null ? detalle : detalle);
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, errorMessage);
	}

	/**
	 * Metodo que agrega un mensaje de error en pantalla y muestra la validación
	 * que fallo
	 *
	 * @param id
	 * @param resumen
	 * @param detalle
	 * @param validacionFallida
	 */
	protected void agregarMensajeError(String id, String resumen, String detalle, boolean validacionFallida) {
		agregarMensajeError(id, resumen, detalle);
		if (validacionFallida) {
			FacesContext.getCurrentInstance().validationFailed();
		}
	}

	/**
	 * Metodo que agrega un mensaje de error en pantalla
	 *
	 * @param id
	 * @param resumen
	 * @param detalle
	 */
	protected void agregarMensajeError(String id, String resumen, String detalle) {
		FacesMessage errorMessage = new FacesMessage();
		errorMessage.setSummary(resumen);
		errorMessage.setDetail(detalle == null ? detalle : detalle);
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(id, errorMessage);
	}

	/**
	 * Metodo que agrega un mensaje de error en pantalla
	 *
	 * @param ex
	 */
	protected void agregarMensajeError(Exception ex) {
		FacesMessage errorMessage = new FacesMessage();
		errorMessage.setSummary(ex.getMessage());
		errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, errorMessage);
	}

	/**
	 * Metodo que agrega un mensaje de información en pantalla
	 *
	 * @param resumen
	 * @param detalle
	 */
	protected void agregarMensajeInformacion(String resumen, String detalle) {
		FacesMessage infoMessage = new FacesMessage();
		infoMessage.setSummary(resumen);
		infoMessage.setDetail(detalle == null ? detalle : detalle);
		infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, infoMessage);
	}

	/**
	 * Metodo que agrega un mensaje de información en pantalla
	 *
	 * @param id
	 * @param resumen
	 * @param detalle
	 */
	protected void agregarMensajeInformacion(String id, String resumen, String detalle) {
		FacesMessage infoMessage = new FacesMessage();
		infoMessage.setSummary(resumen);
		infoMessage.setDetail(detalle == null ? detalle : detalle);
		infoMessage.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(id, infoMessage);
	}

	/**
	 * Metodo que agrega un mensaje de advertencia en pantalla
	 *
	 * @param resumen
	 * @param detalle
	 */
	protected void agregarMensajeAdvertencia(String resumen, String detalle) {
		FacesMessage infoMessage = new FacesMessage();
		infoMessage.setSummary(resumen);
		infoMessage.setDetail(detalle == null ? detalle : detalle);
		infoMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		FacesContext.getCurrentInstance().addMessage(null, infoMessage);
	}

	/**
	 * Metodo que agrega un mensaje de advertencia en pantalla
	 *
	 * @param resumen
	 * @param detalle
	 * @param enModal
	 */
	protected void agregarMensajeAdvertencia(String resumen, String detalle, boolean enModal) {
		FacesMessage infoMessage = new FacesMessage();
		infoMessage.setSummary(resumen);
		infoMessage.setDetail(detalle == null ? detalle : detalle);
		infoMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		if (enModal) {
			FacesContext.getCurrentInstance().addMessage("idMensaje", infoMessage);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, infoMessage);
		}
	}

	/**
	 * Metodo que agrega un mensaje de advertencia en pantalla
	 *
	 * @param id
	 * @param resumen
	 * @param detalle
	 */
	protected void agregarMensajeAdvertencia(String id, String resumen, String detalle) {
		FacesMessage infoMessage = new FacesMessage();
		infoMessage.setSummary(resumen);
		infoMessage.setDetail(detalle == null ? detalle : detalle);
		infoMessage.setSeverity(FacesMessage.SEVERITY_WARN);
		FacesContext.getCurrentInstance().addMessage(id, infoMessage);
	}

	/**
	 * Metodo que devuelve el objeto request
	 *
	 * @return
	 */
	public HttpServletRequest getHttpRequest() {
		return (HttpServletRequest) getExternalContext().getRequest();
	}

	/**
	 * Metodo que devuelve el valor de un parametro enviado desde el request
	 *
	 * @param parameter
	 * @return
	 */
	protected String getHttpRequestParameter(final String parameter) {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(parameter);
	}

	/**
	 * Metodo que retorna la sesion web del usuario
	 *
	 * @return
	 */
	protected HttpSession getHttpSession() {
		return (HttpSession) getExternalContext().getSession(false);
	}

	/**
	 * Metodo que devuelve el contexto externo de la aplicacion
	 *
	 * @return
	 */
	public ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}

	/**
	 * Metodo que obtiene el valor del context path.
	 *
	 * @return
	 */
	public String getContextPath() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
	}

	/**
	 * Metodo que devuelve el mapa de valores de la sesion de usuario
	 *
	 * @return
	 */
	public Map<String, Object> getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	/**
	 * Metodo que redirecciona a una pagina
	 *
	 * @param pagina
	 */
	protected void redireccionarPagina(String pagina) {
		try {
			getExternalContext().redirect(getHttpRequest().getContextPath().concat(pagina));
		} catch (IOException e) {
			agregarMensajeError("No se puede redireccionar a " + pagina, e.getLocalizedMessage());
		}
	}
	
	public void cerrarModal(String nombre)
	{
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('"+nombre+"').hide();");
	}
	
	public void abrirModal(String nombre)
	{
		RequestContext context = RequestContext.getCurrentInstance();
		context.execute("PF('"+nombre+"').show();");
	}

}
