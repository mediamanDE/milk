package models;

import java.util.Date;
import java.util.List;

public class Message {
    private String _id;
    private Date postdate;
    private List<Group> groups;
    private List<Message> ancestors;
    private String messagetext;
    private User from;
    
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
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
