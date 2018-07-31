package loja.carros.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import loja.carros.model.EntidadeBase;

public class GenericoDAO<T extends EntidadeBase> {

    public EntityManager em;

    public GenericoDAO() {
        this.em = new JPAUtil().getEntityManager();
    }

    public T salvar(T t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return t;
    }

    public T atualizar(T t) throws Exception {
        try {
            em.getTransaction().begin();
            if (!em.contains(t)) {
                if (em.find(t.getClass(), t.getId()) == null) {
                    throw new Exception("Erro ao atualizar");
                }
            }
            
            t = em.merge(t);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        
        return t;
    }

    public void remover(Class<T> clazz, Long id) {
        T t = em.find(clazz, id);

        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public T consultarPorId(Class<T> clazz, Long id) {
        T t = null;

        try {
            t = em.find(clazz, id);
        } finally {
            em.close();
        }

        return t;
    }
     
    public List<T> listaTodos(Class<T> clazz) {
        CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(clazz);
        query.select(query.from(clazz));

        List<T> lista = em.createQuery(query).getResultList();

        em.close();
        
        return lista;
    }
    
}
