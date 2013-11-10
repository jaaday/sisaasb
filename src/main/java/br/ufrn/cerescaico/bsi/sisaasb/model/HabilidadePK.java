package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jaaday
 */
@SuppressWarnings("serial")
@Embeddable
public class HabilidadePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "servico_codigo")
    private int servicoCodigo;
    @Basic(optional = false)
    @Column(name = "funcionario_codigo")
    private int funcionarioCodigo;

    public HabilidadePK() {
    }

    public HabilidadePK(int servicoCodigo, int funcionarioCodigo) {
        this.servicoCodigo = servicoCodigo;
        this.funcionarioCodigo = funcionarioCodigo;
    }

    public int getServicoCodigo() {
        return servicoCodigo;
    }

    public void setServicoCodigo(int servicoCodigo) {
        this.servicoCodigo = servicoCodigo;
    }

    public int getFuncionarioCodigo() {
        return funcionarioCodigo;
    }

    public void setFuncionarioCodigo(int funcionarioCodigo) {
        this.funcionarioCodigo = funcionarioCodigo;
    }
    
}
