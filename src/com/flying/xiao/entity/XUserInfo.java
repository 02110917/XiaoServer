package com.flying.xiao.entity;


public class XUserInfo extends Base
{
	private Long id;
	private String userName;
	private String userPsd;
	private String userGerenshuoming;
	private String userRealName;
	private Boolean userSex;
	private String userHeadImageUrl;
	private String userQq;
	private String userEmail;
	private Integer userTypeId;
	private Integer userJifen;
	private Integer userFuns;
	private Boolean userIsQiandao;
	private String userPhone;
	private boolean isMeFriend ;
	
	public boolean isMeFriend()
	{
		return isMeFriend;
	}
	public void setMeFriend(boolean isMeFriend)
	{
		this.isMeFriend = isMeFriend;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserPsd()
	{
		return userPsd;
	}
	public void setUserPsd(String userPsd)
	{
		this.userPsd = userPsd;
	}
	public String getUserGerenshuoming()
	{
		return userGerenshuoming;
	}
	public void setUserGerenshuoming(String userGerenshuoming)
	{
		this.userGerenshuoming = userGerenshuoming;
	}
	public String getUserRealName()
	{
		return userRealName;
	}
	public void setUserRealName(String userRealName)
	{
		this.userRealName = userRealName;
	}
	public Boolean getUserSex()
	{
		return userSex;
	}
	public void setUserSex(Boolean userSex)
	{
		this.userSex = userSex;
	}
	public String getUserHeadImageUrl()
	{
		return userHeadImageUrl;
	}
	public void setUserHeadImageUrl(String userHeadImageUrl)
	{
		this.userHeadImageUrl = userHeadImageUrl;
	}
	public String getUserQq()
	{
		return userQq;
	}
	public void setUserQq(String userQq)
	{
		this.userQq = userQq;
	}
	public String getUserEmail()
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public Integer getUserTypeId()
	{
		return userTypeId;
	}
	public void setUserTypeId(Integer userTypeId)
	{
		this.userTypeId = userTypeId;
	}
	public Integer getUserJifen()
	{
		return userJifen;
	}
	public void setUserJifen(Integer userJifen)
	{
		this.userJifen = userJifen;
	}
	public Integer getUserFuns()
	{
		return userFuns;
	}
	public void setUserFuns(Integer userFuns)
	{
		this.userFuns = userFuns;
	}
	public Boolean getUserIsQiandao()
	{
		return userIsQiandao;
	}
	public void setUserIsQiandao(Boolean userIsQiandao)
	{
		this.userIsQiandao = userIsQiandao;
	}
	public String getUserPhone()
	{
		return userPhone;
	}
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}
}
