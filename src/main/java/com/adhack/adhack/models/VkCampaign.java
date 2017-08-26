package com.adhack.adhack.models;

public class VkCampaign {

	private String id;
	private String type;
	private String name;
	private String status;
	private String day_limit;
	private String all_limit;
	private String start_time;
	private String stop_time;
	private String create_time;
	private String update_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDay_limit() {
		return day_limit;
	}

	public void setDay_limit(String day_limit) {
		this.day_limit = day_limit;
	}

	public String getAll_limit() {
		return all_limit;
	}

	public void setAll_limit(String all_limit) {
		this.all_limit = all_limit;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getStop_time() {
		return stop_time;
	}

	public void setStop_time(String stop_time) {
		this.stop_time = stop_time;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		VkCampaign that = (VkCampaign) o;

		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		if (type != null ? !type.equals(that.type) : that.type != null) return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (status != null ? !status.equals(that.status) : that.status != null) return false;
		if (day_limit != null ? !day_limit.equals(that.day_limit) : that.day_limit != null) return false;
		if (all_limit != null ? !all_limit.equals(that.all_limit) : that.all_limit != null) return false;
		if (start_time != null ? !start_time.equals(that.start_time) : that.start_time != null) return false;
		return stop_time != null ? stop_time.equals(that.stop_time) : that.stop_time == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (status != null ? status.hashCode() : 0);
		result = 31 * result + (day_limit != null ? day_limit.hashCode() : 0);
		result = 31 * result + (all_limit != null ? all_limit.hashCode() : 0);
		result = 31 * result + (start_time != null ? start_time.hashCode() : 0);
		result = 31 * result + (stop_time != null ? stop_time.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "VkCampaign{" +
				"id='" + id + '\'' +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", status='" + status + '\'' +
				", day_limit='" + day_limit + '\'' +
				", all_limit='" + all_limit + '\'' +
				", start_time='" + start_time + '\'' +
				", stop_time='" + stop_time + '\'' +
				'}';
	}
}
