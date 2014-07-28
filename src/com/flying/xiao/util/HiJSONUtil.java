package com.flying.xiao.util;


import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.json.JSONException;

public class HiJSONUtil extends JSONUtil
{
	private static HiJSONUtil instance = null;

	static public String toJSONString(Object obj) throws JSONException
	{
		return toJSONString(obj, false);
	}

	static public String toJSONString(Object obj, boolean useClassConvert) throws JSONException
	{
		if (instance == null)
			instance = new HiJSONUtil();
		return instance.getJSONObject(obj, useClassConvert).toString();
	}

	@Override
	protected Object proxyCheck(Object bean)
	{
		System.out.println("Class is " + bean.getClass().getName());
		if (bean instanceof HibernateProxy)
		{
			LazyInitializer lazyInitializer = ((HibernateProxy) bean).getHibernateLazyInitializer();
			if (lazyInitializer.isUninitialized())
			{
				System.out.println(">>>>>lazyInitializer.getIdentifier()=" + lazyInitializer.getIdentifier());
				return lazyInitializer.getIdentifier();
			}
		}
		if (bean instanceof PersistentSet)
		{
			return new String[]
			{}; // ºöÂÔhibernate one-to-many
		}
		return bean;
	}
}
