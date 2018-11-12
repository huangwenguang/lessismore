package com.commont.model;

public class LoginLog implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/**  */
	protected String loginIp;
	
	/**  */
	protected java.util.Date loginTime;
	
	/**  */
	protected String models;
	
	/**  */
	protected String systemType;
	
	/**  */
	protected String systemVersion;
	
	/**  */
	protected Integer userId;
	
	/**  */
	protected String versionCode;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLoginIp() {
		return loginIp;
	}
	
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
	public java.util.Date getLoginTime() {
		return loginTime;
	}
	
	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public String getModels() {
		return models;
	}
	
	public void setModels(String models) {
		this.models = models;
	}
	
	public String getSystemType() {
		return systemType;
	}
	
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	
	public String getSystemVersion() {
		return systemVersion;
	}
	
	public void setSystemVersion(String systemVersion) {
		this.systemVersion = systemVersion;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getVersionCode() {
		return versionCode;
	}
	
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("loginIp = ").append(loginIp).append(", ");
		builder.append("loginTime = ").append(loginTime).append(", ");
		builder.append("models = ").append(models).append(", ");
		builder.append("systemType = ").append(systemType).append(", ");
		builder.append("systemVersion = ").append(systemVersion).append(", ");
		builder.append("userId = ").append(userId).append(", ");
		builder.append("versionCode = ").append(versionCode);
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
		LoginLog other = (LoginLog) obj;
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