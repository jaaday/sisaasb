package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jaaday
 */
@Entity
@Table(name = "servico")
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByValorServico", query = "SELECT s FROM Servico s WHERE s.valorServico = :valorServico"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Servico.findByDuracaoMedia", query = "SELECT s FROM Servico s WHERE s.duracaoMedia = :duracaoMedia"),
    @NamedQuery(name = "Servico.findByDataCadastro", query = "SELECT s FROM Servico s WHERE s.dataCadastro = :dataCadastro")})
public class Servico extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_servico")
    private BigDecimal valorServico;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "duracao_media")
    @Temporal(TemporalType.TIME)
    private Date duracaoMedia;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @JoinColumn(name = "salao_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Salao salaoCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoCodigo")
    private Collection<Atendimento> atendimentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicoCodigo")
    private Collection<Agendamento> agendamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servico")
    private Collection<Habilidade> habilidadeCollection;

    public Servico() {
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDuracaoMedia() {
        return duracaoMedia;
    }

    public void setDuracaoMedia(Date duracaoMedia) {
        this.duracaoMedia = duracaoMedia;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Salao getSalaoCodigo() {
        return salaoCodigo;
    }

    public void setSalaoCodigo(Salao salaoCodigo) {
        this.salaoCodigo = salaoCodigo;
    }

    @XmlTransient
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    @XmlTransient
    public Collection<Agendamento> getAgendamentoCollection() {
        return agendamentoCollection;
    }

    public void setAgendamentoCollection(Collection<Agendamento> agendamentoCollection) {
        this.agendamentoCollection = agendamentoCollection;
    }

    @XmlTransient
    public Collection<Habilidade> getHabilidadeCollection() {
        return habilidadeCollection;
    }

    public void setHabilidadeCollection(Collection<Habilidade> habilidadeCollection) {
        this.habilidadeCollection = habilidadeCollection;
    }
    
}
