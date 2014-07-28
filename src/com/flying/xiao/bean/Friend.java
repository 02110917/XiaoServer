package com.flying.xiao.bean;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */

public class Friend implements java.io.Serializable
{

	// Fields

	private Long id;
	private UserInfo userInfoByUserId;
	private UserInfo userInfoByUserFriendBelongUserId;

	// Constructors

	/** default constructor */
	public Friend()
	{
	}

	/** minimal constructor */
	public Friend(Long id)
	{
		this.id = id;
	}

	/** full constructor */
	public Friend(Long id, UserInfo userInfoByUserId, UserInfo userInfoByUserFriendBelongUserId)
	{
		this.id = id;
		this.userInfoByUserId = userInfoByUserId;
		this.userInfoByUserFriendBelongUserId = userInfoByUserFriendBelongUserId;
	}

	// Property accessors

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public UserInfo getUserInfoByUserId()
	{
		return this.userInfoByUserId;
	}

	public void setUserInfoByUserId(UserInfo userInfoByUserId)
	{
		this.userInfoByUserId = userInfoByUserId;
	}

	public UserInfo getUserInfoByUserFriendBelongUserId()
	{
		return this.userInfoByUserFriendBelongUserId;
	}

	public void setUserInfoByUserFriendBelongUserId(UserInfo userInfoByUserFriendBelongUserId)
	{
		this.userInfoByUserFriendBelongUserId = userInfoByUserFriendBelongUserId;
	}

}