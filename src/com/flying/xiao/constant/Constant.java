package com.flying.xiao.constant;

public class Constant
{
	public static final int MAX_PAGE_COUNT=5;
	public static class ErrorCode{
		public static final int USER_LOGIN_ERROR=0X01;
		public static final int PUB_COMMENT_ERROR=0X02;
		public static final int PARAM_ERROR=0X03;//��������
		public static final int USER_NOT_LOGIN=0X04;//�û�δ��½ ����sessionʧЧ
		public static final int PRAISE_OPERATE_ERROR=0X05;//�޳���
		public static final int GET_CONTENT_DETAIL_NO_CONTENT=0X06;
		public static final int GET_MARKET_DETAIL_NO_MARKET=0X07;
		public static final int SAVE_CONTENT_ERROR=0X08;
		public static final int UPDATE_CONTENT_ERROR=0X09;
		public static final int GET_COLLECTION_ERROR=0X0A; 
		public static final int USER_REGIEST_ERROR=0X0B;
	}
	
	public static class ContentType{
		public static final int CONTENT_TYPE_NEWS=0x01; //��Ѷ
		public static final int CONTENT_TYPE_LOST=0x02; //ʧ��
		public static final int CONTENT_TYPE_DIARY=0x03; //������
		public static final int CONTENT_TYPE_MARKET=0x04; //�г�
		public static final int CONTENT_TYPE_ASK=0x05; // �ʴ�
	}
	
	public static class WenzhangType{
//		public static final int WENZHANG_TYPE_
	}
}
