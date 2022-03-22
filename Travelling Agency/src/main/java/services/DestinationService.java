package services;

import model.Destination;
import model.Pack;
import model.User;
import repository.DestinationRepository;
import repository.PackageRepository;

import java.util.List;

public class DestinationService {
    private final DestinationRepository repo;
    public DestinationService() {
        repo= new DestinationRepository();
    }
    public void createDestination(Destination dest){
        if(dest.getCity() != null && !dest.getCity().isEmpty()){
            repo.insertDestination(dest);
        }else{
            System.out.println("Error insertion");
        }


    }

    public Destination getByCity(String city) {
        if(city != null && !city.isEmpty()){
            return repo.findByCity(city);
        }else{
            System.out.println("Error find");
            return null;
        }
    }

    public List<Destination> getAllDest() {
        return repo.getAllDest();
    }

    public void deleteDest(String city) {
        repo.deleteDest(city);
    }
}
