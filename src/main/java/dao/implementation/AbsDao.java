package dao.implementation;

import dao.interfaces.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbsDao<T> implements GenericDAO<T> {
    protected Class<T> entityClass;
    @PersistenceContext
    protected EntityManager entityManager;

    public AbsDao() {
        //noinspection unchecked
        this.entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public AbsDao(final Class<T> entityClass){
        super();
        this.entityClass = entityClass;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(T Object){
        entityManager.getTransaction().begin();
        entityManager.persist(Object);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(T Object) {
        entityManager.getTransaction().begin();
        entityManager.remove(Object);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<T> getAll() {
        //noinspection unchecked
        return entityManager.createQuery("SELECT a FROM " + entityClass.getName() + " a").getResultList();
    }

    @Override
    public void update(T Object) {
        entityManager.getTransaction().begin();
        entityManager.merge(Object);
        entityManager.getTransaction().commit();
    }
}
