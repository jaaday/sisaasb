package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaaday
 */
@Entity
@Table(name = "atendimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atendimento.findAll", query = "SELECT a FROM Atendimento a"),
    @NamedQuery(name = "Atendimento.findByCodigo", query = "SELECT a FROM Atendimento a WHERE a.codigo = :codigo"),
    @NamedQuery(name = "Atendimento.findByValor", query = "SELECT a FROM Atendimento a WHERE a.valor = :valor"),
    @NamedQuery(name = "Atendimento.findByStatusAtendimento", query = "SELECT a FROM Atendimento a WHERE a.statusAtendimento = :statusAtendimento"),
    @NamedQuery(name = "Atendimento.findByDataAtendimento", query = "SELECT a FROM Atendimento a WHERE a.dataAtendimento = :dataAtendimento")})
public class Atendimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "status_atendimento")
    private String statusAtendimento;
    @Column(name = "data_atendimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtendimento;
    @JoinColumn(name = "servico_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Servico servicoCodigo;
    @JoinColumn(name = "salao_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Salao salaoCodigo;
    @JoinColumn(name = "funcionario_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Funcionario funcionarioCodigo;
    @JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente clienteCodigo;

    public Atendimento() {
    }

    public Atendimento(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(String statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Servico getServicoCodigo() {
        return servicoCodigo;
    }

    public void setServicoCodigo(Servico servicoCodigo) {
        this.servicoCodigo = servicoCodigo;
    }

    public Salao getSalaoCodigo() {
        return salaoCodigo;
    }

    public void setSalaoCodigo(Salao salaoCodigo) {
        this.salaoCodigo = salaoCodigo;
    }

    public Funcionario getFuncionarioCodigo() {
        return funcionarioCodigo;
    }

    public void setFuncionarioCodigo(Funcionario funcionarioCodigo) {
        this.funcionarioCodigo = funcionarioCodigo;
    }

    public Cliente getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Cliente clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
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
        if (!(object instanceof Atendimento)) {
            return false;
        }
        Atendimento other = (Atendimento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Atendimento[ codigo=" + codigo + " ]";
    }
    
}
