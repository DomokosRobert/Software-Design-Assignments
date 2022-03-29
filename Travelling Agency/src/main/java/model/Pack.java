package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="package")
public class Pack {
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private int peopleNum;

    @Column
    private int periodTime;

    @Column
    private String details;

    @Column(nullable = false)
    private Status stat;

    @ManyToOne
    @JoinColumn(name = "destination_city")
    private Destination destinations;

    @ManyToMany
    private List<User> users;

    public Pack(int id,String name, int price, int peopleNum, int periodTime,String details, Status stat, Destination destinations) {
       this.id = id;
        this.name = name;
        this.price = price;
        this.peopleNum = peopleNum;
        this.periodTime = periodTime;
        this.stat = stat;
        this.details=details;
        this.destinations = destinations;
        this.users = null;

    }

    public String getName() {
        return name;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public void setStat(Status stat) {
        this.stat = stat;
    }

    public Pack() {

    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public int getPeriodTime() {
        return periodTime;
    }

    public String getDetails() {
        return details;
    }

    public Status getStat() {
        return stat;
    }

    public Destination getDestinations() {
        return destinations;
    }
}
