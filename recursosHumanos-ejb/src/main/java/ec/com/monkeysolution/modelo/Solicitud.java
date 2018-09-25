/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisp.araujo
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findById", query = "SELECT s FROM Solicitud s WHERE s.id = :id")
    , @NamedQuery(name = "Solicitud.findByFecha", query = "SELECT s FROM Solicitud s WHERE s.fecha = :fecha")
    , @NamedQuery(name = "Solicitud.findByAprobado", query = "SELECT s FROM Solicitud s WHERE s.aprobado = :aprobado")
    , @NamedQuery(name = "Solicitud.findByFechaAprobacion", query = "SELECT s FROM Solicitud s WHERE s.fechaAprobacion = :fechaAprobacion")
    , @NamedQuery(name = "Solicitud.findByComentario", query = "SELECT s FROM Solicitud s WHERE s.comentario = :comentario")
    , @NamedQuery(name = "Solicitud.findByEstadoSolicitud", query = "SELECT s FROM Solicitud s WHERE s.estadoSolicitud = :estadoSolicitud")
    , @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")
    , @NamedQuery(name = "Solicitud.findByFechaCr", query = "SELECT s FROM Solicitud s WHERE s.fechaCr = :fechaCr")
    , @NamedQuery(name = "Solicitud.findByFechaAct", query = "SELECT s FROM Solicitud s WHERE s.fechaAct = :fechaAct")
    , @NamedQuery(name = "Solicitud.findByUsuarioCr", query = "SELECT s FROM Solicitud s WHERE s.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "Solicitud.findByUsuarioAct", query = "SELECT s FROM Solicitud s WHERE s.usuarioAct = :usuarioAct")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "aprobado")
    private Boolean aprobado;
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado_solicitud")
    private String estadoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cr")
    @Temporal(TemporalType.DATE)
    private Date fechaCr;
    @Column(name = "fecha_act")
    @Temporal(TemporalType.DATE)
    private Date fechaAct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_cr")
    private int usuarioCr;
    @Column(name = "usuario_act")
    private Integer usuarioAct;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "tipo_solicitud", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoSolicitud tipoSolicitud;
    @JoinColumn(name = "usuario_apr", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuarioApr;

    public Solicitud() {
    }

    public Solicitud(Integer id) {
        this.id = id;
    }

    public Solicitud(Integer id, Date fecha, String comentario, String estadoSolicitud, String estado, Date fechaCr, int usuarioCr) {
        this.id = id;
        this.fecha = fecha;
        this.comentario = comentario;
        this.estadoSolicitud = estadoSolicitud;
        this.estado = estado;
        this.fechaCr = fechaCr;
        this.usuarioCr = usuarioCr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCr() {
        return fechaCr;
    }

    public void setFechaCr(Date fechaCr) {
        this.fechaCr = fechaCr;
    }

    public Date getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(Date fechaAct) {
        this.fechaAct = fechaAct;
    }

    public int getUsuarioCr() {
        return usuarioCr;
    }

    public void setUsuarioCr(int usuarioCr) {
        this.usuarioCr = usuarioCr;
    }

    public Integer getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(Integer usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoSolicitud getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Usuario getUsuarioApr() {
        return usuarioApr;
    }

    public void setUsuarioApr(Usuario usuarioApr) {
        this.usuarioApr = usuarioApr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Solicitud[ id=" + id + " ]";
    }
    
}
