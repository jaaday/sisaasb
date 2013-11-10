package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jaaday
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Cliente.findByDataCadastro", query = "SELECT c FROM Cliente c WHERE c.dataCadastro = :dataCadastro")})
public class Cliente extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "senha")
    private String senha;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteCodigo")
    private Collection<Atendimento> atendimentoCollection;
    @JoinColumn(name = "salao_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Salao salaoCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteCodigo")
    private Collection<Agendamento> agendamentoCollection;
    @OneToOne(cascade = {CascadeType.ALL})
    private Usuario usuario;

	public Cliente() {
    }

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
    public Collection<Atendimento> getAtendimentoCollection() {
        return atendimentoCollection;
    }

    public void setAtendimentoCollection(Collection<Atendimento> atendimentoCollection) {
        this.atendimentoCollection = atendimentoCollection;
    }

    public Salao getSalaoCodigo() {
        return salaoCodigo;
    }

    public void setSalaoCodigo(Salao salaoCodigo) {
        this.salaoCodigo = salaoCodigo;
    }

	@XmlTransient
    public Collection<Agendamento> getAgendamentoCollection() {
        return agendamentoCollection;
    }

    public void setAgendamentoCollection(Collection<Agendamento> agendamentoCollection) {
        this.agendamentoCollection = agendamentoCollection;
    }
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
