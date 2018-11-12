package com.commont.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Entity extends Serializable {
	
	public static class SimpleCriteria extends GeneralCriteria {

		public Criteria eq(String field, Object value) {
			criterions.add(new Criterion(field, Condition.EQ, value));
			return this;
		}

		public Criteria ne(String field, Object value) {
			criterions.add(new Criterion(field, Condition.NE, value));
			return this;
		}

		public Criteria ge(String field, Object value) {
			criterions.add(new Criterion(field, Condition.GE, value));
			return this;
		}

		public Criteria gt(String field, Object value) {
			criterions.add(new Criterion(field, Condition.GT, value));
			return this;
		}

		public Criteria le(String field, Object value) {
			criterions.add(new Criterion(field, Condition.LE, value));
			return this;
		}

		public Criteria lt(String field, Object value) {
			criterions.add(new Criterion(field, Condition.LT, value));
			return this;
		}

		public Criteria isNull(String field) {
			criterions.add(new Criterion(field, Condition.IS_NULL));
			return this;
		}

		public Criteria isNotNull(String field) {
			criterions.add(new Criterion(field, Condition.IS_NOT_NULL));
			return this;
		}

		public Criteria between(String field, Object v1, Object v2) {
			criterions.add(new Criterion(field, Condition.BETWEEN, v1, v2));
			return this;
		}

		public Criteria like(String field, Object value) {
			criterions.add(new Criterion(field, Condition.LIKE, value));
			return this;
		}

		public Criteria orderBy(String field, By by) {
			orderbies.add(new OrderBy(field, by));
			return this;
		}

		public Criteria orderBy(String field, String order) {
			orderbies.add(new OrderBy(field, order));
			return this;
		}

		public Criteria limit(int offset, int count) {
			limit = new Limit(offset, count);
			return this;
		}

		public <T> Criteria in(String field, @SuppressWarnings("unchecked") T... values) {
			criterions.add(new Criterion(field, Condition.IN, values));
			return this;
		}

		public <T> Criteria notIn(String field, @SuppressWarnings("unchecked") T... values) {
			criterions.add(new Criterion(field, Condition.NOT_IN, values));
			return this;
		}

		@Override
		public String toString() {
			return "limit=" + limit + ", criterions=" + criterions + ", orderbies=" + orderbies;
		}

	}
	
	public static abstract class GeneralCriteria implements Criteria {
		
		protected Limit limit;

		protected Set<OrderBy> orderbies = new LinkedHashSet<OrderBy>();

		protected Set<Criterion> criterions = new LinkedHashSet<Criterion>();

		@Override
		public boolean isOrderly() {
			return orderbies.size() > 0;
		}

		@Override
		public boolean isNotEmpty() {
			return criterions.size() > 0;
		}

		@Override
		public boolean isPagination() {
			return limit != null;
		}

		@Override
		public Limit getLimit() {
			return limit;
		}

		@Override
		public Set<OrderBy> getOrderbies() {
			return orderbies;
		}

		@Override
		public Set<Criterion> getCriterions() {
			return criterions;
		}

		@Override
		public Criteria addCriterion(Criterion criterion) {
			if (criterion instanceof Limit) {
				limit = (Limit) criterion;
			}
			else if (criterion instanceof OrderBy) {
				orderbies.add((OrderBy) criterion);
			}
			else {
				criterions.add(criterion);
			}
			return this;
		}

		@Override
		public Map<String, Object> toMapParameter() {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("criteria", this);
			return param;
		}
		
	}

	public static class Criterion {

		String field;

		Object value, value2;

		private String condition;

		private boolean noValue;

		private boolean singleValue;

		private boolean listValue;

		private boolean betweenValue;

		public String getField() {
			return field;
		}

		public Object getValue() {
			return value;
		}

		public Object getValue2() {
			return value2;
		}

		public String getCondition() {
			return condition;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		Criterion setField(String field) {
			this.field = field;
			return this;
		}

		Criterion() {

		}

		Criterion(Condition condition) {
			this((String) null, condition);
		}

		Criterion(Condition condition, Object value) {
			this((String) null, condition, value);
		}

		Criterion(Condition condition, Object value, Object value2) {
			this(null, condition, value, value2);
		}

		public Criterion(String field, Condition condition) {
			this.field = field;
			this.noValue = true;
			this.condition = condition.toSymbol();
		}

		public Criterion(String field, Condition condition, Object value) {
			this.field = field;
			this.value = value;
			this.condition = condition.toSymbol();
			if (value instanceof Collection || value.getClass().isArray()) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		public Criterion(String field, Condition condition, Object value, Object value2) {
			this.value = value;
			this.value2 = value2;
			this.betweenValue = true;
			this.condition = condition.toSymbol();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((condition == null) ? 0 : condition.hashCode());
			result = prime * result + ((field == null) ? 0 : field.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			result = prime * result + ((value2 == null) ? 0 : value2.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Criterion other = (Criterion) obj;
			if (condition == null) {
				if (other.condition != null)
					return false;
			} else if (!condition.equals(other.condition))
				return false;
			if (field == null) {
				if (other.field != null)
					return false;
			} else if (!field.equals(other.field))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			if (value2 == null) {
				if (other.value2 != null)
					return false;
			} else if (!value2.equals(other.value2))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Criterion [field=" + field + ", value=" + value + ", value2=" + value2 + ", condition=" + condition + "]";
		}

	}

	public static class Limit extends Criterion {

		public Limit(int offset, int count) {
			this.value = offset;
			this.value2 = count;
		}

		@Override
		public String toString() {
			return "Limit [" + value + ", " + value2 + "]";
		}

	}

	public static class OrderBy extends Criterion {
		
		OrderBy(By by) {
			this(null, by);
		}
		
		OrderBy(String order) {
			this(null, order);
		}

		public OrderBy(String field, By by) {
			this(field, by.name());
		}

		public OrderBy(String field, String order) {
			this.field = field;
			this.value = order;
		}

		@Override
		public String toString() {
			return "OrderBy [field=" + field + ", value=" + value + "]";
		}

	}

	public static enum Condition {

		EQ("="),

		GT(">"),

		LT("<"),

		LE("<="),

		NE("!="),

		GE(">="),

		IN("IN"),

		LIKE("LIKE"),

		NOT_IN("NOT IN"),

		BETWEEN("BETWEEN"),

		IS_NULL("IS NULL"),

		IS_NOT_NULL("IS NOT NULL"),

		;

		private final String symbol;

		private Condition(String symbol) {
			this.symbol = symbol;
		}

		public String toSymbol() {
			return symbol;
		}

	}

	public static class Value {

		public static Criterion eq(Object value) {
			return new Criterion(Condition.EQ, value);
		}

		public static Criterion ne(Object value) {
			return new Criterion(Condition.NE, value);
		}

		public static Criterion ge(Object value) {
			return new Criterion(Condition.GE, value);
		}

		public static Criterion gt(Object value) {
			return new Criterion(Condition.GT, value);
		}

		public static Criterion le(Object value) {
			return new Criterion(Condition.LE, value);
		}

		public static Criterion lt(Object value) {
			return new Criterion(Condition.LT, value);
		}

		public static Criterion isNull() {
			return new Criterion(Condition.IS_NULL);
		}

		public static Criterion isNotNull() {
			return new Criterion(Condition.IS_NOT_NULL);
		}

		public static Criterion between(Object v1, Object v2) {
			return new Criterion(Condition.BETWEEN, v1, v2);
		}

		public static Criterion like(Object value) {
			return new Criterion(Condition.LIKE, value);
		}

		public static Criterion orderBy(By by) {
			return new OrderBy(by);
		}

		public static Criterion orderBy(String order) {
			return new OrderBy(order);
		}

		public static <T> Criterion in(@SuppressWarnings("unchecked") T... values) {
			return new Criterion(Condition.IN, values);
		}

		public static <T> Criterion notIn(@SuppressWarnings("unchecked") T... values) {
			return new Criterion(Condition.NOT_IN, values);
		}

	}

	public static enum By { ASC, DESC }

	public static interface Criteria {
		
		boolean isOrderly();
		
		boolean isNotEmpty();
		
		boolean isPagination();
		
		Limit getLimit();
		
		Set<OrderBy> getOrderbies();
		
		Set<Criterion> getCriterions();

		Criteria addCriterion(Criterion criterion);
		
		Map<String, Object> toMapParameter();
		
	}

	public static class PrimaryKey {
		
		private String name;
		
		private Object value;
		
		public static PrimaryKey of(Object obj) {
			Entity entity = null;
			Class<?> entityClass = null;
			if (obj instanceof Entity) {
				entity = (Entity) obj;
				entityClass = entity.getClass();
			}
			else if (obj instanceof Class) {
				entityClass = (Class<?>) obj;
			}
			PrimaryKey primaryKey = new PrimaryKey();
			if (entity == null && entityClass == null) {
				return null;
			}
			else if (entityClass == Admin.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Admin) entity).getId();
				}
			}
			else if (entityClass == AdminRefRole.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((AdminRefRole) entity).getId();
				}
			}
			else if (entityClass == Company.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Company) entity).getId();
				}
			}
			else if (entityClass == Cover.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Cover) entity).getId();
				}
			}
			else if (entityClass == Detail.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Detail) entity).getId();
				}
			}
			else if (entityClass == GwUser.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((GwUser) entity).getId();
				}
			}
			else if (entityClass == Info.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Info) entity).getId();
				}
			}
			else if (entityClass == LoginLog.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((LoginLog) entity).getId();
				}
			}
			else if (entityClass == Menu.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Menu) entity).getId();
				}
			}
			else if (entityClass == Picture.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Picture) entity).getId();
				}
			}
			else if (entityClass == Protype.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Protype) entity).getId();
				}
			}
			else if (entityClass == Role.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((Role) entity).getId();
				}
			}
			else if (entityClass == RoleRefMenu.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((RoleRefMenu) entity).getId();
				}
			}
			else if (entityClass == User.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((User) entity).getId();
				}
			}
			else if (entityClass == UserBankCard.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((UserBankCard) entity).getId();
				}
			}
			else if (entityClass == UserWallet.class) {
				primaryKey.name = "id";
				if (entity != null) {
					primaryKey.value = ((UserWallet) entity).getId();
				}
			}
			return primaryKey;
		}
		
		public static void set(Object obj, Object value) {
			if (obj == null) {
				return ;
			}
			Class<?> entityClass = obj.getClass();
			if (value == null) {
				return ;
			}
			else if (entityClass == Admin.class) {
				((Admin) obj).setId((Integer) value);
			}
			else if (entityClass == AdminRefRole.class) {
				((AdminRefRole) obj).setId((Integer) value);
			}
			else if (entityClass == Company.class) {
				((Company) obj).setId((Integer) value);
			}
			else if (entityClass == Cover.class) {
				((Cover) obj).setId((Integer) value);
			}
			else if (entityClass == Detail.class) {
				((Detail) obj).setId((Integer) value);
			}
			else if (entityClass == GwUser.class) {
				((GwUser) obj).setId((Integer) value);
			}
			else if (entityClass == Info.class) {
				((Info) obj).setId((Integer) value);
			}
			else if (entityClass == LoginLog.class) {
				((LoginLog) obj).setId((Integer) value);
			}
			else if (entityClass == Menu.class) {
				((Menu) obj).setId((Integer) value);
			}
			else if (entityClass == Picture.class) {
				((Picture) obj).setId((Integer) value);
			}
			else if (entityClass == Protype.class) {
				((Protype) obj).setId((Integer) value);
			}
			else if (entityClass == Role.class) {
				((Role) obj).setId((Integer) value);
			}
			else if (entityClass == RoleRefMenu.class) {
				((RoleRefMenu) obj).setId((Integer) value);
			}
			else if (entityClass == User.class) {
				((User) obj).setId((Integer) value);
			}
			else if (entityClass == UserBankCard.class) {
				((UserBankCard) obj).setId((Integer) value);
			}
			else if (entityClass == UserWallet.class) {
				((UserWallet) obj).setId((Integer) value);
			}
		}

		public String getName() {
			return name;
		}

		public Object getValue() {
			return value;
		}
		
	}
	
	public static class Pagination {
		
		// 查询结果的总行数
		private long total;
		
		// 当前页的行对象列表
		private List<?> rows;
		
		// 每页显示的行数
		private int limit;
		
		// 起始索引的数值
		private int offset;
		
		// 排序字段名称
		private String sort;
		
		// 排序, ASC, DESC
		private String order;
		
		// 检索字段名
		private String field;
		
		// 检索字符串
		private String search;
		
		// 当前页
		private int page;
		
		// 上一页
		private int prev;
		
		// 下一页
		private int next;
		
		// 总页数
		private int pages;
		
		// 检索参数
		private Map<String, String> params;

		public long getTotal() {
			return total;
		}

		public void setTotal(long total) {
			this.total = total;
		}

		public List<?> getRows() {
			return rows;
		}

		public void setRows(List<?> rows) {
			this.rows = rows;
		}

		public int getLimit() {
			return limit;
		}

		public void setLimit(int limit) {
			this.limit = limit;
		}

		public int getOffset() {
			return offset;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		public String getOrder() {
			return order;
		}

		public void setOrder(String order) {
			this.order = order;
		}

		public String getSearch() {
			return search;
		}

		public void setSearch(String search) {
			this.search = search;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getPrev() {
			return prev;
		}

		public void setPrev(int prev) {
			this.prev = prev;
		}

		public int getNext() {
			return next;
		}

		public void setNext(int next) {
			this.next = next;
		}

		public int getPages() {
			return pages;
		}

		public void setPages(int pages) {
			this.pages = pages;
		}

		public Map<String, String> getParams() {
			return params;
		}

		public void setParams(Map<String, String> params) {
			this.params = params;
		}
		
		public void openHumpSwitch() {
			if (sort != null) {
				char ch;
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < sort.length(); i++) {
					ch = sort.charAt(i);
					if (Character.isUpperCase(ch)) {
						builder.append("_").append((char) (ch + 32));
					}
					else {
						builder.append(ch);
					}
				}
				sort = builder.toString();
			}
		}

		@Override
		public String toString() {
			return "Pagination [total=" + total + ", rows=" + rows + ", limit=" + limit + ", offset=" + offset
					+ ", sort=" + sort + ", order=" + order + ", field=" + field + ", search=" + search + ", page="
					+ page + ", prev=" + prev + ", next=" + next + ", pages=" + pages + ", params=" + params + "]";
		}
		
	}

	public static class AdminCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setLastLoginTime(Criterion criterion) {
			this.addCriterion(criterion.setField("last_login_time"));
		}
		
		public void setPhone(Criterion criterion) {
			this.addCriterion(criterion.setField("phone"));
		}
		
		public void setState(Criterion criterion) {
			this.addCriterion(criterion.setField("state"));
		}
		
		public void setUserName(Criterion criterion) {
			this.addCriterion(criterion.setField("user_name"));
		}
		
		public void setUserPwd(Criterion criterion) {
			this.addCriterion(criterion.setField("user_pwd"));
		}
		
	}
		
	public static class AdminRefRoleCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setAdminid(Criterion criterion) {
			this.addCriterion(criterion.setField("adminid"));
		}
		
		public void setRoleid(Criterion criterion) {
			this.addCriterion(criterion.setField("roleid"));
		}
		
	}
		
	public static class CompanyCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setContent(Criterion criterion) {
			this.addCriterion(criterion.setField("content"));
		}
		
		public void setPicture(Criterion criterion) {
			this.addCriterion(criterion.setField("picture"));
		}
		
	}
		
	public static class CoverCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setContent(Criterion criterion) {
			this.addCriterion(criterion.setField("content"));
		}
		
		public void setPid(Criterion criterion) {
			this.addCriterion(criterion.setField("pid"));
		}
		
		public void setType(Criterion criterion) {
			this.addCriterion(criterion.setField("type"));
		}
		
	}
		
	public static class DetailCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCid(Criterion criterion) {
			this.addCriterion(criterion.setField("cid"));
		}
		
		public void setContdet(Criterion criterion) {
			this.addCriterion(criterion.setField("contdet"));
		}
		
		public void setPid(Criterion criterion) {
			this.addCriterion(criterion.setField("pid"));
		}
		
	}
		
	public static class GwUserCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCity(Criterion criterion) {
			this.addCriterion(criterion.setField("city"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setIp(Criterion criterion) {
			this.addCriterion(criterion.setField("ip"));
		}
		
		public void setIsvisit(Criterion criterion) {
			this.addCriterion(criterion.setField("isvisit"));
		}
		
		public void setNeeds(Criterion criterion) {
			this.addCriterion(criterion.setField("needs"));
		}
		
		public void setPhone(Criterion criterion) {
			this.addCriterion(criterion.setField("phone"));
		}
		
		public void setPlatform(Criterion criterion) {
			this.addCriterion(criterion.setField("platform"));
		}
		
		public void setQq(Criterion criterion) {
			this.addCriterion(criterion.setField("qq"));
		}
		
		public void setSincerity(Criterion criterion) {
			this.addCriterion(criterion.setField("sincerity"));
		}
		
		public void setType(Criterion criterion) {
			this.addCriterion(criterion.setField("type"));
		}
		
		public void setUsername(Criterion criterion) {
			this.addCriterion(criterion.setField("username"));
		}
		
		public void setVisitTime(Criterion criterion) {
			this.addCriterion(criterion.setField("visit_time"));
		}
		
		public void setVisitresult(Criterion criterion) {
			this.addCriterion(criterion.setField("visitresult"));
		}
		
		public void setWeixin(Criterion criterion) {
			this.addCriterion(criterion.setField("weixin"));
		}
		
	}
		
	public static class InfoCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setAddress(Criterion criterion) {
			this.addCriterion(criterion.setField("address"));
		}
		
		public void setName(Criterion criterion) {
			this.addCriterion(criterion.setField("name"));
		}
		
		public void setPhone(Criterion criterion) {
			this.addCriterion(criterion.setField("phone"));
		}
		
		public void setQq(Criterion criterion) {
			this.addCriterion(criterion.setField("QQ"));
		}
		
		public void setSubway(Criterion criterion) {
			this.addCriterion(criterion.setField("subway"));
		}
		
		public void setTelephone(Criterion criterion) {
			this.addCriterion(criterion.setField("telephone"));
		}
		
	}
		
	public static class LoginLogCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setLoginIp(Criterion criterion) {
			this.addCriterion(criterion.setField("login_ip"));
		}
		
		public void setLoginTime(Criterion criterion) {
			this.addCriterion(criterion.setField("login_time"));
		}
		
		public void setModels(Criterion criterion) {
			this.addCriterion(criterion.setField("models"));
		}
		
		public void setSystemType(Criterion criterion) {
			this.addCriterion(criterion.setField("system_type"));
		}
		
		public void setSystemVersion(Criterion criterion) {
			this.addCriterion(criterion.setField("system_version"));
		}
		
		public void setUserId(Criterion criterion) {
			this.addCriterion(criterion.setField("user_id"));
		}
		
		public void setVersionCode(Criterion criterion) {
			this.addCriterion(criterion.setField("version_code"));
		}
		
	}
		
	public static class MenuCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCreationTime(Criterion criterion) {
			this.addCriterion(criterion.setField("creation_time"));
		}
		
		public void setIsleaf(Criterion criterion) {
			this.addCriterion(criterion.setField("isleaf"));
		}
		
		public void setName(Criterion criterion) {
			this.addCriterion(criterion.setField("name"));
		}
		
		public void setParentId(Criterion criterion) {
			this.addCriterion(criterion.setField("parent_id"));
		}
		
		public void setUrl(Criterion criterion) {
			this.addCriterion(criterion.setField("url"));
		}
		
	}
		
	public static class PictureCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setPicurl(Criterion criterion) {
			this.addCriterion(criterion.setField("picurl"));
		}
		
	}
		
	public static class ProtypeCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setName(Criterion criterion) {
			this.addCriterion(criterion.setField("name"));
		}
		
	}
		
	public static class RoleCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setDescription(Criterion criterion) {
			this.addCriterion(criterion.setField("description"));
		}
		
		public void setRoleName(Criterion criterion) {
			this.addCriterion(criterion.setField("role_name"));
		}
		
		public void setStatus(Criterion criterion) {
			this.addCriterion(criterion.setField("status"));
		}
		
	}
		
	public static class RoleRefMenuCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setMenuId(Criterion criterion) {
			this.addCriterion(criterion.setField("menu_id"));
		}
		
		public void setRoleId(Criterion criterion) {
			this.addCriterion(criterion.setField("role_id"));
		}
		
	}
		
	public static class UserCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setBirthday(Criterion criterion) {
			this.addCriterion(criterion.setField("birthday"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setImage(Criterion criterion) {
			this.addCriterion(criterion.setField("image"));
		}
		
		public void setLastLoginTime(Criterion criterion) {
			this.addCriterion(criterion.setField("last_login_time"));
		}
		
		public void setLevel(Criterion criterion) {
			this.addCriterion(criterion.setField("level"));
		}
		
		public void setNick(Criterion criterion) {
			this.addCriterion(criterion.setField("nick"));
		}
		
		public void setPassword(Criterion criterion) {
			this.addCriterion(criterion.setField("password"));
		}
		
		public void setPhone(Criterion criterion) {
			this.addCriterion(criterion.setField("phone"));
		}
		
		public void setSex(Criterion criterion) {
			this.addCriterion(criterion.setField("sex"));
		}
		
		public void setState(Criterion criterion) {
			this.addCriterion(criterion.setField("state"));
		}
		
		public void setToken(Criterion criterion) {
			this.addCriterion(criterion.setField("token"));
		}
		
		public void setUserCode(Criterion criterion) {
			this.addCriterion(criterion.setField("user_code"));
		}
		
	}
		
	public static class UserBankCardCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setBankAme(Criterion criterion) {
			this.addCriterion(criterion.setField("bank_ame"));
		}
		
		public void setCardNumber(Criterion criterion) {
			this.addCriterion(criterion.setField("card_number"));
		}
		
		public void setCity(Criterion criterion) {
			this.addCriterion(criterion.setField("city"));
		}
		
		public void setCreateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("create_time"));
		}
		
		public void setName(Criterion criterion) {
			this.addCriterion(criterion.setField("name"));
		}
		
		public void setProvince(Criterion criterion) {
			this.addCriterion(criterion.setField("province"));
		}
		
		public void setSubBranch(Criterion criterion) {
			this.addCriterion(criterion.setField("sub_branch"));
		}
		
		public void setUserId(Criterion criterion) {
			this.addCriterion(criterion.setField("user_id"));
		}
		
	}
		
	public static class UserWalletCriteria extends SimpleCriteria {
		
		public void setId(Criterion criterion) {
			this.addCriterion(criterion.setField("id"));
		}
		
		public void setCardAmount(Criterion criterion) {
			this.addCriterion(criterion.setField("card_amount"));
		}
		
		public void setCoin(Criterion criterion) {
			this.addCriterion(criterion.setField("coin"));
		}
		
		public void setCredit(Criterion criterion) {
			this.addCriterion(criterion.setField("credit"));
		}
		
		public void setPayPwd(Criterion criterion) {
			this.addCriterion(criterion.setField("pay_pwd"));
		}
		
		public void setUpdateTime(Criterion criterion) {
			this.addCriterion(criterion.setField("update_time"));
		}
		
		public void setUserId(Criterion criterion) {
			this.addCriterion(criterion.setField("user_id"));
		}
		
	}
		
}