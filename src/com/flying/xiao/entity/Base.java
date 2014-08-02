package com.flying.xiao.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Base implements Serializable{
	private String errorMsg;
	private int errorCode;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public <T> void copy(T t) {
		Class<?> clz = this.getClass();
		Class<?> cls = t.getClass();
		copyOperate(clz, cls,t);
	}

	public <T> void copyToHibernateBean(T t) {

		Class<?> clz = t.getClass();
		Class<?> cls = this.getClass();
		copyOperate(clz, cls,this);
	}

	private <T> void copyOperate(Class<?> clz, Class<?> cls,T t) {
		Field[] fields = clz.getDeclaredFields();
		Field[] fields_t = cls.getDeclaredFields();
		for (Field field : fields) {
			Method m;
			try {
				boolean isHaveThisField = false;
				for (Field field_t : fields_t) {
					if (field_t.getName().equals(field.getName())) {
						isHaveThisField = true;
					}
				}
				if (isHaveThisField) {
					m = (Method) cls.getMethod("get"
							+ getMethodName(field.getName()));
					Object obj = m.invoke(t);
					if (obj != null) {
						m = (Method) clz.getMethod(
								"set" + getMethodName(field.getName()),
								obj.getClass());
						m.invoke(this, obj);
					}
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
	}

	private static String getMethodName(String fildeName) throws Exception {
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	public String toJson() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}

	public Base jsonToBase(String json) throws JsonSyntaxException{
		Gson gson = new Gson();
		return gson.fromJson(json, this.getClass());
	}
}
