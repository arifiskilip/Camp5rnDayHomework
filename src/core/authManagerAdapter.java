package core;

import entities.concetes.User;
import googleAuth.googleAuthManager;

public class authManagerAdapter implements authService{
    googleAuthManager googleAuthManager;

    public authManagerAdapter() {
        googleAuthManager = new googleAuthManager();
    }

    @Override
    public void register(User user) {
        googleAuthManager.register(user);
    }

    @Override
    public void login(User user) {
        googleAuthManager.login(user);
    }
}
