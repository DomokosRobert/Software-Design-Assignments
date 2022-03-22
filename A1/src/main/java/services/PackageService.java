package services;

import model.Pack;
import repository.PackageRepository;

import java.util.List;

public class PackageService {
    private final PackageRepository repo;
    public PackageService() {
        repo= new PackageRepository();
    }
    public void createPackage(Pack pack){
        if(pack.getName() != null && !pack.getName().isEmpty()){
            repo.insertPackage(pack);
        }else{
            System.out.println("Error insertion");
        }


    }

    public List<Pack> getAllPacks() {
        return repo.getAllPacks();
    }
    public void updatePrice(String name,int price){
        repo.updatePrice(name,price);
    }
    public void updateSlots(String name,int slots){
         repo.updateSlots(name,slots);
    }
    public void updatePeriodTime(String name,int period){
        repo.updatePeriodTime(name,period);
    }
    public void updateDetails(String name,String details){
        repo.updateDetails(name,details);
    }
    public void deletePack(String name){
        repo.deletePack(name);

    }
    public void deleteDestPack(int dest){
        repo.deleteDestPack(dest);

    }
    public List<Pack> getAvailablePack(){
        return repo.getAvailablePacks();
    }
    public List<Pack> getByDst(String city){
        return repo.getByDst(city);
    }
    public List<Pack> getSmallerPrice(int price){
        return repo.getSmallerPrice(price);
    }
    public List<Pack> getLargerPeriod(int period){
        return repo.getLargerPeriod(period);
    }

}
