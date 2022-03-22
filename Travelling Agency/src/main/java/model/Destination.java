package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="destination")
public class Destination {

    @Id
    private int id;

    @Column
    private String city;

    @OneToMany(mappedBy = "destinations")
    private List<Pack> pack;

    public Destination(){}

    public Destination(int id,String city,List<Pack> pack){

        this.id=id;
        this.city=city;
        this.pack= pack;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }
}
