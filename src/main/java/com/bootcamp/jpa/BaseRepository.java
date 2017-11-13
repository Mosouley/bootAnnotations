package com.bootcamp.jpa;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Created by SOUL
 * repository e base ? implementer par chaque entite
 * @param <T>
 */
public abstract class BaseRepository<T> {

    private  EntityManager em;
    private String persistUnit;
    private Class entityClass;
    private  EntityManagerFactory emf;




    public BaseRepository(String persistUnit, Class entityClass) {

        this.persistUnit = persistUnit;
        emf=Persistence.createEntityManagerFactory(this.persistUnit) ;
        this.em=getEntityManager();
        this.entityClass=entityClass;

    }

     public final EntityManager getEntityManager() {
        em= emf.createEntityManager();
        return em;

    }

  /**
   * methode genetique de creation dans la bdd
   * @param obj
   * @return
   * @throws SQLException
   */
    public boolean create(T obj) throws SQLException {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();

        return true;
    }

    /**
     * M?thode pour supprimer une entite dans la bdd
     *
     * @param obj
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean delete(T obj) throws SQLException {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();

        return true;
    }

    /**
     * M?thode de mise ? jour
     *
     * @param obj
     * @return boolean
     * @throws java.sql.SQLException
     */
    public boolean update(T obj) throws SQLException {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();

        return true;
    }

    /**
     * M?thode de recherche des informations
     *
     * @param propertyName
     * @param value
     * @return T
     * @throws java.sql.SQLException
     */
    public List<T> findByProperty(String propertyName, Object value) throws SQLException {
        String className = entityClass.getSimpleName();
        String query = "select t from " + className + " t where t." + propertyName + "=:param";
        Query qry = getEntityManager().createQuery(query);
        qry.setParameter("param", value);
        return qry.getResultList();

    }
    /**
     *
     * @param propertyName
     * @param value
     * @return
     * @throws SQLException
     */
      public T findByPropertyUnique(String propertyName, Object value) throws SQLException {

          String className = entityClass.getSimpleName();

        String request = "select t from " + className + " t where t." + propertyName + "=:param";
        Query query = getEm().createQuery(request);
        query.setParameter("param", value);
        return (T) query.getSingleResult();

    }

       public T findById(int id) throws SQLException {

          String className = entityClass.getSimpleName();

        String request = "select t from " + className + " t where t.id =:param";
        Query query = getEm().createQuery(request);
        query.setParameter("param", id);
        return (T) query.getSingleResult();

    }

     /*
	  * Methode de recherche de tous les objets T
     */
    public  List<T> findAll() throws SQLException{
       String className = entityClass.getSimpleName();
       String req="select t from " + className + " t";
       Query query=getEm().createQuery(req);
        return query.getResultList();
    }

    /**
     *
     * @return the entity manager
     */
    public EntityManager getEm() {
        return em;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     *
     * @param em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     *
     * @return the persistence unit
     */
    public String getPersistUnit() {
        return persistUnit;
    }

    /**
     *
     * @param persistUnit
     */
    public void setPersistUnit(String persistUnit) {
        this.persistUnit = persistUnit;
    }
	

								/*   F  R  O  M       B  I  G  N  O  N    */


     public List<T> findByCriterias(String attr, String sens,int offset, int limit){
         String className = entityClass.getSimpleName();
         String str ="";
         List<T> result = null;
         
        if( (attr != null && sens != null) && ( offset == 0 && limit == 0) ){
        str = "select obj FROM "+className+" obj ORDER BY obj."+attr+" "+sens.toUpperCase();
        Query query = getEntityManager().createQuery(str);
        result = query.getResultList();
         }
         
        if( (attr == null && sens == null) && ( offset != 0 && limit != 0) ){
        str = "select obj FROM "+className+" obj ";
        Query query = getEntityManager().createQuery(str);
        query.setFirstResult(offset).setMaxResults(limit);
        result = query.getResultList();
         }
         
        if( (attr != null && sens != null) && ( offset != 0 && limit != 0) ){
        str = "select obj FROM "+className+" obj ORDER BY obj."+attr+" "+sens.toUpperCase();
        Query query = getEntityManager().createQuery(str);
        query.setFirstResult(offset).setMaxResults(limit);
        result = query.getResultList();
         }
                       
            return result;
    }
     
	 // methode qui fait une requete de recherche sur un attribut avec une valeur donnée
     public List<T> search(Object o ,Object value){
        
            String className = entityClass.getSimpleName(); 
            String s = "SELECT obj FROM "+className+" obj WHERE obj."+o+" LIKE '%"+value+"%'";
            Query query = getEntityManager().createQuery(s);
            List<T> result = query.getResultList();
            return result;
    }

}
