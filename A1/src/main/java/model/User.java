package model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name ="user")
public class User{

    @Id
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User(){}

    public User(int id, String username,String password){

        this.id=id;
        this.username=username;
        this.password=password;
    }

}
