package googleAuth;

import entities.concetes.User;

public class googleAuthManager {
    public void register(User user)
    {
        System.out.println(user.getFirstName()+" : adlı kullanıcı google hesabı  ile kayıt olndu.");
    }
    public void login(User user)
    {
        System.out.println(user.getFirstName()+" : adlı kullanıcı google hesabı ile giriş yaptı.");
    }

}
