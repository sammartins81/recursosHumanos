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
@Table(name = "cualidad_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CualidadPersona.findAll", query = "SELECT c FROM CualidadPersona c")
    , @NamedQuery(name = "CualidadPersona.findById", query = "SELECT c FROM CualidadPersona c WHERE c.id = :id")
    , @NamedQuery(name = "CualidadPersona.findByValor", query = "SELECT c FROM CualidadPersona c WHERE c.valor = :valor")
    , @NamedQuery(name = "CualidadPersona.findByEstado", query = "SELECT c FROM CualidadPersona c WHERE c.estado = :estado")
    , @NamedQuery(name = "CualidadPersona.findByFechaCr", query = "SELECT c FROM CualidadPersona c WHERE c.fechaCr = :fechaCr")
    , @NamedQuery(name = "CualidadPersona.findByFechaAct", query = "SELECT c FROM CualidadPersona c WHERE c.fechaAct = :fechaAct")
    , @NamedQuery(name = "CualidadPersona.findByUsuarioCr", query = "SELECT c FROM CualidadPersona c WHERE c.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "CualidadPersona.findByUsuarioAct", query = "SELECT c FROM CualidadPersona c WHERE c.usuarioAct = :usuarioAct")})
public class CualidadPersona implements Serializable {

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
    @Column(name = "usuario_cr")
    private int usuarioCr;
    @Column(name = "usuario_act")
    private Integer usuarioAct;
    @JoinColumn(name = "cualidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cualidad cualidad;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;

    public CualidadPersona() {
    }

    public CualidadPersona(Integer id) {
        this.id = id;
    }

    public CualidadPersona(Integer id, int valor, String estado, Date fechaCr, int usuarioCr) {
        this.id = id;
        this.valor = valor;
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

    public Cualidad getCualidad() {
        return cualidad;
    }

    public void setCualidad(Cualidad cualidad) {
        this.cualidad = cualidad;
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
        if (!(object instanceof CualidadPersona)) {
            return false;
        }
        CualidadPersona other = (CualidadPersona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.CualidadPersona[ id=" + id + " ]";
    }
    
}
