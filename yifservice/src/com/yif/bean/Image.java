package com.yif.bean;

public class Image {
  
    private Integer id;

   
    private String imageUrl;

  
    private Integer imageType;

   
    private Integer fImageKey;
    
    private Integer ftype;

   
    public Integer getId() {
        return id;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getImageUrl() {
        return imageUrl;
    }

   
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

   
    public Integer getImageType() {
        return imageType;
    }

    
    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

   
    public Integer getfImageKey() {
        return fImageKey;
    }

   
    public void setfImageKey(Integer fImageKey) {
        this.fImageKey = fImageKey;
    }


	public Integer getFtype() {
		return ftype;
	}


	public void setFtype(Integer ftype) {
		this.ftype = ftype;
	}
    
    
}