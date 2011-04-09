package models;

import java.util.Date;
import java.util.List;

public class Message {
    private String id;
    private Date postdate;
    private List<Group> groups;
    private List<Message> ancestors;
    private String messagetext;
    private User from;


	public void debug() {
		
		System.out.println("[\n"
				+ "_id = " + id + ",\n"
				+ "postdate = " + postdate + ",\n"
				+ "messagetext = " + messagetext);

		System.out.println("groups = \n   [");
		int numGroups = (groups != null) ? groups.size() : 0;
		for (int i = 0; i < numGroups; i++) {
			Group grp = groups.get(i);
			System.out.println("      [name = " + grp.getName() + "]");
		}
		System.out.println("   ]");

		System.out.println("ancestors = \n   [");
		int numAncestors = (ancestors != null) ? ancestors.size() : 0;
		for (int i = 0; i < numAncestors; i++) {
			Message msg = ancestors.get(i);
			System.out.println("      [_id = " + msg.getId() + " | postdate = " + msg.getPostdate() + "]");
		}
		System.out.println("   ]");

		System.out.println("from =/n   ["
				+ "      openId = " + from.getOpenId() + ",\n"
				+ "      nickname = " + from.getNickname() + ",\n"
				+ "      fullname = " + from.getFullname() + ",\n"
				+ "      displayname = " + from.getDisplayname() + ",\n"
				+ "   ]");

		System.out.println("]");
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param _id the _id to set
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
	 * @param postdate the postdate to set
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
	 * @param groups the groups to set
	 */
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	/**
	 * @return the ancestors
	 */
	public List<Message> getAncestors() {
		return ancestors;
	}
	/**
	 * @param ancestors the ancestors to set
	 */
	public void setAncestors(List<Message> ancestors) {
		this.ancestors = ancestors;
	}
	/**
	 * @return the messagetext
	 */
	public String getMessagetext() {
		return messagetext;
	}
	/**
	 * @param messagetext the messagetext to set
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
	 * @param from the from to set
	 */
	public void setFrom(User from) {
		this.from = from;
	}
    
}
