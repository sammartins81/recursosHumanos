/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.monkeysolution.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luisp.araujo
 */
@Entity
@Table(name = "evaluacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e")
    , @NamedQuery(name = "Evaluacion.findById", query = "SELECT e FROM Evaluacion e WHERE e.id = :id")
    , @NamedQuery(name = "Evaluacion.findByFechaInicio", query = "SELECT e FROM Evaluacion e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Evaluacion.findByNombre", query = "SELECT e FROM Evaluacion e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Evaluacion.findByFechaFin", query = "SELECT e FROM Evaluacion e WHERE e.fechaFin = :fechaFin")
    , @NamedQuery(name = "Evaluacion.findByFechaCr", query = "SELECT e FROM Evaluacion e WHERE e.fechaCr = :fechaCr")
    , @NamedQuery(name = "Evaluacion.findByFechaAct", query = "SELECT e FROM Evaluacion e WHERE e.fechaAct = :fechaAct")
    , @NamedQuery(name = "Evaluacion.findByUsuarioCr", query = "SELECT e FROM Evaluacion e WHERE e.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "Evaluacion.findByUsuarioAct", query = "SELECT e FROM Evaluacion e WHERE e.usuarioAct = :usuarioAct")
    , @NamedQuery(name = "Evaluacion.findByEstado", query = "SELECT e FROM Evaluacion e WHERE e.estado = :estado")})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Size(max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "pregunta_seccion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PreguntaSeccion preguntaSeccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
    private List<EvaluacionArea> evaluacionAreaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluacion")
    private List<Respuesta> respuestaList;

    public Evaluacion() {
    }

    public Evaluacion(Integer id) {
        this.id = id;
    }

    public Evaluacion(Integer id, Date fechaInicio, Date fechaCr, int usuarioCr, String estado) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaCr = fechaCr;
        this.usuarioCr = usuarioCr;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PreguntaSeccion getPreguntaSeccion() {
        return preguntaSeccion;
    }

    public void setPreguntaSeccion(PreguntaSeccion preguntaSeccion) {
        this.preguntaSeccion = preguntaSeccion;
    }

    @XmlTransient
    public List<EvaluacionArea> getEvaluacionAreaList() {
        return evaluacionAreaList;
    }

    public void setEvaluacionAreaList(List<EvaluacionArea> evaluacionAreaList) {
        this.evaluacionAreaList = evaluacionAreaList;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
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
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Evaluacion[ id=" + id + " ]";
    }
    
}
