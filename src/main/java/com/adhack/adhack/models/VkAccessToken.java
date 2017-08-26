package com.adhack.adhack.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vk_access_token")
public class VkAccessToken {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@Column
	private String access_token;

	@Column
	private String expires_in;

	@Column
	private String user_id;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		VkAccessToken that = (VkAccessToken) o;

		if (access_token != null ? !access_token.equals(that.access_token) : that.access_token != null) return false;
		if (expires_in != null ? !expires_in.equals(that.expires_in) : that.expires_in != null) return false;
		return user_id != null ? user_id.equals(that.user_id) : that.user_id == null;
	}

	@Override
	public int hashCode() {
		int result = access_token != null ? access_token.hashCode() : 0;
		result = 31 * result + (expires_in != null ? expires_in.hashCode() : 0);
		result = 31 * result + (user_id != null ? user_id.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "VkAccessToken{" +
				"access_token='" + access_token + '\'' +
				", expires_in='" + expires_in + '\'' +
				", user_id='" + user_id + '\'' +
				'}';
	}
}
