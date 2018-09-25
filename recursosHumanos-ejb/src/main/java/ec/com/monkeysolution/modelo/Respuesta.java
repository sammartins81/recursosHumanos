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
@Table(name = "respuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r")
    , @NamedQuery(name = "Respuesta.findById", query = "SELECT r FROM Respuesta r WHERE r.id = :id")
    , @NamedQuery(name = "Respuesta.findByValor", query = "SELECT r FROM Respuesta r WHERE r.valor = :valor")
    , @NamedQuery(name = "Respuesta.findByEstado", query = "SELECT r FROM Respuesta r WHERE r.estado = :estado")
    , @NamedQuery(name = "Respuesta.findByFechaCr", query = "SELECT r FROM Respuesta r WHERE r.fechaCr = :fechaCr")
    , @NamedQuery(name = "Respuesta.findByFechaAct", query = "SELECT r FROM Respuesta r WHERE r.fechaAct = :fechaAct")
    , @NamedQuery(name = "Respuesta.findByUsaurioCr", query = "SELECT r FROM Respuesta r WHERE r.usaurioCr = :usaurioCr")
    , @NamedQuery(name = "Respuesta.findByUsuarioAct", query = "SELECT r FROM Respuesta r WHERE r.usuarioAct = :usuarioAct")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
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
    @Column(name = "usaurio_cr")
    private int usaurioCr;
    @Column(name = "usuario_act")
    private Integer usuarioAct;
    @JoinColumn(name = "evaluacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Evaluacion evaluacion;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "pregunta", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pregunta pregunta;

    public Respuesta() {
    }

    public Respuesta(Integer id) {
        this.id = id;
    }

    public Respuesta(Integer id, int valor, String estado, Date fechaCr, int usaurioCr) {
        this.id = id;
        this.valor = valor;
        this.estado = estado;
        this.fechaCr = fechaCr;
        this.usaurioCr = usaurioCr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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

    public int getUsaurioCr() {
        return usaurioCr;
    }

    public void setUsaurioCr(int usaurioCr) {
        this.usaurioCr = usaurioCr;
    }

    public Integer getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(Integer usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
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
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Respuesta[ id=" + id + " ]";
    }
    
}
