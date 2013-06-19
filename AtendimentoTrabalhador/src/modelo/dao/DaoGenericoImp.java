package modelo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class DaoGenericoImp<T, ID extends Serializable>
implements DaoGenerico<T, ID> {


	private EntityManager entityManager;

	private final Class<T> oClass;//object class

	public Class<T> getObjectClass() {
		return this.oClass;
	}


	@PersistenceContext(unitName="AtendimentoTrabalhador")
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	protected EntityManager getEntityManager() {
		EntityManagerFactory emf;
		if (entityManager == null) {
			try{
				emf = Persistence.createEntityManagerFactory("AtendimentoTrabalhador");
				entityManager=emf.createEntityManager();
			}catch(IllegalStateException isexc){
				throw new IllegalStateException(isexc);
			}
		}
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public DaoGenericoImp() {
		this.oClass = (Class<T>)
				( (ParameterizedType) getClass().getGenericSuperclass() ).
				getActualTypeArguments()[0];

	}

	public T atualizar(T object) {
		EntityManager em;
		em = getEntityManager();
		em.getTransaction().begin();
		object = em.merge(object);
		em.getTransaction().commit();
		return object;

	}

	public void excluir(T object) {
		object = getEntityManager().merge(object);
		getEntityManager().remove(object);
	}


	public T pesquisarPorId(ID id) {
		return getEntityManager().find(oClass, id);
	}

	public T salvar(T object) {
		
		getEntityManager().clear();
		getEntityManager().persist(object);
		//getEntityManager().flush();

		return object;
	}

	@SuppressWarnings("unchecked")
	public List<T> todos(){
		String queryS = "SELECT obj FROM "+oClass.getSimpleName()+" obj";
		Query query = getEntityManager().createQuery(queryS);
		return query.getResultList();

	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String query, Map<String, Object> params){
		Query q = getEntityManager().createQuery(query);
		for(String chave : params.keySet()){
			q.setParameter(chave, params.get(chave));

		}
		
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesqParam(String query, Map<String, Object> params,
			int maximo, int atual){
		Query q = getEntityManager().
				createQuery(query).
				setMaxResults(maximo).
				setFirstResult(atual);

		for(String chave : params.keySet()){
			q.setParameter(chave, params.get(chave));

		}
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> listPesq(String query){
		Query q = getEntityManager().createQuery(query);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public T pesqParam(String query, Map<String, Object> params){
		Query q = getEntityManager().createQuery(query);
		for(String chave : params.keySet()){
			q.setParameter(chave, params.get(chave));

		}
		try{
			return (T) q.getSingleResult();
		}catch(NoResultException nre){
			return null;
		}
	}

}
