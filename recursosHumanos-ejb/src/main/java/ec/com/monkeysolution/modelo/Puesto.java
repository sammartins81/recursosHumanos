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
@Table(name = "puesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p")
    , @NamedQuery(name = "Puesto.findById", query = "SELECT p FROM Puesto p WHERE p.id = :id")
    , @NamedQuery(name = "Puesto.findByNombre", query = "SELECT p FROM Puesto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Puesto.findByEstado", query = "SELECT p FROM Puesto p WHERE p.estado = :estado")
    , @NamedQuery(name = "Puesto.findByFechaCr", query = "SELECT p FROM Puesto p WHERE p.fechaCr = :fechaCr")
    , @NamedQuery(name = "Puesto.findByFechaAct", query = "SELECT p FROM Puesto p WHERE p.fechaAct = :fechaAct")
    , @NamedQuery(name = "Puesto.findByUsuarioCr", query = "SELECT p FROM Puesto p WHERE p.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "Puesto.findByUsuarioAct", query = "SELECT p FROM Puesto p WHERE p.usuarioAct = :usuarioAct")})
public class Puesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombre")
    private String nombre;
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
    @JoinColumn(name = "area", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "tipo_puesto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoPuesto tipoPuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puesto")
    private List<Persona> personaList;

    public Puesto() {
    }

    public Puesto(Integer id) {
        this.id = id;
    }

    public Puesto(Integer id, String nombre, String estado, Date fechaCr, int usuarioCr) {
        this.id = id;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TipoPuesto getTipoPuesto() {
        return tipoPuesto;
    }

    public void setTipoPuesto(TipoPuesto tipoPuesto) {
        this.tipoPuesto = tipoPuesto;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
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
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Puesto[ id=" + id + " ]";
    }
    
}
