package com.lessismore.commont.model;

public class Returnpara implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/** 外键 */
	protected Integer forId;
	
	/** 返回描述 */
	protected String retuContent;
	
	/** 是否空 */
	protected Integer retuIs;
	
	/** 返回字段 */
	protected String retuName;
	
	/** 类型 */
	protected String retuType;
	
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
	
	public String getRetuContent() {
		return retuContent;
	}
	
	public void setRetuContent(String retuContent) {
		this.retuContent = retuContent;
	}
	
	public Integer getRetuIs() {
		return retuIs;
	}
	
	public void setRetuIs(Integer retuIs) {
		this.retuIs = retuIs;
	}
	
	public String getRetuName() {
		return retuName;
	}
	
	public void setRetuName(String retuName) {
		this.retuName = retuName;
	}
	
	public String getRetuType() {
		return retuType;
	}
	
	public void setRetuType(String retuType) {
		this.retuType = retuType;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("forId = ").append(forId).append(", ");
		builder.append("retuContent = ").append(retuContent).append(", ");
		builder.append("retuIs = ").append(retuIs).append(", ");
		builder.append("retuName = ").append(retuName).append(", ");
		builder.append("retuType = ").append(retuType);
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
		Returnpara other = (Returnpara) obj;
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