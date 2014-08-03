package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.UserInfo;

public class UsersDaoImpl extends BaseHibernateDAO<UserInfo> implements UsersDao {

	 @Override
	 public UserInfo findById(Long id) {
	  return super.findByProperty(USER_ID,id).get(0);
	 }


	 @Override
	 public List<UserInfo> findByUserName(String userName,boolean isFuzzy) {
	  if(isFuzzy){
	   return super.fuzzyFindByProperty(USERNAME, userName);
	  }else{
	   return super.findByProperty(USERNAME,userName);
	  }
	 }


	@Override
	public UserInfo findByUserNameAndPassword(String userName, String passWord)
	{
		List<UserInfo> users= super.findByProperty(new String[]{USERNAME,PASSWORD},new String[]{userName,passWord}) ;
		if(users!=null&&users.size()>0)
			return users.get(0);
		else return null;
	}


	@Override
	public List<UserInfo> findByType(int typeid, int firstResult, int size)
	{
		return super.findByHql("from UserInfo user where user.userTypeId="+typeid, firstResult, size);
	}

	}
