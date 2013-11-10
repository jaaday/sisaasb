package br.ufrn.cerescaico.bsi.sisaasb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")})
public class Usuario extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(length = 50)
	private String login;

	@Column(length = 50)
	private String senha;
	
	@Column(length = 50)
	private String permissao;
    
	public Usuario(){
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
}
