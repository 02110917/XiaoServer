package com.flying.xiao.entity;

/**
 * ∫√”—¡–±Ì
 * @author zhangmin
 *
 */
public class XFriend extends Base{
    private Long id;
    private XUserInfo userInfoByUserId;   //me 
    private XUserInfo userInfoByUserFriendBelongUserId; // my friend 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public XUserInfo getUserInfoByUserId() {
		return userInfoByUserId;
	}
	public void setUserInfoByUserId(XUserInfo userInfoByUserId) {
		this.userInfoByUserId = userInfoByUserId;
	}
	public XUserInfo getUserInfoByUserFriendBelongUserId() {
		return userInfoByUserFriendBelongUserId;
	}
	public void setUserInfoByUserFriendBelongUserId(
			XUserInfo userInfoByUserFriendBelongUserId) {
		this.userInfoByUserFriendBelongUserId = userInfoByUserFriendBelongUserId;
	}


}
