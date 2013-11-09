package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jaaday
 */
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) servicoCodigo;
        hash += (int) funcionarioCodigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HabilidadePK)) {
            return false;
        }
        HabilidadePK other = (HabilidadePK) object;
        if (this.servicoCodigo != other.servicoCodigo) {
            return false;
        }
        if (this.funcionarioCodigo != other.funcionarioCodigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HabilidadePK[ servicoCodigo=" + servicoCodigo + ", funcionarioCodigo=" + funcionarioCodigo + " ]";
    }
    
}
