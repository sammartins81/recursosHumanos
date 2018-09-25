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
@Table(name = "clave_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClaveUsuario.findAll", query = "SELECT c FROM ClaveUsuario c")
    , @NamedQuery(name = "ClaveUsuario.findById", query = "SELECT c FROM ClaveUsuario c WHERE c.id = :id")
    , @NamedQuery(name = "ClaveUsuario.findByClave", query = "SELECT c FROM ClaveUsuario c WHERE c.clave = :clave")
    , @NamedQuery(name = "ClaveUsuario.findByFechaCr", query = "SELECT c FROM ClaveUsuario c WHERE c.fechaCr = :fechaCr")
    , @NamedQuery(name = "ClaveUsuario.findByFechaAct", query = "SELECT c FROM ClaveUsuario c WHERE c.fechaAct = :fechaAct")
    , @NamedQuery(name = "ClaveUsuario.findByUsuarioCr", query = "SELECT c FROM ClaveUsuario c WHERE c.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "ClaveUsuario.findByUsuarioAct", query = "SELECT c FROM ClaveUsuario c WHERE c.usuarioAct = :usuarioAct")
    , @NamedQuery(name = "ClaveUsuario.findByEstado", query = "SELECT c FROM ClaveUsuario c WHERE c.estado = :estado")})
public class ClaveUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "clave")
    private String clave;
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
    @JoinColumn(name = "usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario usuario;

    public ClaveUsuario() {
    }

    public ClaveUsuario(Integer id) {
        this.id = id;
    }

    public ClaveUsuario(Integer id, String clave, Date fechaCr, int usuarioCr, String estado) {
        this.id = id;
        this.clave = clave;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        if (!(object instanceof ClaveUsuario)) {
            return false;
        }
        ClaveUsuario other = (ClaveUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.ClaveUsuario[ id=" + id + " ]";
    }
    
}
