package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaaday
 */
@Entity
@Table(name = "habilidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Habilidade.findAll", query = "SELECT h FROM Habilidade h"),
    @NamedQuery(name = "Habilidade.findByServicoCodigo", query = "SELECT h FROM Habilidade h WHERE h.habilidadePK.servicoCodigo = :servicoCodigo"),
    @NamedQuery(name = "Habilidade.findByFuncionarioCodigo", query = "SELECT h FROM Habilidade h WHERE h.habilidadePK.funcionarioCodigo = :funcionarioCodigo"),
    @NamedQuery(name = "Habilidade.findByNivel", query = "SELECT h FROM Habilidade h WHERE h.nivel = :nivel"),
    @NamedQuery(name = "Habilidade.findByDataCadastro", query = "SELECT h FROM Habilidade h WHERE h.dataCadastro = :dataCadastro")})
public class Habilidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HabilidadePK habilidadePK;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @JoinColumn(name = "servico_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Servico servico;
    @JoinColumn(name = "funcionario_codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Funcionario funcionario;

    public Habilidade() {
    }

    public Habilidade(HabilidadePK habilidadePK) {
        this.habilidadePK = habilidadePK;
    }

    public Habilidade(int servicoCodigo, int funcionarioCodigo) {
        this.habilidadePK = new HabilidadePK(servicoCodigo, funcionarioCodigo);
    }

    public HabilidadePK getHabilidadePK() {
        return habilidadePK;
    }

    public void setHabilidadePK(HabilidadePK habilidadePK) {
        this.habilidadePK = habilidadePK;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (habilidadePK != null ? habilidadePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habilidade)) {
            return false;
        }
        Habilidade other = (Habilidade) object;
        if ((this.habilidadePK == null && other.habilidadePK != null) || (this.habilidadePK != null && !this.habilidadePK.equals(other.habilidadePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Habilidade[ habilidadePK=" + habilidadePK + " ]";
    }
    
}
