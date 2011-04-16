package persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import models.ExternalLink;
import models.Group;
import persistence.dao.api.IGroupDao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class GroupDaoImpl extends BaseDao implements IGroupDao {

	private static final Logger LOG = Logger.getLogger(GroupDaoImpl.class);
	
	@Override
	public void store(Group group) {

	    DB db = getDatabase();
        DBCollection coll = db.getCollection(COLLECTION_GROUPS);
        
        BasicDBObject dbGroup = new BasicDBObject();

        dbGroup.put(FIELD_GROUP_ID, group.getId());
        dbGroup.put(FIELD_GROUP_NAME, group.getName());
        dbGroup.put(FIELD_GROUP_DESCRIPTION, group.getDescription());

        coll.insert(dbGroup);
	}

	@Override
	public Group getGroupByName(String groupName) {
	    Group returnGroup = null;

        DB db = getDatabase();
        DBCollection coll = db.getCollection(COLLECTION_GROUPS);
        BasicDBObject result;
        
        BasicDBObject query = new BasicDBObject();
        query.put(FIELD_GROUP_NAME, groupName);
        result = (BasicDBObject) coll.findOne(query);
        if (result != null) {

            returnGroup = new Group();
            returnGroup.setId(result.getInt(FIELD_GROUP_ID));
            returnGroup.setName(result.getString(FIELD_GROUP_NAME));
            returnGroup.setDescription(result.getString(FIELD_GROUP_DESCRIPTION));
            
            if ( LOG.isDebugEnabled() ) {
            	LOG.debug("Returning from GroupDaoImpl.getGroupByName(): "+ returnGroup);
            }
        }
        return returnGroup;
	}

	@Override
	public List<Group> getAllGroups(String orderBy) {

        int order = ("ASC" == orderBy) ? 1 : -1;

        List<Group> groupsArray = new ArrayList<Group>();

        DB db = getDatabase();
        DBCollection coll = db.getCollection(COLLECTION_GROUPS);

        BasicDBObject query = new BasicDBObject();
        //BasicDBObject field = new BasicDBObject();
        BasicDBObject sortfield = new BasicDBObject();

        //field.put(FIELD_GROUP_NAME, order);
        
        sortfield.put(FIELD_GROUP_NAME, order);
        
        // query: where
        // field: which field(s)
        DBCursor cursor = coll.find(query).sort(sortfield);

        while (cursor.hasNext()) {

            BasicDBObject obj = (BasicDBObject) cursor.next();

            Group group = new Group();
            group.setId(obj.getInt(FIELD_GROUP_ID));
            group.setName(obj.getString(FIELD_GROUP_NAME));
            group.setDescription(obj.getString(FIELD_GROUP_DESCRIPTION));

            groupsArray.add(group);
        }

        return groupsArray;
	}

}
