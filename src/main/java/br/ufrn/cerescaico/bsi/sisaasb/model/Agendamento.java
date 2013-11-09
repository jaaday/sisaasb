package br.ufrn.cerescaico.bsi.sisaasb.model;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jaaday
 */
@Entity
@Table(name = "agendamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a"),
    @NamedQuery(name = "Agendamento.findByCidogo", query = "SELECT a FROM Agendamento a WHERE a.cidogo = :cidogo"),
    @NamedQuery(name = "Agendamento.findByDataAgendamento", query = "SELECT a FROM Agendamento a WHERE a.dataAgendamento = :dataAgendamento"),
    @NamedQuery(name = "Agendamento.findByStatusAgendamento", query = "SELECT a FROM Agendamento a WHERE a.statusAgendamento = :statusAgendamento")})
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cidogo")
    private Integer cidogo;
    @Column(name = "data_agendamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAgendamento;
    @Column(name = "status_agendamento")
    private String statusAgendamento;
    @JoinColumn(name = "servico_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Servico servicoCodigo;
    @JoinColumn(name = "salao_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Salao salaoCodigo;
    @JoinColumn(name = "cliente_codigo", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Cliente clienteCodigo;

    public Agendamento() {
    }

    public Agendamento(Integer cidogo) {
        this.cidogo = cidogo;
    }

    public Integer getCidogo() {
        return cidogo;
    }

    public void setCidogo(Integer cidogo) {
        this.cidogo = cidogo;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
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

    public Cliente getClienteCodigo() {
        return clienteCodigo;
    }

    public void setClienteCodigo(Cliente clienteCodigo) {
        this.clienteCodigo = clienteCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidogo != null ? cidogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamento)) {
            return false;
        }
        Agendamento other = (Agendamento) object;
        if ((this.cidogo == null && other.cidogo != null) || (this.cidogo != null && !this.cidogo.equals(other.cidogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Agendamento[ cidogo=" + cidogo + " ]";
    }
    
}
