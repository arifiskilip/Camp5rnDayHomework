package business.concretes;

import business.abstracts.UserService;
import core.authService;
import dataAccess.abstracts.UserDao;
import entities.concetes.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManager  implements UserService {
    authService authService;
    UserDao userDao;

    public UserManager(core.authService authService, UserDao userDao) {
        this.authService = authService;
        this.userDao = userDao;
    }
    final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Override
    public void add(User user) {
        if (!validate(user.getEmail()))
        {
            System.out.println("Hatalı veya geçersiz bir email girdiniz.");
        }
        else if (!emailControl(user))
        {
            System.out.println("Girmiş olduğunu email zaten kullanılmakta. Lütfen farklı email kullanın.");
        }
       else if (user.getPassword().length()>=6 && user.getFirstName().length()>=2 && user.getLastName().length()>=2)
        {
            System.out.println("Lütfen email adresinize gelen doğrulama kodunu etkinleştirin.");
            sendEmail(user);
            emailVerification(user);
            authService.register(user);
        }
        else
        {
            System.out.println("Lütfen bilgileriniz kontrol edin. \nŞifre en az 6 karakterli olmalıdır." +
                    "\nİsim ve soyisim en az 2 karakterli olmalıdır.");
        }
    }

    @Override
    public ArrayList<User> list() {
        return userDao.list();
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    public boolean validate(String email) { //true or false
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public void sendEmail(User user) {
        System.out.println("Doğrulama kodu gönderildi : "+user.getEmail());
    }

    public void emailVerification(User user) {
        System.out.println("Email doğrulama başarılı artık giriş yapabilirsiniz.");
        user.setActivationEmail(true);
    }

    public boolean emailControl(User user) {
        int x=0;
        for (var item: userDao.list())
        {
            if (item.getEmail()==user.getEmail())
            {
                x+=1;
            }
        }
        if (x==1) return false;
        else return true;
    }
    public void googleLogin(User user)
    {
        authService.login(user);
    }
    public void googleRegister(User user)
    {
        authService.register(user);
    }
}
