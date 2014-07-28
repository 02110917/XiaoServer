package com.flying.xiao.dao;

import java.util.List;

import com.flying.xiao.bean.Content;

public interface ContentDAO
{
	public static String USER_ID="id";
	List<Content> findAll(int firstResult,int size) ;
	public List<Content> findByHot(int firstResult,int size);
	public List<Content> findByNew(int firstResult,int size);
	public Content findById(long id);
	/**
	 * ������������ID ��ȡ�����б� 
	 * @param conTypeId 1:��Ѷ 2:ʧ�� 3:diary 4:�����г� 5:�ʴ�
	 * @param firstResult ��ʼ��ѯ��λ��
	 * @param size  ��ѯ������
	 * @return
	 */
	public List<Content> findByTypeId(int conTypeId,int firstResult,int size);
	
	public List<Content> findByWzTypeId(int wzTypeId,int firstResult,int size);
	
	public boolean  update(Content content);
}
