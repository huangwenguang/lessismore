package com.lessismore.commont.model;

public class TypePic implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/** 外键 */
	protected Integer forId;
	
	/** 图片key */
	protected String imgKey;
	
	/** 图片分类 1:我的团队  2:技术外派 */
	protected Integer imgType;
	
	/** 图片url */
	protected String imgUrl;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getForId() {
		return forId;
	}
	
	public void setForId(Integer forId) {
		this.forId = forId;
	}
	
	public String getImgKey() {
		return imgKey;
	}
	
	public void setImgKey(String imgKey) {
		this.imgKey = imgKey;
	}
	
	public Integer getImgType() {
		return imgType;
	}
	
	public void setImgType(Integer imgType) {
		this.imgType = imgType;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("forId = ").append(forId).append(", ");
		builder.append("imgKey = ").append(imgKey).append(", ");
		builder.append("imgType = ").append(imgType).append(", ");
		builder.append("imgUrl = ").append(imgUrl);
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TypePic other = (TypePic) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}