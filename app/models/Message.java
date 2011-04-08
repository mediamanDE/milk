package models;

import java.util.Date;


public class Message {
	private int _id;
	private Date postdate;
	private Group[] groups;
	private Message[] ancestors;
	private String messagetext;
	private User from;
}
