package com.flying.xiao.util;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;


public class JSONUtil{
   private static JSONUtil instance = null;
   
   public JSONUtil(){}
  
  
    protected Object proxyCheck(Object bean){
        return bean;
    }
    static public String toJSONString(Object obj) throws JSONException{
        return toJSONString(obj, false);
    }
   
    static public String toJSONString(Object obj, boolean useClassConvert) throws JSONException{
        if(instance == null)
            instance = new JSONUtil();
        return instance.getJSONObject(obj, useClassConvert).toString();
    }
    private String getJSONArray(Object arrayObj, boolean useClassConvert) throws JSONException{
       
        if(arrayObj == null)
            return "null";
       
        arrayObj = proxyCheck(arrayObj);
       
        JSONArray jSONArray = new JSONArray();
        if(arrayObj instanceof Collection){
            Iterator iterator = ((Collection)arrayObj).iterator();
            while(iterator.hasNext()){
                Object rowObj = iterator.next();
                if(rowObj == null)
                    jSONArray.put(new JSONStringObject(null));
                else if(rowObj.getClass().isArray() || rowObj instanceof Collection)
                    jSONArray.put(getJSONArray(rowObj, useClassConvert));
                else
                    jSONArray.put(getJSONObject(rowObj, useClassConvert));
            }
        }
        if(arrayObj.getClass().isArray()){
            int arrayLength = Array.getLength(arrayObj);
            for(int i = 0; i < arrayLength; i ++){
                Object rowObj = Array.get(arrayObj, i);
                if(rowObj == null)
                    jSONArray.put(new JSONStringObject(null));
                else if(rowObj.getClass().isArray() || rowObj instanceof Collection)
                    jSONArray.put(getJSONArray(rowObj, useClassConvert));
                else
                    jSONArray.put(getJSONObject(rowObj, useClassConvert));
            }
        }
        return jSONArray.toString();
    }
    JSONStringObject getJSONObject(Object value, boolean useClassConvert) throws JSONException{
        //����ԭʼ����
        if (value == null) {
            return new JSONStringObject("null");
        }
        value = proxyCheck(value);
        if (value instanceof JSONString) {
            Object o;
            try {
                o = ((JSONString)value).toJSONString();
            } catch (Exception e) {
                throw new JSONException(e);
            }
            throw new JSONException("Bad value from toJSONString: " + o);
        }
        if (value instanceof Number){
            return new JSONStringObject(JSONObject.numberToString((Number) value));
        }
        if (value instanceof Boolean || value instanceof JSONObject ||
                value instanceof JSONArray) {
            return new JSONStringObject(value.toString());
        }
        if (value instanceof String)
            return new JSONStringObject(JSONObject.quote(value.toString()));
        if (value instanceof Map) {
           
            JSONObject jSONObject = new JSONObject();
            Iterator iterator = ((Map)value).keySet().iterator();
            while(iterator.hasNext()){
                String key = iterator.next().toString();
                Object valueObj = ((Map)value).get(key);
                jSONObject.put(key, getJSONObject(valueObj, useClassConvert));
            }
            return new JSONStringObject(jSONObject.toString());
        }
        //class
        if(value instanceof Class)
            return new JSONStringObject(JSONObject.quote(((Class)value).getSimpleName()));
       
        //����
        if (value instanceof Collection || value.getClass().isArray()) {
            return new JSONStringObject(getJSONArray(proxyCheck(value), useClassConvert));
        }
        return reflectObject(value, useClassConvert);
    }//value.equals(null)
    private JSONStringObject reflectObject(Object bean, boolean useClassConvert) {
        JSONObject jSONObject = new JSONObject();
        Class klass = bean.getClass();
        Method[] methods = klass.getMethods();
        for (int i = 0; i < methods.length; i += 1) {
            try {
                Method method = methods[i];
                String name = method.getName();
                String key = "";
                if (name.startsWith("get")) {
                    key = name.substring(3);
                } else if (name.startsWith("is")) {
                    key = name.substring(2);
                }
                if (key.length() > 0 &&
                        Character.isUpperCase(key.charAt(0)) &&
                        method.getParameterTypes().length == 0) {
                    if (key.length() == 1) {
                        key = key.toLowerCase();
                    } else if (!Character.isUpperCase(key.charAt(1))) {
                        key = key.substring(0, 1).toLowerCase() +
                            key.substring(1);
                    }
                    Object elementObj = method.invoke(bean, null);
                    if(!useClassConvert && elementObj instanceof Class)
                        continue;
                    jSONObject.put(key, getJSONObject(elementObj, useClassConvert));
                }
            } catch (Exception e) {
                
            }
        }
        return new JSONStringObject(jSONObject.toString());
    }
}


