package models;

import java.util.Date;
import java.util.List;

import service.MessageService;

public class Message {
	private String id;
	private Date postdate;
	private List<Group> groups;
	private List<String> ancestorIds;
	private String messagetext;
	private User from;

	/**
	 * @return String representation of the object
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Message [\n");
		sb.append("_id=").append(id).append(",\n");
		sb.append("postdate=").append(postdate).append(",\n");
		sb.append("messagetext=").append(messagetext).append(",\n");
		sb.append("groups=[\n");
		for (Group group : groups) {
			sb.append("      [name = ").append(group.getName());
		}
		sb.append("\n]");
		sb.append("ancestors=[\n");
		for (String ancestorId : ancestorIds) {
			Message msg = MessageService.getMessageById(ancestorId);
			sb.append("      [_id = ").append(msg.getId());
			sb.append(" | postdate = ").append(msg.getPostdate()).append("]");
		}
		sb.append("\n]\nfrom =/n   [      openId = ");
		sb.append("openId=").append(from.getOpenId()).append(",\n");
		sb.append("nickname=").append(from.getNickname()).append(",\n");
		sb.append("fullname=").append(from.getFullname()).append(",\n");
		sb.append("displayname=").append(from.getDisplayname()).append("\n]");
		return sb.toString();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param _id
	 *            the _id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the postdate
	 */
	public Date getPostdate() {
		return postdate;
	}

	/**
	 * @param postdate
	 *            the postdate to set
	 */
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	/**
	 * @return the groups
	 */
	public List<Group> getGroups() {
		return groups;
	}

	/**
	 * @param groups
	 *            the groups to set
	 */
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	/**
	 * @return the ancestors
	 */
	public List<String> getAncestors() {
		return ancestorIds;
	}

	/**
	 * @param ancestors
	 *            the ancestors to set
	 */
	public void setAncestors(List<String> ancestors) {
		this.ancestorIds = ancestors;
	}

	/**
	 * @return the messagetext
	 */
	public String getMessagetext() {
		return messagetext;
	}

	/**
	 * @param messagetext
	 *            the messagetext to set
	 */
	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	/**
	 * @return the from
	 */
	public User getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            the from to set
	 */
	public void setFrom(User from) {
		this.from = from;
	}

}
