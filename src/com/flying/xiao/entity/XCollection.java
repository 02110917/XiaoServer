package com.flying.xiao.entity;

/**
 *  ’≤ÿ
 * @author zhangmin
 *
 */
public class XCollection extends Base {
	private Long id;
	private XContent content;
	private XUserInfo userInfo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public XContent getContent() {
		return content;
	}
	public void setContent(XContent content) {
		this.content = content;
	}
	public XUserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(XUserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
