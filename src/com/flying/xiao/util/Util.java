package com.flying.xiao.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.flying.xiao.bean.Content;
import com.flying.xiao.entity.Base;
import com.flying.xiao.entity.XContent;

public class Util
{
	/**
	 * 
	 * 功能描述： 解决hibernate 延迟加载对象问题
	 * 
	 * @param dataList
	 *            数据集
	 * @param clazz
	 *            结果集内对象的class
	 * @return: void
	 * @author: lb
	 * @version: 2.0
	 */
	public static List listCrawl(List dataList, Class clazz)
	{
		String ss = "java.lang.String,java.util.Date,java.lang.Integer,java.lang.Long,java.lang.Boolean,java.sql.Timestamp,int,float,long";
		String filterType = "java.util.Map,java.util.HashMap,java.util.Set,java.util.HashSet";
		try
		{
			for (int i = 0; i < dataList.size(); i++)
			{
				Object originalObj = dataList.get(i);// 原始数据对象
				Method[] originalMethods = clazz.getDeclaredMethods();// 原始数据对象的方法
				for (Method originalMethod : originalMethods)
				{
					System.out.println("original MethodName:  " + originalMethod.getName());
					if (originalMethod.getName().contains("get"))
					{
						System.out.println("getMethod returnType: "
								+ originalMethod.getReturnType().getName());
						String returnType = originalMethod.getReturnType().getName();// get方法返回的对象类型
						if (!ss.contains(returnType) && !filterType.contains(returnType))
						{// 不是基本类型和Set Map等集合，即是二级对象
							Object proxyObjct = originalMethod.invoke(originalObj, null);// 二级hibernate代理对象
							if (proxyObjct != null)
							{// 二级代理对象是否为空
								Class proxyClass = proxyObjct.getClass();
								Method[] proxyMethods = proxyClass.getDeclaredMethods();

								Class tempClazz = Class.forName(returnType);// 创建一个hibernate代理的原始二级对象
								Object tempObject = tempClazz.newInstance();// 创建一个hibernate代理的原始二级对象

								for (Method proxyMethod : proxyMethods)
								{//
									if (ss.contains(proxyMethod.getReturnType().getName()))
									{// 只抓取hibernate代理的二级对象的基础数据
										if (proxyMethod.getName().contains("get"))
										{
											Object returnValue = proxyMethod.invoke(proxyObjct, null);//
											System.out.println("proxy  returnValue:" + returnValue);
											String setMethod = proxyMethod.getName().replace("get", "set");
											System.out.println("setMethod name:" + setMethod);
											Method tempMethod = tempClazz.getDeclaredMethod(setMethod,
													proxyMethod.getReturnType());
											tempMethod.invoke(tempObject, returnValue);
										}
									}
								}
								Method originalMethod1 = clazz.getDeclaredMethod(originalMethod.getName()
										.replace("get", "set"), originalMethod.getReturnType());
								originalMethod1.invoke(originalObj, tempObject);// 为原始对象重新装入一个非hibernate代理对象

							}

						}
					}
				}
			}
		} catch (Exception e)
		{
			System.out.println("处理加载对象出现问题");
			e.printStackTrace();
		}

		return dataList;
	}
	
	public static <T> List<Base> toBaseList(List<T> list){
		if(list==null||list.size()==0)
			return null;
		else 
		{
			List<Base> baseList=new ArrayList<Base>();
			for(T t:list){
				Base base=new Base();
				base.copy(t);
				baseList.add(base);
			}
			return baseList ;
		}
	}
	
	
}
