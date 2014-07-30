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
	 * ���������� ���hibernate �ӳټ��ض�������
	 * 
	 * @param dataList
	 *            ���ݼ�
	 * @param clazz
	 *            ������ڶ����class
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
				Object originalObj = dataList.get(i);// ԭʼ���ݶ���
				Method[] originalMethods = clazz.getDeclaredMethods();// ԭʼ���ݶ���ķ���
				for (Method originalMethod : originalMethods)
				{
					System.out.println("original MethodName:  " + originalMethod.getName());
					if (originalMethod.getName().contains("get"))
					{
						System.out.println("getMethod returnType: "
								+ originalMethod.getReturnType().getName());
						String returnType = originalMethod.getReturnType().getName();// get�������صĶ�������
						if (!ss.contains(returnType) && !filterType.contains(returnType))
						{// ���ǻ������ͺ�Set Map�ȼ��ϣ����Ƕ�������
							Object proxyObjct = originalMethod.invoke(originalObj, null);// ����hibernate�������
							if (proxyObjct != null)
							{// ������������Ƿ�Ϊ��
								Class proxyClass = proxyObjct.getClass();
								Method[] proxyMethods = proxyClass.getDeclaredMethods();

								Class tempClazz = Class.forName(returnType);// ����һ��hibernate�����ԭʼ��������
								Object tempObject = tempClazz.newInstance();// ����һ��hibernate�����ԭʼ��������

								for (Method proxyMethod : proxyMethods)
								{//
									if (ss.contains(proxyMethod.getReturnType().getName()))
									{// ֻץȡhibernate����Ķ�������Ļ�������
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
								originalMethod1.invoke(originalObj, tempObject);// Ϊԭʼ��������װ��һ����hibernate�������

							}

						}
					}
				}
			}
		} catch (Exception e)
		{
			System.out.println("������ض����������");
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
