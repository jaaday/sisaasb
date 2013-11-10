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
@Table(name = "habilidade")
@NamedQueries({
    @NamedQuery(name = "Habilidade.findAll", query = "SELECT h FROM Habilidade h"),
    @NamedQuery(name = "Habilidade.findByNivel", query = "SELECT h FROM Habilidade h WHERE h.nivel = :nivel"),
    @NamedQuery(name = "Habilidade.findByDataCadastro", query = "SELECT h FROM Habilidade h WHERE h.dataCadastro = :dataCadastro")})
public class Habilidade extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
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

}
