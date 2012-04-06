package org.summercool.search.pojo;

public class UserTags {

	private int appId;
	private String province;
	private TagsSchema tags;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public TagsSchema getTags() {
		return tags;
	}

	public void setTags(TagsSchema tags) {
		this.tags = tags;
	}

}
