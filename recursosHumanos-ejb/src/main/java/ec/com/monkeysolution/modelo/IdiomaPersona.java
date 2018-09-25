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
@Table(name = "idioma_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IdiomaPersona.findAll", query = "SELECT i FROM IdiomaPersona i")
    , @NamedQuery(name = "IdiomaPersona.findById", query = "SELECT i FROM IdiomaPersona i WHERE i.id = :id")
    , @NamedQuery(name = "IdiomaPersona.findByNivelEscrito", query = "SELECT i FROM IdiomaPersona i WHERE i.nivelEscrito = :nivelEscrito")
    , @NamedQuery(name = "IdiomaPersona.findByNivelOral", query = "SELECT i FROM IdiomaPersona i WHERE i.nivelOral = :nivelOral")
    , @NamedQuery(name = "IdiomaPersona.findByEstado", query = "SELECT i FROM IdiomaPersona i WHERE i.estado = :estado")
    , @NamedQuery(name = "IdiomaPersona.findByFechaCr", query = "SELECT i FROM IdiomaPersona i WHERE i.fechaCr = :fechaCr")
    , @NamedQuery(name = "IdiomaPersona.findByFechaAct", query = "SELECT i FROM IdiomaPersona i WHERE i.fechaAct = :fechaAct")
    , @NamedQuery(name = "IdiomaPersona.findByUsuarioCr", query = "SELECT i FROM IdiomaPersona i WHERE i.usuarioCr = :usuarioCr")
    , @NamedQuery(name = "IdiomaPersona.findByUsuarioAct", query = "SELECT i FROM IdiomaPersona i WHERE i.usuarioAct = :usuarioAct")})
public class IdiomaPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nivel_escrito")
    private String nivelEscrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nivel_oral")
    private String nivelOral;
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
    @JoinColumn(name = "idioma", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Idioma idioma;
    @JoinColumn(name = "persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona persona;

    public IdiomaPersona() {
    }

    public IdiomaPersona(Integer id) {
        this.id = id;
    }

    public IdiomaPersona(Integer id, String nivelEscrito, String nivelOral, String estado, Date fechaCr, int usuarioCr) {
        this.id = id;
        this.nivelEscrito = nivelEscrito;
        this.nivelOral = nivelOral;
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

    public String getNivelEscrito() {
        return nivelEscrito;
    }

    public void setNivelEscrito(String nivelEscrito) {
        this.nivelEscrito = nivelEscrito;
    }

    public String getNivelOral() {
        return nivelOral;
    }

    public void setNivelOral(String nivelOral) {
        this.nivelOral = nivelOral;
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

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
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
        if (!(object instanceof IdiomaPersona)) {
            return false;
        }
        IdiomaPersona other = (IdiomaPersona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.monkeysolution.modelo.IdiomaPersona[ id=" + id + " ]";
    }
    
}
