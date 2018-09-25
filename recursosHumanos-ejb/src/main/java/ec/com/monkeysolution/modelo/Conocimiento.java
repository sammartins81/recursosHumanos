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
@Table(name = "conocimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conocimiento.findAll", query = "SELECT c FROM Conocimiento c")
    , @NamedQuery(name = "Conocimiento.findById", query = "SELECT c FROM Conocimiento c WHERE c.id = :id")
    , @NamedQuery(name = "Conocimiento.findByTitulo", query = "SELECT c FROM Conocimiento c WHERE c.titulo = :titulo")
    , @NamedQuery(name = "Conocimiento.findByDescripcion", query = "SELECT c FROM Conocimiento c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Conocimiento.findByEstado", query = "SELECT c FROM Conocimiento c WHERE c.estado = :estado")
    , @NamedQuery(name = "Conocimiento.findByFechaCr", query = "SELECT c FROM Conocimiento c WHERE c.fechaCr = :fechaCr")
    , @NamedQuery(name = "Conocimiento.findByFechaAct", query = "SELECT c FROM Conocimiento c WHERE c.fechaAct = :fechaAct")
    , @NamedQuery(name = "Conocimiento.findByUsuarioCr", query = "SELECT c FROM Conocimiento c WHERE c.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "Conocimiento.findByUsuarioAct", query = "SELECT c FROM Conocimiento c WHERE c.usuarioAct = :usuarioAct")})
public class Conocimiento implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_cr")
    private int usuarioCr;
    @Column(name = "usuario_act")
    private Integer usuarioAct;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;

    public Conocimiento() {
    }

    public Conocimiento(Integer id) {
        this.id = id;
    }

    public Conocimiento(Integer id, String titulo, String descripcion, String estado, Date fechaCr, int usuarioCr) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
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
        if (!(object instanceof Conocimiento)) {
            return false;
        }
        Conocimiento other = (Conocimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.Conocimiento[ id=" + id + " ]";
    }
    
}
