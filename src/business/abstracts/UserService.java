package business.abstracts;

import entities.concetes.User;

import java.util.ArrayList;

public interface UserService {
    void add(User user);
    ArrayList<User> list();
    void delete(User user);
    void update(User user);
}
