package persistence.dao.api;

import models.Group;

public interface IGroup {

    public void store(Group group);
    public Group getGroupByName(String groupName);
    public Group[] getGroups();
    
}
