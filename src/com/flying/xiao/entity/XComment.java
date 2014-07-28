package com.flying.xiao.entity;

import java.sql.Timestamp;

/**
 * 评论
 * 如果XContent不为Null则为主评论  如果为null 则为回复评论
 * @author zhangmin
 *
 */

public class XComment extends Base
{
	private Long plId;
	private long contentId;
	public Long getPlId()
	{
		return plId;
	}
	public void setPlId(Long plId)
	{
		this.plId = plId;
	}
	public long getContentId()
	{
		return contentId;
	}
	public void setContentId(long contentId)
	{
		this.contentId = contentId;
	}
	
	
	public XUserInfo getXuserInfo()
	{
		return xuserInfo;
	}
	public void setXuserInfo(XUserInfo xuserInfo)
	{
		this.xuserInfo = xuserInfo;
	}
	public String getPlInfo()
	{
		return plInfo;
	}
	public void setPlInfo(String plInfo)
	{
		this.plInfo = plInfo;
	}
	public Timestamp getPlTime()
	{
		return plTime;
	}
	public void setPlTime(Timestamp plTime)
	{
		this.plTime = plTime;
	}
	private long replyCommentId;
	public long getReplyCommentId()
	{
		return replyCommentId;
	}
	public void setReplyCommentId(long replyCommentId)
	{
		this.replyCommentId = replyCommentId;
	}
	private XUserInfo xuserInfo;
	private String plInfo;
	private Timestamp plTime;
}
