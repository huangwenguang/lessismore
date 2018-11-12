package com.lessismore.commont.model;

public class Share implements Entity {
	
	private static final long serialVersionUID = 1L;
	
	/**  */
	protected Integer id;
	
	/** 描述 */
	protected String content;
	
	/** 创建时间 */
	protected java.util.Date createDate;
	
	/** 图片主键 */
	protected Integer pid;
	
	/** 平台 1:ios 2:android 3:PC 4:H5 */
	protected Integer platform;
	
	/** 状态 1:启动 0:关闭 */
	protected Integer state;
	
	/** 标题 */
	protected String title;
	
	/** 类型 1:朋友圈 2:微信朋友 3:微博 4:QQ空间 5:QQ */
	protected Integer type;
	
	/** 修改时间 */
	protected java.util.Date updateDate;
	
	/** url */
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
	
	public java.util.Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
	public Integer getPid() {
		return pid;
	}
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public Integer getPlatform() {
		return platform;
	}
	
	public void setPlatform(Integer platform) {
		this.platform = platform;
	}
	
	public Integer getState() {
		return state;
	}
	
	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public java.util.Date getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
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
		builder.append("createDate = ").append(createDate).append(", ");
		builder.append("pid = ").append(pid).append(", ");
		builder.append("platform = ").append(platform).append(", ");
		builder.append("state = ").append(state).append(", ");
		builder.append("title = ").append(title).append(", ");
		builder.append("type = ").append(type).append(", ");
		builder.append("updateDate = ").append(updateDate).append(", ");
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
		Share other = (Share) obj;
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