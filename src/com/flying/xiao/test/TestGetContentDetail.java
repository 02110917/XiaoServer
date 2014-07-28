package com.flying.xiao.test;

import java.util.ArrayList;
import java.util.List;

import com.flying.xiao.bean.Content;
import com.flying.xiao.bean.PingLun;
import com.flying.xiao.bean.WenZhang;
import com.flying.xiao.dao.BaseHibernateDAO;
import com.flying.xiao.dao.IBaseHibernateDAO;
import com.flying.xiao.entity.XContentDetail;

public class TestGetContentDetail
{
	
 public static void main(String args[]){
	 XContentDetail xcon=new XContentDetail();
	 IBaseHibernateDAO<WenZhang> dao=new BaseHibernateDAO<WenZhang>();
	 List<WenZhang> lists=dao.findByHql("from WenZhang wz where wz.content.id="+17, 0, 1);
	 if(lists.size()>0){
		 System.out.println(lists.get(0).getWzInfo());
	 }
	 xcon.setContentInfo(lists.get(0).getWzInfo());
	 IBaseHibernateDAO<PingLun> dao_pl=new BaseHibernateDAO<PingLun>();
	 List<PingLun> pls=dao_pl.findByHql("from PingLun pl where pl.content.id="+17, 0, 10);
	 for(PingLun pl:pls){
		 System.out.println(pl.getPlInfo());
	 }
 }
}
