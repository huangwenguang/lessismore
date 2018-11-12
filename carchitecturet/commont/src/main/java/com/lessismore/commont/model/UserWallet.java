package com.lessismore.commont.model;

public class UserWallet implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/**  */
	protected Integer cardAmount;
	
	/**  */
	protected Integer coin;
	
	/**  */
	protected Integer credit;
	
	/**  */
	protected String payPwd;
	
	/**  */
	protected java.util.Date updateTime;
	
	/**  */
	protected Integer userId;
	
 	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getCardAmount() {
		return cardAmount;
	}
	
	public void setCardAmount(Integer cardAmount) {
		this.cardAmount = cardAmount;
	}
	
	public Integer getCoin() {
		return coin;
	}
	
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	
	public Integer getCredit() {
		return credit;
	}
	
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	public String getPayPwd() {
		return payPwd;
	}
	
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
	
	public java.util.Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
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
		builder.append("cardAmount = ").append(cardAmount).append(", ");
		builder.append("coin = ").append(coin).append(", ");
		builder.append("credit = ").append(credit).append(", ");
		builder.append("payPwd = ").append(payPwd).append(", ");
		builder.append("updateTime = ").append(updateTime).append(", ");
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
		UserWallet other = (UserWallet) obj;
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