import java.util.ArrayList;
import java.util.List;
import models.Message;
import models.User;
import org.junit.Test;
import persistence.dao.api.IMessageDao;
import persistence.dao.api.IUserDao;
import persistence.dao.impl.MessageDaoImpl;
import persistence.dao.impl.UserDaoImpl;
import play.test.UnitTest;
import service.TimelineService;

public class messages extends UnitTest {

    @Test
    public void messages() {


        List<Message> allMessages = new ArrayList<Message>();
        
        IMessageDao messageDao = new MessageDaoImpl();
        
        String openId = "345";
        IUserDao userDao = new UserDaoImpl();
        User user = userDao.getByOpenId(openId);
			
        Message messageNew = new Message();
        messageNew.setFrom(user);
        messageNew.setMessagetext("Hallo, wie kann ich eine Message in Mongo abspeichern?");

        messageDao.store(messageNew);

        allMessages = TimelineService.getAllMessages();

        System.out.println(allMessages.size());
        

    }

}
