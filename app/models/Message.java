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
		int numAncestors = (ancestorIds != null) ? ancestorIds.size() : 0;
		for (int i = 0; i < numAncestors; i++) {
			Message msg = MessageService.getMessageById(ancestorIds.get(i));
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
	public List<String> getAncestors() {
		return ancestorIds;
	}
	/**
	 * @param ancestors the ancestors to set
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

        public String getMessagetext(boolean pareseHtml) {
            
            // Todo: parse Messagetext in a proper way!
            // escape html and add linebreaks.
            String parsedMessage = messagetext.replaceAll("<", "&lt;").replaceAll("<>", "&gt;");
            parsedMessage = parsedMessage.replaceAll("\r\n", "\n").replaceAll("\n", "<br />");

            return parsedMessage;
            
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
