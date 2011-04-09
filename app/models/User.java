package models;

import java.util.List;

public class User {
	private String openId;
	private String nickname;
	private String fullname;
	private String displayname;
	private String avatarUrl;
	private int postCount;
	private String timezone;
	private List<ExternalLink> externalLinks;

	public void debug() {
		System.out.println("avatarUrl = " + getAvatarUrl());
		System.out.println("displayname = " + getDisplayname());
		System.out.println("fullname = " + getFullname());
		System.out.println("nickname = " + getNickname());
		System.out.println("openId = " + getOpenId());
		System.out.println("postCount = " + getPostCount());
		System.out.println("timezone = " + getTimezone());
	}

	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}
	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	/**
	 * @return the displayname
	 */
	public String getDisplayname() {
		return displayname;
	}
	/**
	 * @param displayname the displayname to set
	 */
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	/**
	 * @return the avatarUrl
	 */
	public String getAvatarUrl() {
		return avatarUrl;
	}
	/**
	 * @param avatarUrl the avatarUrl to set
	 */
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	/**
	 * @return the postCount
	 */
	public int getPostCount() {
		return postCount;
	}
	/**
	 * @param postCount the postCount to set
	 */
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}
	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	/**
	 * @return the externalLinks
	 */
	public List<ExternalLink> getExternalLinks() {
		return externalLinks;
	}
	/**
	 * @param externalLinks the externalLinks to set
	 */
	public void setExternalLinks(List<ExternalLink> externalLinks) {
		this.externalLinks = externalLinks;
	}
}
