package br.ufrn.cerescaico.bsi.sisaasb.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.ufrn.cerescaico.bsi.sisaasb.dao.ClienteDAO;
import br.ufrn.cerescaico.bsi.sisaasb.dao.util.JPAUtil;
import br.ufrn.cerescaico.bsi.sisaasb.model.Cliente;

@ManagedBean(name="clienteMB")
@RequestScoped
public class ClienteMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClienteDAO dao = new ClienteDAO(JPAUtil.EMF);
	private Cliente cliente = new Cliente();
	
	public ClienteMB(){
	}

	public ClienteDAO getDao() {
		return dao;
	}

	public void setDao(ClienteDAO dao) {
		this.dao = dao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
