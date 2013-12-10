package br.ufrn.cerescaico.bsi.sisaasb.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.cerescaico.bsi.sisaasb.dao.AgendamentoDAO;
import br.ufrn.cerescaico.bsi.sisaasb.dao.util.JPAUtil;
import br.ufrn.cerescaico.bsi.sisaasb.model.Agendamento;

@ManagedBean(name="agendamentoMB")
@RequestScoped
public class AgendamentoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AgendamentoDAO dao = new AgendamentoDAO(JPAUtil.EMF);
	private Agendamento agendamento = new Agendamento();
	
	public AgendamentoMB(){
		
	}

	public AgendamentoDAO getDao() {
		return dao;
	}

	public void setDao(AgendamentoDAO dao) {
		this.dao = dao;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

}
