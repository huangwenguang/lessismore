package com.commont.model;

public class GwUser implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/**  */
	protected String city;	
	
	/**  */
	protected java.util.Date createTime;
	
	/**  */
	protected String ip;
	
	/**  */
	protected Integer isvisit;
	
	/**  */
	protected String needs;
	
	/**  */
	protected String phone;
	
	/**  */
	protected String platform;	//浏览器平台
	
	/**  */
	protected String qq;
	
	/**  */
	protected String sincerity;
	
	/**  */
	protected Integer type;		//访问平台
	
	/**  */
	protected String username;
	
	/**  */
	protected java.util.Date visitTime;
	
	/**  */
	protected String visitresult;
	
	/**  */
	protected String weixin;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public java.util.Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public Integer getIsvisit() {
		return isvisit;
	}
	
	public void setIsvisit(Integer isvisit) {
		this.isvisit = isvisit;
	}
	
	public String getNeeds() {
		return needs;
	}
	
	public void setNeeds(String needs) {
		this.needs = needs;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getQq() {
		return qq;
	}
	
	public void setQq(String qq) {
		this.qq = qq;
	}
	
	public String getSincerity() {
		return sincerity;
	}
	
	public void setSincerity(String sincerity) {
		this.sincerity = sincerity;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public java.util.Date getVisitTime() {
		return visitTime;
	}
	
	public void setVisitTime(java.util.Date visitTime) {
		this.visitTime = visitTime;
	}
	
	public String getVisitresult() {
		return visitresult;
	}
	
	public void setVisitresult(String visitresult) {
		this.visitresult = visitresult;
	}
	
	public String getWeixin() {
		return weixin;
	}
	
	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("city = ").append(city).append(", ");
		builder.append("createTime = ").append(createTime).append(", ");
		builder.append("ip = ").append(ip).append(", ");
		builder.append("isvisit = ").append(isvisit).append(", ");
		builder.append("needs = ").append(needs).append(", ");
		builder.append("phone = ").append(phone).append(", ");
		builder.append("platform = ").append(platform).append(", ");
		builder.append("qq = ").append(qq).append(", ");
		builder.append("sincerity = ").append(sincerity).append(", ");
		builder.append("type = ").append(type).append(", ");
		builder.append("username = ").append(username).append(", ");
		builder.append("visitTime = ").append(visitTime).append(", ");
		builder.append("visitresult = ").append(visitresult).append(", ");
		builder.append("weixin = ").append(weixin);
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
		GwUser other = (GwUser) obj;
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