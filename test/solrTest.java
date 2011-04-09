import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Group;
import models.Message;
import models.User;

import org.junit.Test;

import play.test.UnitTest;

public class solrTest extends UnitTest {

	  @Test
    public void TestAddSearchDelete() {
    	
    	Message messageTest = new Message();
    	int ID = new Random().nextInt();
    	
    	// Verbesserung zu GUID
    	messageTest.setId(ID);
    	
    	// Verbesserung zu From/To, Master/Postdate oder seperates Tracking
    	//messageTest.se
    	
    	User userTemp = new User();
    	userTemp.setOpenId(Integer.toString(new Random().nextInt()));
    	
    	userTemp.setFullname("Marco Rauschenbach");
    	messageTest.setFrom(userTemp);
    	  	
    	Group groupTemp1 = new Group();
    	groupTemp1.setName("Group1");
    	Group groupTemp2 = new Group();
    	groupTemp2.setName("Group2");
    	Group groupTemp3 = new Group();
    	groupTemp3.setName("Group3");
    	
    	List<Group> listGroup = new ArrayList<Group>();
    	listGroup.add(groupTemp1);
    	listGroup.add(groupTemp2);
    	listGroup.add(groupTemp3);
    	messageTest.setGroups(listGroup);
    	
    	messageTest.setMessagetext("DAS IST EIN TEST");
    	//messageTest.setPostdate(Calendar.getInstance().getTime());
    	//messageTest.setPostdate(Calendar.getInstance().getTime());
    	
    	
    	// add
    	solr.Add.addMessage(messageTest);
      
    	
    	//find
    	//solr.Search.SearchMessageAll("is", false);
    	
    	assertEquals(solr.Search.SearchMessageByID(messageTest.getId()).getId(),messageTest.getId());
    	
    	//delete
    	solr.Delete.deleteMessage(messageTest);
    	//solr.Delete.deleteByID(messageTest.get_id()+"");
    	
    	//assertEquals(2, 1 + 1);
    }
	  
	  
   
}
