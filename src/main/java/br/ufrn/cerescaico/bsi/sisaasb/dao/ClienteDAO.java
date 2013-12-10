package br.ufrn.cerescaico.bsi.sisaasb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import br.ufrn.cerescaico.bsi.sisaasb.model.Cliente;

@Stateless
public class ClienteDAO extends DataAccessService<Cliente> {

	public ClienteDAO(EntityManagerFactory emf) {
		super(Cliente.class, emf);
	}

	/**
	 * Retorna um novo cliente
	 * 
	 * @return {@link Cliente}
	 */
	public Cliente novoCliente() {
		return new Cliente();
	}

}