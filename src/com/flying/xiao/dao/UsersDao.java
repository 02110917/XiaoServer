package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.UserInfo;

public interface UsersDao extends IBaseHibernateDAO<UserInfo>{
	 public static String USER_ID="id";
	 public static String USERNAME="userName";
	 public static String PASSWORD="userPsd";
	 List<UserInfo> findByUserName(String userName,boolean isFuzzy);
	 UserInfo findByUserNameAndPassword(String userName,String passWord) ;
	}
