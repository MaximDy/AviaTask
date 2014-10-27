package dao.interfaces;

import javax.persistence.EntityManager;
import java.util.List;

public interface GenericDAO<T>{
    public void setEntityManager(EntityManager entityManager);
    public void persist (T Object);
    public void remove (T Object);
    public List<T> getAll();
    public void update (T Object);
}
