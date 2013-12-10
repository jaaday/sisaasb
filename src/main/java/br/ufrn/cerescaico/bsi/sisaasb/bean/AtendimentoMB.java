package br.ufrn.cerescaico.bsi.sisaasb.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.cerescaico.bsi.sisaasb.dao.AtendimentoDAO;
import br.ufrn.cerescaico.bsi.sisaasb.dao.util.JPAUtil;
import br.ufrn.cerescaico.bsi.sisaasb.model.Atendimento;

@ManagedBean(name="atendimentoMB")
@RequestScoped
public class AtendimentoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AtendimentoDAO dao = new AtendimentoDAO(JPAUtil.EMF);
	private Atendimento atendimento = new Atendimento();
	
	public AtendimentoMB(){
		
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public AtendimentoDAO getDao() {
		return dao;
	}

	public void setDao(AtendimentoDAO dao) {
		this.dao = dao;
	}

}
