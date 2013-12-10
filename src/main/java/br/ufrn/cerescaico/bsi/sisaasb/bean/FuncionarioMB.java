package br.ufrn.cerescaico.bsi.sisaasb.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.ufrn.cerescaico.bsi.sisaasb.dao.FuncionarioDAO;
import br.ufrn.cerescaico.bsi.sisaasb.dao.util.JPAUtil;
import br.ufrn.cerescaico.bsi.sisaasb.model.Funcionario;

@ManagedBean(name="funcionarioMB")
@RequestScoped
public class FuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FuncionarioDAO dao = new FuncionarioDAO(JPAUtil.EMF);
	private Funcionario funcionario = new Funcionario();
	
	public FuncionarioMB(){
		
	}
	
	public FuncionarioDAO getDao() {
		return dao;
	}
	public void setDao(FuncionarioDAO dao) {
		this.dao = dao;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}
