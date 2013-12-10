package br.ufrn.cerescaico.bsi.sisaasb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import br.ufrn.cerescaico.bsi.sisaasb.model.Servico;

@Stateless
public class ServicoDAO extends DataAccessService<Servico> {

	public ServicoDAO(EntityManagerFactory emf) {
		super(Servico.class, emf);
	}

	/**
	 * Retorna um novo servico
	 * 
	 * @return {@link Servico}
	 */
	public Servico novoServico() {
		return new Servico();
	}

}