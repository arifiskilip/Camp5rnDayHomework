package dataAccess.concretes.inMemory;

import dataAccess.abstracts.UserDao;
import entities.concetes.User;

import java.util.ArrayList;

public class inMemoryUserDao implements UserDao {
    ArrayList<User> users;

    public inMemoryUserDao() {
        users = new ArrayList<User>();
        this.users.add(new User(1,"Arif","İskilip","arifiskilip@icloud.com","123456",true));
        this.users.add(new User(2,"Koray","Cebeci","koraycebeci@icloud.com","123456",true));
        this.users.add(new User(3,"Muhammet","Emin","eminmuhammet@icloud.com","123456",true));
    }

    public void add(User user) {
        users.add(user);
        System.out.println(user.getFirstName()+" : Adlı kullanıcı eklendi.");
    }

    @Override
    public void delete(User user) {
        System.out.println(user.getFirstName()+" : Adlı kullanıcı silindi.");
    }

    @Override
    public void update(User user) {
        System.out.println("Güncelleme başarılı.");
    }

    @Override
    public ArrayList<User> list() {
        return users;
    }
}
