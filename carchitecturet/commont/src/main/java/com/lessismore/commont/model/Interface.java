package com.lessismore.commont.model;

public class Interface implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/** 功能描述 */
	protected String content;
	
	/** 接口名 */
	protected String interName;
	
	/** 项目名 */
	protected String proName;
	
	/** 备注 */
	protected String remark;
	
	/** 请求数据 */
	protected String requeData;
	
	/** 返回数据 */
	protected String returnData;
	
	/** 实现状态 1:已实现  0:未实现 */
	protected Integer status;
	
	/** 请求类型 */
	protected String type;
	
	/** 请求url */
	protected String url;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getInterName() {
		return interName;
	}
	
	public void setInterName(String interName) {
		this.interName = interName;
	}
	
	public String getProName() {
		return proName;
	}
	
	public void setProName(String proName) {
		this.proName = proName;
	}
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRequeData() {
		return requeData;
	}
	
	public void setRequeData(String requeData) {
		this.requeData = requeData;
	}
	
	public String getReturnData() {
		return returnData;
	}
	
	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("content = ").append(content).append(", ");
		builder.append("interName = ").append(interName).append(", ");
		builder.append("proName = ").append(proName).append(", ");
		builder.append("remark = ").append(remark).append(", ");
		builder.append("requeData = ").append(requeData).append(", ");
		builder.append("returnData = ").append(returnData).append(", ");
		builder.append("status = ").append(status).append(", ");
		builder.append("type = ").append(type).append(", ");
		builder.append("url = ").append(url);
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
		Interface other = (Interface) obj;
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