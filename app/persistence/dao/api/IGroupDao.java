package persistence.dao.api;

import java.util.List;

import models.Group;

public interface IGroupDao {

    public void store(Group group);
    public Group getGroupByName(String groupName);
    public List<Group> getAllGroups(String orderBy);
    
}
