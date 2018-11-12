package com.lessismore.commont.model;

public class Cover implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/**  */
	protected String contentmax;//pc端内容
	
	/**  */
	protected String contentmin;//移动端内容
	
	/**  */
	protected Integer pid;
	
	/**  */
	protected Integer type;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getContentmax() {
		return contentmax;
	}
	
	public void setContentmax(String contentmax) {
		this.contentmax = contentmax;
	}
	
	public String getContentmin() {
		return contentmin;
	}
	
	public void setContentmin(String contentmin) {
		this.contentmin = contentmin;
	}
	
	public Integer getPid() {
		return pid;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("contentmax = ").append(contentmax).append(", ");
		builder.append("contentmin = ").append(contentmin).append(", ");
		builder.append("pid = ").append(pid).append(", ");
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
		Cover other = (Cover) obj;
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