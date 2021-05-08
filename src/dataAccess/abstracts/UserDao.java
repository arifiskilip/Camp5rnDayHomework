package dataAccess.abstracts;

import entities.concetes.User;

import java.util.ArrayList;

public interface UserDao {
    void add(User user);
    void delete(User user);
    void update(User user);
    ArrayList<User> list();
}
