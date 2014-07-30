package com.flying.xiao.constant;

public class Constant
{
	public static class ErrorCode{
		public static final int USER_LOGIN_ERROR=0X01;
		public static final int PUB_COMMENT_ERROR=0X02;
		public static final int PARAM_ERROR=0X03;//参数错误
		public static final int USER_NOT_LOGIN=0X04;//用户未登陆 或则session失效
		public static final int PRAISE_OPERATE_ERROR=0X05;//赞出错
		public static final int GET_CONTENT_DETAIL_NO_CONTENT=0X06;
		public static final int GET_MARKET_DETAIL_NO_MARKET=0X07;
	}
	
	public static class ContentType{
		public static final int CONTENT_TYPE_NEWS=0x01; //资讯
		public static final int CONTENT_TYPE_LOST=0x02; //失物
		public static final int CONTENT_TYPE_DIARY=0x03; //新鲜事
		public static final int CONTENT_TYPE_MARKET=0x04; //市场
		public static final int CONTENT_TYPE_ASK=0x05; // 问答
	}
	
	public static class WenzhangType{
//		public static final int WENZHANG_TYPE_
	}
}
