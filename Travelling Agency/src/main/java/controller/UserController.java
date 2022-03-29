package controller;

import model.Pack;
import model.User;
import services.UserService;

import java.util.ArrayList;
import java.util.List;


public class UserController {

    private final UserService service;
    public UserController() {
        service = new UserService();
    }

    public void createUser(int id,String username, String password){
        service.createUser(new User(id,username,password));
    }
    public User getByUsername(String username){
        return service.getByUsername(username);
    }
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }
    public void bookPack(User u, Pack p){service.bookPack(u,p);}
}
