package br.ufrn.cerescaico.bsi.sisaasb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public abstract class DataAccessService<T> {

	private EntityManagerFactory emf = null;
	private Class<T> type;

	public DataAccessService() {
	}

	public DataAccessService(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public DataAccessService(Class<T> type) {
		this.type = type;
	}

	public void create(T t) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public T find(Integer id) {
		EntityManager em = getEntityManager();
		try {
			return em.find(this.type, id);
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public void destroy(Integer id) {

		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();

			try {
				this.type = (Class<T>) em.getReference(type, id);
			} catch (EntityNotFoundException enfe) {

			}
			em.remove(this.type);
			em.getTransaction().commit();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	public void update(T item) {
		EntityManager em = null;
		try {
			em = getEntityManager();
			em.getTransaction().begin();
			item = em.merge(item);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public List<T> findEntities() {
		return findEntities(true, -1, -1);
	}

	public List<T> findEntities(int maxResults, int firstResult) {
		return findEntities(false, maxResults, firstResult);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<T> findEntities(boolean all, int maxResults,
			int firstResult) {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(type));
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

}
