package br.com.ChameleonEJB.DAO;

import br.com.ChameleonEJB.Remote.BaseRemote;
import javax.persistence.EntityManager;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;

@MappedSuperclass
public class BaseDao<T> implements BaseRemote {

    private Class<T> objeto;

    @PersistenceContext(unitName = "ChameleonEJB_PU")
    protected EntityManager entityManager;

    public void setClass(Class<T> object) {
        this.objeto = object;
    }

    public T save(T obj, Long id) throws Exception {
        if (id == null) {
            add(obj);
        } else {
            if (!entityManager.contains(obj)) {
                if (getById(id) == null) {
                    throw new Exception("Erro ao atualizar os dados!");
                }
            }
            obj = (T) update(obj);
        }
        return obj;
    }

    @Override
    public T getById(Long id) {
        return entityManager.find(objeto, id);
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
