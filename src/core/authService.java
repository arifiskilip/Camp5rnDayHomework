package core;

import entities.concetes.User;

public interface authService {
    void register(User user);
    void login(User user);
}
