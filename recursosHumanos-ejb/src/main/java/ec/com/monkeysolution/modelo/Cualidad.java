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
@Table(name = "cualidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cualidad.findAll", query = "SELECT c FROM Cualidad c")
    , @NamedQuery(name = "Cualidad.findById", query = "SELECT c FROM Cualidad c WHERE c.id = :id")
    , @NamedQuery(name = "Cualidad.findByNombre", query = "SELECT c FROM Cualidad c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cualidad.findByEstado", query = "SELECT c FROM Cualidad c WHERE c.estado = :estado")
    , @NamedQuery(name = "Cualidad.findByFechaCr", query = "SELECT c FROM Cualidad c WHERE c.fechaCr = :fechaCr")
    , @NamedQuery(name = "Cualidad.findByFechaAct", query = "SELECT c FROM Cualidad c WHERE c.fechaAct = :fechaAct")
    , @NamedQuery(name = "Cualidad.findByUsuarioCr", query = "SELECT c FROM Cualidad c WHERE c.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "Cualidad.findByUsuarioAct", query = "SELECT c FROM Cualidad c WHERE c.usuarioAct = :usuarioAct")})
public class Cualidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cualidad")
    private List<CualidadPersona> cualidadPersonaList;
    @JoinColumn(name = "tipo_cualidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoCualidad tipoCualidad;

    public Cualidad() {
    }

    public Cualidad(Integer id) {
        this.id = id;
    }

    public Cualidad(Integer id, String nombre, String estado, Date fechaCr, int usuarioCr) {
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

    @XmlTransient
    public List<CualidadPersona> getCualidadPersonaList() {
        return cualidadPersonaList;
    }

    public void setCualidadPersonaList(List<CualidadPersona> cualidadPersonaList) {
        this.cualidadPersonaList = cualidadPersonaList;
    }

    public TipoCualidad getTipoCualidad() {
        return tipoCualidad;
    }

    public void setTipoCualidad(TipoCualidad tipoCualidad) {
        this.tipoCualidad = tipoCualidad;
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
        if (!(object instanceof Cualidad)) {
            return false;
        }
        Cualidad other = (Cualidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Cualidad[ id=" + id + " ]";
    }
    
}
