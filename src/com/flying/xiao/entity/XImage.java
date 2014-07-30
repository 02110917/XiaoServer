package com.flying.xiao.entity;


public class XImage extends Base{
    private Long imageId;
    private Long contentId;
    private String imageUrl;
	public Long getImageId()
	{
		return imageId;
	}
	public void setImageId(Long imageId)
	{
		this.imageId = imageId;
	}
	public Long getContentId()
	{
		return contentId;
	}
	public void setContentId(Long contentId)
	{
		this.contentId = contentId;
	}
	public String getImageUrl()
	{
		return imageUrl;
	}
	public void setImageUrl(String imageUrl)
	{
		this.imageUrl = imageUrl;
	}
    
}
