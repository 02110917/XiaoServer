package com.flying.xiao.entity;

import java.util.List;

public class XContentDetail extends Base
{
	private long id ;
	private String contentInfo ;
	private long contentId;
	private XContent content;
	private List<XComment> comments ;
	private XContentType contentType ;

	public XContentType getContentType() {
		return contentType;
	}
	public void setContentType(XContentType contentType) {
		this.contentType = contentType;
	}
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	public String getContentInfo()
	{
		return contentInfo;
	}
	
	public long getContentId() {
		return contentId;
	}
	public void setContentId(long contentId) {
		this.contentId = contentId;
	}
	public XContent getContent() {
		return content;
	}
	public void setContent(XContent content) {
		this.content = content;
	}
	public void setContentInfo(String contentInfo)
	{
		this.contentInfo = contentInfo;
	}
	public List<XComment> getComments()
	{
		return comments;
	}
	public void setComments(List<XComment> comments)
	{
		this.comments = comments;
	}
}
