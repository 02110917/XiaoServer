package com.flying.xiao.test;

import java.sql.Timestamp;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.PingLun;
import com.flying.xiao.bean.UserInfo;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.ContentDaoImpl;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.dao.UsersDaoImpl;


public class TestSaveComment
{
	public static void main(String[] args)
	{
		BaseHibernateDAO<PingLun> dao=new BaseHibernateDAO();
		PingLun pl=new PingLun();
		pl.setPlInfo("Œ“¿¥∆¿¬€ƒ„¿≤");
		Content con=new ContentDaoImpl().findById(17l);
		pl.setContent(con);
		UserInfo user=new UsersDaoImpl().findById(4l);
		pl.setUserInfo(user);
		pl.setPlTime(new Timestamp(System.currentTimeMillis()));
		dao.save(pl);
	}
}
