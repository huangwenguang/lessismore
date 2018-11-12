package com.commont.model;

public class UserBankCard implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/**  */
	protected String bankAme;
	
	/**  */
	protected String cardNumber;
	
	/**  */
	protected String city;
	
	/**  */
	protected java.util.Date createTime;
	
	/**  */
	protected String name;
	
	/**  */
	protected String province;
	
	/**  */
	protected String subBranch;
	
	/**  */
	protected Integer userId;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getBankAme() {
		return bankAme;
	}
	
	public void setBankAme(String bankAme) {
		this.bankAme = bankAme;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProvince() {
		return province;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public String getSubBranch() {
		return subBranch;
	}
	
	public void setSubBranch(String subBranch) {
		this.subBranch = subBranch;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
 	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("id = ").append(id).append(", ");
		builder.append("bankAme = ").append(bankAme).append(", ");
		builder.append("cardNumber = ").append(cardNumber).append(", ");
		builder.append("city = ").append(city).append(", ");
		builder.append("createTime = ").append(createTime).append(", ");
		builder.append("name = ").append(name).append(", ");
		builder.append("province = ").append(province).append(", ");
		builder.append("subBranch = ").append(subBranch).append(", ");
		builder.append("userId = ").append(userId);
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
		UserBankCard other = (UserBankCard) obj;
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