package br.ufrn.cerescaico.bsi.sisaasb.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.ufrn.cerescaico.bsi.sisaasb.dao.ServicoDAO;
import br.ufrn.cerescaico.bsi.sisaasb.dao.util.JPAUtil;
import br.ufrn.cerescaico.bsi.sisaasb.model.Servico;

@ManagedBean(name="servicoMB")
@RequestScoped
public class ServicoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ServicoDAO dao = new ServicoDAO(JPAUtil.EMF);
	private Servico servico = new Servico();
	
	public ServicoMB(){
		
	}

	public ServicoDAO getDao() {
		return dao;
	}

	public void setDao(ServicoDAO dao) {
		this.dao = dao;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
