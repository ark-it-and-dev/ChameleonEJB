package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Remote.BaseRemote;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDao<T> implements BaseRemote {

    private Class<T> object;

    @PersistenceContext(unitName = "ChameleonEJB_PU")
    protected EntityManager entityManager;

    public void setClass(Class<T> object) {
        this.object = object;
    }

    public T save(T obj, Long id) throws Exception {
        if (id == null) {
            add(obj);
        } else {
            if (!entityManager.contains(obj)) {
                if (getById(id) == null) {
                    throw new Exception("Erro ao atualizar os dados do produto!");
                }
            }
            obj = (T) update(obj);
        }
        return obj;
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(object, id);
    }

    @Override
    public void add(Object obj) {
        entityManager.persist(obj);
    }

    @Override
    public Object update(Object obj) {
        return entityManager.merge(obj);
    }
}
