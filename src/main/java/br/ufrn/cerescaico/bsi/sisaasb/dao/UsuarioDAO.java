package br.ufrn.cerescaico.bsi.sisaasb.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufrn.cerescaico.bsi.sisaasb.model.Usuario;

public class UsuarioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf = null;

	public UsuarioDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public void create(Usuario user) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void edit(Usuario user) throws Exception {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			user = em.merge(user);
			em.getTransaction().commit();
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void destroy(Integer id) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			Usuario user = null;
			try {
				user = em.getReference(Usuario.class, id);
				user.getId();
			} catch (EntityNotFoundException enfe) {
				
			}
			em.remove(user);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public List<Usuario> findUserEntities() {
		return findUserEntities(true, -1, -1);
	}

	public List<Usuario> findUserEntities(int maxResults, int firstResult) {
		return findUserEntities(false, maxResults, firstResult);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<Usuario> findUserEntities(boolean all, int maxResults,
			int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Usuario.class));
			Query q = em.createQuery(cq);
			if (!all) {
				q.setMaxResults(maxResults);
				q.setFirstResult(firstResult);
			}
			return q.getResultList();
		} finally {
			em.close();
		}
	}

	public Usuario findUser(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(Usuario.class, id);
		} finally {
			em.close();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int getUserCount() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			Root<Usuario> rt = cq.from(Usuario.class);
			cq.select(em.getCriteriaBuilder().count(rt));
			Query q = em.createQuery(cq);
			return ((Long) q.getSingleResult()).intValue();
		} finally {
			em.close();
		}
	}

	public Usuario findLogin(String login, String senha) {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createNamedQuery("Usuario.findLogin");
			q.setParameter("login", login);
			q.setParameter("senha", senha);
			return (Usuario)q.getSingleResult();
		} catch (Exception e) {
			return null;
		} finally {
			em.close();
		}
	}
 
}