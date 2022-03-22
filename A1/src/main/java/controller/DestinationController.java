package controller;

import model.Destination;
import model.Pack;
import model.User;
import services.DestinationService;
import services.UserService;

import java.util.List;

public class DestinationController {
    private final DestinationService service;
    public DestinationController() {
        service = new DestinationService();
    }

    public void createDestination(int id,String city, List<Pack> pack){
        service.createDestination(new Destination(id,city,pack));
    }
    public Destination getByCity(String city){
        return service.getByCity(city);
    }
    public List<Destination> getAllDest(){
        return service.getAllDest();
    }
    public void deleteDest(String city){
        service.deleteDest(city);
    }
}
