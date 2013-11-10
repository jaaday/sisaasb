package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jaaday
 */
@Entity
@Table(name = "agendamento")
@NamedQueries({
    @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a"),
    @NamedQuery(name = "Agendamento.findByDataAgendamento", query = "SELECT a FROM Agendamento a WHERE a.dataAgendamento = :dataAgendamento"),
    @NamedQuery(name = "Agendamento.findByStatusAgendamento", query = "SELECT a FROM Agendamento a WHERE a.statusAgendamento = :statusAgendamento")})
public class Agendamento extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

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
    
}
