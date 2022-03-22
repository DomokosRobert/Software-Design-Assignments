package services;
import model.User;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


public class UserService {

    private final UserRepository repo;
    public UserService() {
        repo= new UserRepository();
    }
    public void createUser(User user){
       if(user.getUsername() != null && !user.getUsername().isEmpty()){
           repo.insertUser(user);
       }else{
           System.out.println("Error insertion");
       }


    }
    public User getByUsername(String username){
        if(username != null && !username.isEmpty()){
            return repo.findByUsername(username);
        }else{
            System.out.println("Error find");
            return null;
        }

    }


    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }
}
