package com.flying.xiao.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.google.gson.Gson;

public class Base
{
	private String errorMsg;
	private int errorCode;

	public String getErrorMsg()
	{
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg)
	{
		this.errorMsg = errorMsg;
	}

	public int getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(int errorCode)
	{
		this.errorCode = errorCode;
	}

	public <T> void copy(T t)
	{
		Class<?> clz = this.getClass();
		Class<?> cls = t.getClass();
		Field[] fields = clz.getDeclaredFields();
		Field[] fields_t = cls.getDeclaredFields();
		for (Field field : fields)
		{
			Method m;
			try
			{
				boolean isHaveThisField = false;
				for (Field field_t : fields_t)
				{
					if (field_t.getName().equals(field.getName()))
					{
						isHaveThisField = true;
					}
				}
				if (isHaveThisField)
				{
					m = (Method) cls.getMethod("get" + getMethodName(field.getName()));
					Object obj = m.invoke(t);
					if (obj != null)
					{
						m = (Method) clz.getMethod("set" + getMethodName(field.getName()), obj.getClass());
						m.invoke(this, obj);
					}
				}
			} catch (NoSuchMethodException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static String getMethodName(String fildeName) throws Exception
	{
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	public String toJson()
	{
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}

	public Base jsonToBase(String json)
	{
		Gson gson = new Gson();
		return gson.fromJson(json, this.getClass());
	}
}
