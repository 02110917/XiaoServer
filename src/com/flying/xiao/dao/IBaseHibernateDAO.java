package com.flying.xiao.dao;

import java.util.List;


/**
 * Data access interface for domain model
 * @author MyEclipse Persistence Tools
 */
public interface IBaseHibernateDAO<T> {

 public  boolean save(T domain);
 
 public void saveOrUpdate(T domain);

 public  boolean delete(T domain);

 public  T findById(Long id);

 public  List<T> findByExample(T domain);

 public  List<T> findByProperty(String propertyName,Object value);
 
 public List<T> findByProperty(String propertyName,Object value,int firstResult,int size);
 public List<T> findByPropertyAndDesc(String propertyName,Object value,int firstResult,int size,String desc);
 
 public List<T> findByProperty(String[] propertyNames, Object[] values);

 public  List<T> findAll();
 
 public List<T> findAll(int firstResult,int size) ;
 public List<T> findAllDesc(int firstResult,int size,String desc) ;

 public List<T> findByHql(String hql,int firstResult,int size);
 public List<T> findByHql(String hql);
 public  boolean update(T domain);

}
