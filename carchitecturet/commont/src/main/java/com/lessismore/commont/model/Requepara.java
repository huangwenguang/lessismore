package com.lessismore.commont.model;

public class Requepara implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/** 外键 */
	protected Integer foId;
	
	/** 请求说明 */
	protected String reqContent;
	
	/** 是否为空 1:是  0:否 */
	protected Integer reqIsnull;
	
	/** 请求字段 */
	protected String reqName;
	
	/** 请求类型 */
	protected String reqType;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getFoId() {
		return foId;
	}
	
	public void setFoId(Integer foId) {
		this.foId = foId;
	}
	
	public String getReqContent() {
		return reqContent;
	}
	
	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}
	
	public Integer getReqIsnull() {
		return reqIsnull;
	}
	
	public void setReqIsnull(Integer reqIsnull) {
		this.reqIsnull = reqIsnull;
	}
	
	public String getReqName() {
		return reqName;
	}
	
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	
	public String getReqType() {
		return reqType;
	}
	
	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("foId = ").append(foId).append(", ");
		builder.append("reqContent = ").append(reqContent).append(", ");
		builder.append("reqIsnull = ").append(reqIsnull).append(", ");
		builder.append("reqName = ").append(reqName).append(", ");
		builder.append("reqType = ").append(reqType);
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
		Requepara other = (Requepara) obj;
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