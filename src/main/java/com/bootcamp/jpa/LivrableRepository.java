package com.bootcamp.jpa;

import com.bootcamp.entities.Livrable;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LivrableRepository {

    private EntityManager em;
    private String persistUnit;
    private EntityManagerFactory emf;

    public LivrableRepository(String persistUnit) {

        this.persistUnit = persistUnit;
        emf = Persistence.createEntityManagerFactory(persistUnit);
        this.em = getEntityManager();

    }

    public final EntityManager getEntityManager() {
        em = emf.createEntityManager();
        return em;

    }

    /**
     * methode create
     */
    public boolean create(Livrable obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();

        return true;
    }

    /**
     * methode delete
     */
    public boolean delete(Livrable obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();

        return true;
    }

    /**
     * methode update
     */
    public boolean update(Livrable obj) throws SQLException {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();

        return true;
    }

    //a revoir
    public Livrable updateById(int id, Object value) throws SQLException {

        String request = "select t from Livrable t where t." + id + "=:param";
        Query query = em.createQuery(request);
        query.setParameter("param", value);
        return (Livrable) query.getSingleResult();

    }

    /**
     * methode findByProperty
     */
    public List<Livrable> findByProperty(String propertyName, Object value) throws SQLException {
        String query = "select t from  Livrable t where t." + propertyName + "=:param";
        Query qry = getEntityManager().createQuery(query);
        qry.setParameter("param", value);
        return qry.getResultList();

    }

    /**
     * methode findByPropertyUnique
     */
    public Livrable findByPropertyUnique(String propertyName, Object value) throws SQLException {
        String request = "select t from Livrable t where t." + propertyName + "=:param";
        Query query = getEm().createQuery(request);
        query.setParameter("param", value);
        return (Livrable) query.getSingleResult();

    }

    /*
     * methode de recherche de tous les objets Livrable
     */
    public List<Livrable> findAll() throws SQLException {
        String req = "select t from Livrable t";
        Query query = getEm().createQuery(req);
        return query.getResultList();
    }

    /**
     *
     * @return the entity manager
     */
    public EntityManager getEm() {
        return em;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getPersistUnit() {
        return persistUnit;
    }

    public void setPersistUnit(String persistUnit) {
        this.persistUnit = persistUnit;
    }

}
