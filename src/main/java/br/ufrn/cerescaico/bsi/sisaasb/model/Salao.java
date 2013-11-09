package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jaaday
 */
@Entity
@Table(name = "salao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salao.findAll", query = "SELECT s FROM Salao s"),
    @NamedQuery(name = "Salao.findByCodigo", query = "SELECT s FROM Salao s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Salao.findByCnpj", query = "SELECT s FROM Salao s WHERE s.cnpj = :cnpj"),
    @NamedQuery(name = "Salao.findByNome", query = "SELECT s FROM Salao s WHERE s.nome = :nome"),
    @NamedQuery(name = "Salao.findByNivel", query = "SELECT s FROM Salao s WHERE s.nivel = :nivel"),
    @NamedQuery(name = "Salao.findBySenha", query = "SELECT s FROM Salao s WHERE s.senha = :senha"),
    @NamedQuery(name = "Salao.findByDataCadastro", query = "SELECT s FROM Salao s WHERE s.dataCadastro = :dataCadastro")})
public class Salao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "nivel")
    private Integer nivel;
    @Column(name = "senha")
    private String senha;
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

    public Salao(Integer codigo) {
        this.codigo = codigo;
    }

    public Salao(Integer codigo, String cnpj, String nome) {
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salao)) {
            return false;
        }
        Salao other = (Salao) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Salao[ codigo=" + codigo + " ]";
    }
    
}
