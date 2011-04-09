package persistence.dao;

import java.util.ArrayList;
import java.util.List;

import models.ExternalLink;
import models.Message;
import models.User;
import persistence.dao.api.IMessageDao;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.MessageDaoImpl;
import persistence.dao.impl.UserDaoImpl;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String openId = "111213";
		IUserDao userDao = new UserDaoImpl();
		User user = userDao.getByOpenId(openId);
		if (user == null) {
			System.out.println("Didn't find user by openid=" + openId + ". Creating user ...");

			User userNew = new User();
			userNew.setOpenId(openId);
			userNew.setAvatarUrl("www.mediaman.de");
			userNew.setDisplayname("Harry");
			userNew.setFullname("Harry Hirsch");
			userNew.setNickname("Otto");
			userNew.setPostCount(0);
			userNew.setTimezone("+1");
			
			ExternalLink extLnk1 = new ExternalLink();
			extLnk1.setName("Facebook");
			extLnk1.setUrl("www.facebook.com");
			
			ExternalLink extLnk2 = new ExternalLink();
			extLnk2.setName("Twitter");
			extLnk2.setUrl("www.twitter.com");
			
			List<ExternalLink> externalLinks = new ArrayList<ExternalLink>();
			externalLinks.add(extLnk1);
			externalLinks.add(extLnk2);
			
			userNew.setExternalLinks(externalLinks);

			userDao.store(userNew);
		} else {
			System.out.println("User found.");
		}
//
//		IMessageDao messageDao = new MessageDaoImpl();
////		Message message = messageDao.getMessageById("4da028a3c37b31bcb0f6628e");
//		List<Message> messages = messageDao.getAllMessages();
//		if(messages != null){
//			for(Message message : messages){
//				if(message != null){
//					message.debug();
//				}else{
//					System.out.println("message empty");
//				}
//			}
//		}else{
//			System.out.println("no messages");
//		}
//		
////		if(user != null){
////			IMessageDao messageDao = new MessageDaoImpl();
////			
////			Message messageNew = new Message();
////			messageNew.setFrom(user);
////			messageNew.setMessagetext("Hallo, wie kann ich eine Message in Mongo abspeichern?");
////			
////			messageDao.store(messageNew);
////			messageNew.debug();
////		}
	}
}
