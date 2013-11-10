package br.ufrn.cerescaico.bsi.sisaasb.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.ufrn.cerescaico.bsi.sisaasb.dao.UsuarioDAO;
import br.ufrn.cerescaico.bsi.sisaasb.dao.util.JPAUtil;
import br.ufrn.cerescaico.bsi.sisaasb.model.Usuario;

@ManagedBean
@RequestScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private UsuarioDAO dao;
	
	private String username;
    private String password;

    public LoginController() {
    	usuario = new Usuario();
    	dao = new UsuarioDAO(JPAUtil.EMF);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    public String logar(){
    	usuario = dao.findLogin(username, password);
    	if(usuario == null){
    		return "goToPageIndex";
    	}
    	return "";
    }
    
}
