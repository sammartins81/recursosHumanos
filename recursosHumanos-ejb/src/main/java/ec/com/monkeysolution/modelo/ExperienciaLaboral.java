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
@Table(name = "experiencia_laboral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e")
    , @NamedQuery(name = "ExperienciaLaboral.findById", query = "SELECT e FROM ExperienciaLaboral e WHERE e.id = :id")
    , @NamedQuery(name = "ExperienciaLaboral.findByNombreEmpresa", query = "SELECT e FROM ExperienciaLaboral e WHERE e.nombreEmpresa = :nombreEmpresa")
    , @NamedQuery(name = "ExperienciaLaboral.findByPuesto", query = "SELECT e FROM ExperienciaLaboral e WHERE e.puesto = :puesto")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaInicio", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaFin", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaFin = :fechaFin")
    , @NamedQuery(name = "ExperienciaLaboral.findByActual", query = "SELECT e FROM ExperienciaLaboral e WHERE e.actual = :actual")
    , @NamedQuery(name = "ExperienciaLaboral.findByDescripcion", query = "SELECT e FROM ExperienciaLaboral e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "ExperienciaLaboral.findByEstado", query = "SELECT e FROM ExperienciaLaboral e WHERE e.estado = :estado")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaCr", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaCr = :fechaCr")
    , @NamedQuery(name = "ExperienciaLaboral.findByFechaAct", query = "SELECT e FROM ExperienciaLaboral e WHERE e.fechaAct = :fechaAct")
    , @NamedQuery(name = "ExperienciaLaboral.findByUsuarioCr", query = "SELECT e FROM ExperienciaLaboral e WHERE e.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "ExperienciaLaboral.findByUsuarioAct", query = "SELECT e FROM ExperienciaLaboral e WHERE e.usuarioAct = :usuarioAct")})
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "puesto")
    private String puesto;
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
    @Size(min = 1, max = 500)
    @Column(name = "descripcion")
    private String descripcion;
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
    @Column(name = "usuario_cr")
    private Integer usuarioCr;
    @Column(name = "usuario_act")
    private Integer usuarioAct;
    @JoinColumn(name = "area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "pais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pais pais;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Integer id) {
        this.id = id;
    }

    public ExperienciaLaboral(Integer id, String nombreEmpresa, String puesto, Date fechaInicio, String descripcion, String estado, Date fechaCr) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.puesto = puesto;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCr = fechaCr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Integer getUsuarioCr() {
        return usuarioCr;
    }

    public void setUsuarioCr(Integer usuarioCr) {
        this.usuarioCr = usuarioCr;
    }

    public Integer getUsuarioAct() {
        return usuarioAct;
    }

    public void setUsuarioAct(Integer usuarioAct) {
        this.usuarioAct = usuarioAct;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.ExperienciaLaboral[ id=" + id + " ]";
    }
    
}
