package com.lessismore.commont.model;

public class User implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/**  */
	protected java.util.Date birthday;
	
	/**  */
	protected java.util.Date createTime;
	
	/**  */
	protected String image;
	
	/**  */
	protected java.util.Date lastLoginTime;
	
	/**  */
	protected Integer level;
	
	/**  */
	protected String nick;
	
	/**  */
	protected String password;
	
	/**  */
	protected String phone;
	
	/**  */
	protected Integer sex;
	
	/**  */
	protected Integer state;
	
	/**  */
	protected String token;
	
	/**  */
	protected Integer userCode;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public java.util.Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	
	public java.util.Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public java.util.Date getLastLoginTime() {
		return lastLoginTime;
	}
	
	public void setLastLoginTime(java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Integer getSex() {
		return sex;
	}
	
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public Integer getUserCode() {
		return userCode;
	}
	
	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("birthday = ").append(birthday).append(", ");
		builder.append("createTime = ").append(createTime).append(", ");
		builder.append("image = ").append(image).append(", ");
		builder.append("lastLoginTime = ").append(lastLoginTime).append(", ");
		builder.append("level = ").append(level).append(", ");
		builder.append("nick = ").append(nick).append(", ");
		builder.append("password = ").append(password).append(", ");
		builder.append("phone = ").append(phone).append(", ");
		builder.append("sex = ").append(sex).append(", ");
		builder.append("state = ").append(state).append(", ");
		builder.append("token = ").append(token).append(", ");
		builder.append("userCode = ").append(userCode);
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
		User other = (User) obj;
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