import business.abstracts.UserService;
import business.concretes.UserManager;
import core.authManagerAdapter;
import dataAccess.abstracts.UserDao;
import dataAccess.concretes.inMemory.inMemoryUserDao;
import entities.concetes.User;

public class Main {

    public static void main(String[] args) {

        UserManager manager = new UserManager(new authManagerAdapter(),new inMemoryUserDao());
        User arif = new User();
        arif.setId(4);
        arif.setFirstName("Arif");
        arif.setLastName("İskilip");
        arif.setEmail("arifiskilipp@icloud.com");
        arif.setPassword("123456");
        manager.add(arif);


    }

}
