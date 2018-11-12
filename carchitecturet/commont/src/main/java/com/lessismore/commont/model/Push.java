package com.lessismore.commont.model;

public class Push implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/** 推送时间 */
	protected java.util.Date createDate;
	
	/** 接口名 */
	protected String interName;
	
	/** 项目名 */
	protected String proName;
	
	/** 接收人 */
	protected String receiver;
	
	/** 发送人 */
	protected String sender;
	
	/** 是否紧急 1:是  0:否 */
	protected String status;
	
	/** 推送方式:手机或者短信 */
	protected String type;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public java.util.Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
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
	
	public String getReceiver() {
		return receiver;
	}
	
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("createDate = ").append(createDate).append(", ");
		builder.append("interName = ").append(interName).append(", ");
		builder.append("proName = ").append(proName).append(", ");
		builder.append("receiver = ").append(receiver).append(", ");
		builder.append("sender = ").append(sender).append(", ");
		builder.append("status = ").append(status).append(", ");
		builder.append("type = ").append(type);
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
		Push other = (Push) obj;
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