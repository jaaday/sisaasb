package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "salao")
@NamedQueries({
    @NamedQuery(name = "Salao.findAll", query = "SELECT s FROM Salao s"),
    @NamedQuery(name = "Salao.findByCnpj", query = "SELECT s FROM Salao s WHERE s.cnpj = :cnpj"),
    @NamedQuery(name = "Salao.findByNome", query = "SELECT s FROM Salao s WHERE s.nome = :nome"),
    @NamedQuery(name = "Salao.findByNivel", query = "SELECT s FROM Salao s WHERE s.nivel = :nivel"),
    @NamedQuery(name = "Salao.findByDataCadastro", query = "SELECT s FROM Salao s WHERE s.dataCadastro = :dataCadastro")})
public class Salao extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaoCodigo")
    private Collection<Servico> servicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaoCodigo")
    private Collection<Atendimento> atendimentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaoCodigo")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaoCodigo")
    private Collection<Agendamento> agendamentoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salaoCodigo")
    private Collection<Funcionario> funcionarioCollection;

    public Salao() {
    }

    public Salao(Integer codigo, String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @XmlTransient
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Agendamento> getAgendamentoCollection() {
        return agendamentoCollection;
    }

    public void setAgendamentoCollection(Collection<Agendamento> agendamentoCollection) {
        this.agendamentoCollection = agendamentoCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }
    
}
