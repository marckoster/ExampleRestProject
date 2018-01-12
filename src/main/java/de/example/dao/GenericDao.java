package de.example.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * GenericDao Service for persist, merge, find an remove JPA Entities
 * 
 * @author Marc Koster
 * @version $Revision$
 *
 */

@Named
@Stateless
public class GenericDao implements Serializable
{
	//TODO change unitName to new Project
    @PersistenceContext(unitName = "ExampleRestProject")
    private EntityManager entityManager;

    public GenericDao()
    {
    }

    private static final long serialVersionUID = 1L;

    @Transactional
    public <T> void persist(T entity)
    {
        this.entityManager.persist(entity);
    }

    @Transactional
    public <T> void remove(T entity)
    {
        this.entityManager.remove(entity);
    }

    @Transactional
    public <T> void merge(T entity)
    {
        this.entityManager.merge(entity);
    }

    public <T, K> T findById(Class<T> clss, K id)
    {
        return this.entityManager.find(clss, id);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public <T> List<T> findAll(Class<T> clss)
    {
        Query query = this.entityManager.createQuery("SELECT e FROM " + clss.getSimpleName() + " e");
        return query.getResultList();
    }
}