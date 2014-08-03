package com.flying.xiao.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;


public class BaseHibernateDAO<T> implements IBaseHibernateDAO<T>{
 
 public Session getSession() {
  return HibernateSessionFactory.getSession();
 }
 public Transaction getTransaction(){
  return getSession().getTransaction();
 }
 
 private static final Log log = LogFactory.getLog(BaseHibernateDAO.class);

 protected void initDao() {
  
 }
 

 public boolean save(T domain) {
  log.debug("saving domain instance");
  try {
   getTransaction().begin();
   getSession().save(domain);
   getTransaction().commit();
   log.debug("save successful");
   return true;
  } catch (RuntimeException re) {
   re.printStackTrace();
   log.error("save failed", re);
   getTransaction().rollback();
   return false;
  }finally{
   getSession().close();
  }
 }
 

 public void saveOrUpdate(T domain) {
  log.debug("saving domain instance");
  try {
   getTransaction().begin();
   getSession().saveOrUpdate(domain);
   getTransaction().commit();
   log.debug("save successful");
  } catch (RuntimeException re) {
   log.error("save failed", re);
   getTransaction().rollback();
   throw re;
  }finally{
   getSession().close();
  }
 }

 public boolean delete(T domain) {
  log.debug("deleting domain instance");
  try {
   getTransaction().begin();
   getSession().delete(domain);
   getTransaction().commit();
   log.debug("delete successful");
   return true;
  } catch (Exception re) {
   re.printStackTrace();
   log.error("delete failed", re);
   getTransaction().rollback();
   return false;
  }finally{
   getSession().close();
  }
 }

 @SuppressWarnings("unchecked")

