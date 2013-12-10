package br.ufrn.cerescaico.bsi.sisaasb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import br.ufrn.cerescaico.bsi.sisaasb.model.Atendimento;

@Stateless
public class AtendimentoDAO extends DataAccessService<Atendimento> {

	public AtendimentoDAO(EntityManagerFactory emf) {
		super(Atendimento.class, emf);
	}

	/**
	 * Retorna um novo atendimento
	 * 
	 * @return {@link Atendimento}
	 */
	public Atendimento novoAtendimento() {
		return new Atendimento();
	}

}