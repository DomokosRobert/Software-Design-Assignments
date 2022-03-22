package model;

import javax.persistence.*;

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

    public Pack(int id,String name, int price, int peopleNum, int periodTime,String details, Status stat, Destination destinations) {
       this.id = id;
        this.name = name;
        this.price = price;
        this.peopleNum = peopleNum;
        this.periodTime = periodTime;
        this.stat = stat;
        this.details=details;
        this.destinations = destinations;
    }

    public String getName() {
        return name;
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