 public T findById(Long id) {
  log.debug("getting domain instance with id: " + id);
  try {
   T instance = (T) getSession().get(
      typeClass().getName(), id);
   return instance;
  } catch (RuntimeException re) {
   log.error("get failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }

 @SuppressWarnings("unchecked")

 public List<T> findByExample(T domain) {
  log.debug("finding domain instance by example");
  try {
   List results = getSession().createCriteria(
     typeClass().getClass().toString()).add(
   Example.create(domain)).list();
   return results;
  } catch (RuntimeException re) {
   log.error("find by example failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }

 @SuppressWarnings("unchecked")
 public List<T> findByProperty(String propertyName, Object value) {
  log.debug("finding domain instance with property: " + propertyName
    + ", value: " + value);
  try {
   String queryString = "from "+getTableName()+" as model where model."
     + propertyName + "= ?";
   Query queryObject = getSession().createQuery(queryString);
   queryObject.setParameter(0, value);
   return queryObject.list();
  } catch (RuntimeException re) {
   log.error("find by property name failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }
 
 @SuppressWarnings("unchecked")
 public List<T> findByProperty(String[] propertyNames, Object[] values) {
  try {
   String queryString = "from "+getTableName()+" as model where";
   for(String propertyName:propertyNames){
    queryString+=" model."+propertyName+"=? and";
   }
   queryString=StringUtils.removeEnd(queryString, "and");
   Query queryObject = getSession().createQuery(queryString);
   for (int i = 0; i < values.length; i++) {
    queryObject.setParameter(i, values[i]);
   } 
   return queryObject.list();
  } catch (RuntimeException re) {
   log.error("find by property name failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }
 
 
 @SuppressWarnings("unchecked")
 public List<T> fuzzyFindByProperty(String propertyName,Object value) {
  log.debug("finding domain instance with property: " + propertyName
    + ", value: " + value);
  try {
   String queryString = " from "+getTableName()+" as model where LOWER(model."
     + propertyName + ") like ?";
   Query queryObject = getSession().createQuery(queryString);
   queryObject.setString(0, "%"+String.valueOf(value).toLowerCase()+"%");
   return queryObject.list();
  } catch (RuntimeException re) {
   log.error("find by property name failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }
 @SuppressWarnings("unchecked")
 public List<T> findByProperty(String propertyName,Object value,int firstResult,int size) {
  log.debug("finding domain instance with property: " + propertyName
    + ", value: " + value);
  try {
   String queryString = "from "+getTableName()+" as model where model."
     + propertyName + "= ?";
   Query queryObject = getSession().createQuery(queryString);
   queryObject.setFirstResult(firstResult);
   queryObject.setMaxResults(size);
   queryObject.setParameter(0, value);
   return queryObject.list();
  } catch (RuntimeException re) {
   log.error("find by property name failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }
 

 
 @SuppressWarnings("unchecked")
 public List<T> findAll() {
  log.debug("finding all doamin instances");
  try {
   String queryString = "from "+getTableName();
   Query queryObject = getSession().createQuery(queryString);
   return queryObject.list();
  } catch (RuntimeException re) {
   log.error("find all failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }
 
 @SuppressWarnings("unchecked")
 public List<T> findAll(int firstResult,int size) {
  log.debug("finding all doamin instances");
  try {
   String queryString = "from "+getTableName();
   Query queryObject = getSession().createQuery(queryString);
   queryObject.setFirstResult(firstResult);
   queryObject.setMaxResults(size);
   return queryObject.list();
  } catch (RuntimeException re) {
   log.error("find all failed", re);
   throw re;
  }finally{
   getSession().close();
  }
 }
 


 public boolean  update(T instance) {
  log.debug("attaching dirty Users instance");
  try {
   getTransaction().begin();
   getSession().merge(instance);
   getTransaction().commit();
   log.debug("attach successful");
   return true;
  } catch (RuntimeException re) {
   re.printStackTrace();
   getTransaction().rollback();
   log.error("attach failed", re);
   return false;   
  }finally{
   getSession().close();
  }
 }
 
 
 
 //取得泛型类型
 @SuppressWarnings("unchecked")
 protected Class<T> typeClass() {
  return (Class<T>) ((ParameterizedType) getClass()
    .getGenericSuperclass()).getActualTypeArguments()[0];
 }
 //取得泛型tableName
 private String getTableName() {
  return typeClass().getSimpleName();
 }
@Override
public List<T> findByPropertyAndDesc(String propertyName, Object value, int firstResult, int size, String desc)
{
	log.debug("finding domain instance with property: " + propertyName
		    + ", value: " + value);
		  try {
		   String queryString = "from "+getTableName()+" as model where model."
		     + propertyName + "= ? order by "+ desc+" desc";
		   Query queryObject = getSession().createQuery(queryString);
		   queryObject.setFirstResult(firstResult);
		   queryObject.setMaxResults(size);
		   queryObject.setParameter(0, value);
		   return queryObject.list();
		  } catch (RuntimeException re) {
		   log.error("find by property name failed", re);
		   throw re;
		  }finally{
		   getSession().close();
		  }
}
@Override
public List<T> findAllDesc(int firstResult, int size, String desc)
{
	  log.debug("finding all doamin instances");
	  try {
	   String queryString = "from "+getTableName()+" order by "+desc+" desc";
	   Query queryObject = getSession().createQuery(queryString);
	   queryObject.setFirstResult(firstResult);
	   queryObject.setMaxResults(size);
	   return queryObject.list();
	  } catch (RuntimeException re) {
	   log.error("find all failed", re);
	   throw re;
	  }finally{
	   getSession().close();
	  }
}
@Override
public List<T> findByHql(String hql, int firstResult, int size)
{
	  log.debug("finding all doamin instances");
	  try {
	   Query queryObject = getSession().createQuery(hql);
	   queryObject.setFirstResult(firstResult);
	   queryObject.setMaxResults(size);
	   return queryObject.list();
	  } catch (RuntimeException re) {
	   log.error("find all failed", re);
	   throw re;
	  }finally{
	   getSession().close();
	  }
}
@Override
public List<T> findByHql(String hql)
{
	 log.debug("finding all doamin instances");
	  try {
	   Query queryObject = getSession().createQuery(hql);
	   return queryObject.list();
	  } catch (RuntimeException re) {
	   log.error("find all failed", re);
	   throw re;
	  }finally{
	   getSession().close();
	  }
}
@Override
public T findOneByHql(String hql)
{
	 log.debug("finding all doamin instances");
	  try {
	   Query queryObject = getSession().createQuery(hql);
	   List<T> list= queryObject.list();
	   if(list!=null&&list.size()>0){
		   return list.get(0);
	   }
		   
	  } catch (RuntimeException re) {
	   log.error("find all failed", re);
	   throw re;
	  }finally{
	   getSession().close();
	  }
	  return null;
}
}
