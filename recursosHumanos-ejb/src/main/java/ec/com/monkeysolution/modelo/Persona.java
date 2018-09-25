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
import javax.persistence.Lob;
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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
    , @NamedQuery(name = "Persona.findByDireccion", query = "SELECT p FROM Persona p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular")
    , @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Persona.findByFechaCr", query = "SELECT p FROM Persona p WHERE p.fechaCr = :fechaCr")
    , @NamedQuery(name = "Persona.findByFechaAct", query = "SELECT p FROM Persona p WHERE p.fechaAct = :fechaAct")
    , @NamedQuery(name = "Persona.findByUsuarioCr", query = "SELECT p FROM Persona p WHERE p.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "Persona.findByUsuarioAct", query = "SELECT p FROM Persona p WHERE p.usuarioAct = :usuarioAct")
    , @NamedQuery(name = "Persona.findByEstado", query = "SELECT p FROM Persona p WHERE p.estado = :estado")
    , @NamedQuery(name = "Persona.findByFechaIngreso", query = "SELECT p FROM Persona p WHERE p.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "Persona.findByFechaSalida", query = "SELECT p FROM Persona p WHERE p.fechaSalida = :fechaSalida")
    , @NamedQuery(name = "Persona.findBySueldo", query = "SELECT p FROM Persona p WHERE p.sueldo = :sueldo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "identificacion")
    private String identificacion;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "celular")
    private String celular;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
    private double sueldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Conocimiento> conocimientoList;
    @JoinColumn(name = "area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "canton", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Canton canton;
    @JoinColumn(name = "estado_civil", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoCivil estadoCivil;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nacionalidad nacionalidad;
    @OneToMany(mappedBy = "jefe")
    private List<Persona> personaList;
    @JoinColumn(name = "jefe", referencedColumnName = "id")
    @ManyToOne
    private Persona jefe;
    @JoinColumn(name = "puesto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Puesto puesto;
    @JoinColumn(name = "tipo_indentificacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoIdentificacion tipoIndentificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<CualidadPersona> cualidadPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<ExperienciaLaboral> experienciaLaboralList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Solicitud> solicitudList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Educacion> educacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<Respuesta> respuestaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private List<IdiomaPersona> idiomaPersonaList;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String nombre, Date fechaNacimiento, String identificacion, String correo, String direccion, String celular, Date fechaCr, int usuarioCr, String estado, Date fechaIngreso, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.correo = correo;
        this.direccion = direccion;
        this.celular = celular;
        this.fechaCr = fechaCr;
        this.usuarioCr = usuarioCr;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.sueldo = sueldo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @XmlTransient
    public List<Conocimiento> getConocimientoList() {
        return conocimientoList;
    }

    public void setConocimientoList(List<Conocimiento> conocimientoList) {
        this.conocimientoList = conocimientoList;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Canton getCanton() {
        return canton;
    }

    public void setCanton(Canton canton) {
        this.canton = canton;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Persona getJefe() {
        return jefe;
    }

    public void setJefe(Persona jefe) {
        this.jefe = jefe;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public TipoIdentificacion getTipoIndentificacion() {
        return tipoIndentificacion;
    }

    public void setTipoIndentificacion(TipoIdentificacion tipoIndentificacion) {
        this.tipoIndentificacion = tipoIndentificacion;
    }

    @XmlTransient
    public List<CualidadPersona> getCualidadPersonaList() {
        return cualidadPersonaList;
    }

    public void setCualidadPersonaList(List<CualidadPersona> cualidadPersonaList) {
        this.cualidadPersonaList = cualidadPersonaList;
    }

    @XmlTransient
    public List<ExperienciaLaboral> getExperienciaLaboralList() {
        return experienciaLaboralList;
    }

    public void setExperienciaLaboralList(List<ExperienciaLaboral> experienciaLaboralList) {
        this.experienciaLaboralList = experienciaLaboralList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @XmlTransient
    public List<Educacion> getEducacionList() {
        return educacionList;
    }

    public void setEducacionList(List<Educacion> educacionList) {
        this.educacionList = educacionList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @XmlTransient
    public List<IdiomaPersona> getIdiomaPersonaList() {
        return idiomaPersonaList;
    }

    public void setIdiomaPersonaList(List<IdiomaPersona> idiomaPersonaList) {
        this.idiomaPersonaList = idiomaPersonaList;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Persona[ id=" + id + " ]";
    }
    
}
