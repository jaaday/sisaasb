package br.ufrn.cerescaico.bsi.sisaasb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import br.ufrn.cerescaico.bsi.sisaasb.model.Funcionario;

@Stateless
public class FuncionarioDAO extends DataAccessService<Funcionario> {

	public FuncionarioDAO(EntityManagerFactory emf) {
		super(Funcionario.class, emf);
	}

	/**
	 * Retorna um novo funcionario
	 * 
	 * @return {@link Funcionario}
	 */
	public Funcionario novoFuncionario() {
		return new Funcionario();
	}

}