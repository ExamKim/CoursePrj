package dao.impl;

import config.JPAUtil;
import dao.GenericDao;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.glassfish.jaxb.core.v2.model.core.ID;

import java.util.List;
import java.util.function.Function;

public class AbstractGenericDaoImpl<T,ID> implements GenericDao<T, ID> {

    protected Class<T> entityClass;

    public AbstractGenericDaoImpl(Class<T> entityClass){
        this.entityClass=entityClass;
    }

    protected <R,T> R doInTransaction(Function<EntityManager,R> function){
        EntityManager em= null;
        EntityTransaction tx= null;
        try{
            em = JPAUtil.getEm();
            tx= em.getTransaction();
            tx.begin();
            R result= function.apply(em);
            tx.commit();
            return result;
        }catch(Exception ex){
            if (tx!=null&&tx.isActive())
                tx.rollback();
            throw new RuntimeException(ex);
        }finally {
            if(em!=null && em.isOpen())
                em.close();
        }
    }

    @Override
    public T create(T t) {
        return doInTransaction(em->{
            em.persist(t);
            return t;
        });
    }

    @Override
    public T update(T t) {
        return doInTransaction(em->{
            return em.merge(t);
        });
    }

    @Override
    public boolean delete(ID id) {
        return doInTransaction(em->{
            T t = em.find(entityClass,id);
            em.remove(t);
            return true;
        });
    }

    @Override
    public T findById(ID id) {
        return doInTransaction(em->{
            return em.find(entityClass,id);
        });
    }

    @Override
    public List<T> loadAll() {
        String query= "FROM "+ entityClass.getSimpleName();
        return doInTransaction(em->{
           return em.createQuery(query,entityClass).getResultList();
        });
    }
}
