package br.ufrn.cerescaico.bsi.sisaasb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import br.ufrn.cerescaico.bsi.sisaasb.model.Agendamento;

@Stateless
public class AgendamentoDAO extends DataAccessService<Agendamento> {

	public AgendamentoDAO(EntityManagerFactory emf) {
		super(Agendamento.class, emf);
	}

	/**
	 * Retorna um novo agendamento
	 * 
	 * @return {@link Agendamento}
	 */
	public Agendamento novoAgendamento() {
		return new Agendamento();
	}

}
