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
@Table(name = "educacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Educacion.findAll", query = "SELECT e FROM Educacion e")
    , @NamedQuery(name = "Educacion.findById", query = "SELECT e FROM Educacion e WHERE e.id = :id")
    , @NamedQuery(name = "Educacion.findByTitulo", query = "SELECT e FROM Educacion e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "Educacion.findByInstitucion", query = "SELECT e FROM Educacion e WHERE e.institucion = :institucion")
    , @NamedQuery(name = "Educacion.findByFechaInicio", query = "SELECT e FROM Educacion e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Educacion.findByFechaFin", query = "SELECT e FROM Educacion e WHERE e.fechaFin = :fechaFin")
    , @NamedQuery(name = "Educacion.findByActual", query = "SELECT e FROM Educacion e WHERE e.actual = :actual")
    , @NamedQuery(name = "Educacion.findByEstado", query = "SELECT e FROM Educacion e WHERE e.estado = :estado")
    , @NamedQuery(name = "Educacion.findByFechaCr", query = "SELECT e FROM Educacion e WHERE e.fechaCr = :fechaCr")
    , @NamedQuery(name = "Educacion.findByFechaAct", query = "SELECT e FROM Educacion e WHERE e.fechaAct = :fechaAct")
    , @NamedQuery(name = "Educacion.findByUsuarioCr", query = "SELECT e FROM Educacion e WHERE e.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "Educacion.findByUsuarioAct", query = "SELECT e FROM Educacion e WHERE e.usuarioAct = :usuarioAct")})
public class Educacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "institucion")
    private String institucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "actual")
    private Boolean actual;
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
    @JoinColumn(name = "area_educacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AreaEducacion areaEducacion;
    @JoinColumn(name = "estado_educacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoEducacion estadoEducacion;
    @JoinColumn(name = "pais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pais pais;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "tipo_educacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoEducacion tipoEducacion;

    public Educacion() {
    }

    public Educacion(Integer id) {
        this.id = id;
    }

    public Educacion(Integer id, String titulo, String institucion, Date fechaInicio, String estado, Date fechaCr, int usuarioCr) {
        this.id = id;
        this.titulo = titulo;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getActual() {
        return actual;
    }

    public void setActual(Boolean actual) {
        this.actual = actual;
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

    public AreaEducacion getAreaEducacion() {
        return areaEducacion;
    }

    public void setAreaEducacion(AreaEducacion areaEducacion) {
        this.areaEducacion = areaEducacion;
    }

    public EstadoEducacion getEstadoEducacion() {
        return estadoEducacion;
    }

    public void setEstadoEducacion(EstadoEducacion estadoEducacion) {
        this.estadoEducacion = estadoEducacion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoEducacion getTipoEducacion() {
        return tipoEducacion;
    }

    public void setTipoEducacion(TipoEducacion tipoEducacion) {
        this.tipoEducacion = tipoEducacion;
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
        if (!(object instanceof Educacion)) {
            return false;
        }
        Educacion other = (Educacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Educacion[ id=" + id + " ]";
    }
    
}
