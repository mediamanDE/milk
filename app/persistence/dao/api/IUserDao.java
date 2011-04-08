package persistence.dao.api;

import models.User;

public interface IUserDao {

    public void store(User user); // Create and update
    public User getByOpenId(String openId);

}
