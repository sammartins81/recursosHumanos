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
@Table(name = "estado_civil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
    , @NamedQuery(name = "EstadoCivil.findById", query = "SELECT e FROM EstadoCivil e WHERE e.id = :id")
    , @NamedQuery(name = "EstadoCivil.findByNombre", query = "SELECT e FROM EstadoCivil e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EstadoCivil.findByEstado", query = "SELECT e FROM EstadoCivil e WHERE e.estado = :estado")
    , @NamedQuery(name = "EstadoCivil.findByFechaCr", query = "SELECT e FROM EstadoCivil e WHERE e.fechaCr = :fechaCr")
    , @NamedQuery(name = "EstadoCivil.findByFechaAct", query = "SELECT e FROM EstadoCivil e WHERE e.fechaAct = :fechaAct")
    , @NamedQuery(name = "EstadoCivil.findByUsuarioCr", query = "SELECT e FROM EstadoCivil e WHERE e.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "EstadoCivil.findByUsuarioAct", query = "SELECT e FROM EstadoCivil e WHERE e.usuarioAct = :usuarioAct")})
public class EstadoCivil implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoCivil")
    private List<Persona> personaList;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer id) {
        this.id = id;
    }

    public EstadoCivil(Integer id, String nombre, String estado, Date fechaCr, int usuarioCr) {
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
        if (!(object instanceof EstadoCivil)) {
            return false;
        }
        EstadoCivil other = (EstadoCivil) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.EstadoCivil[ id=" + id + " ]";
    }
    
}
