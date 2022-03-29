package services;

import model.Pack;
import model.User;
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
    public List<Pack> getSmallerPrice(int price,int price2){
        return repo.getSmallerPrice(price,price2);
    }
    public List<Pack> getLargerPeriod(int period1,int period2){
        return repo.getLargerPeriod(period1,period2);
    }
    public List<Pack> getFilterAll(String city,int price1,int price2,int period1,int period2){return repo.getFilterAll(city,price1,price2,period1,period2);}
    public List<Pack> getFilterDestPrice(String city,int price1,int price2){return repo.getFilterDestPrice(city,price1,price2);}
    public List<Pack> getFilterDestPeriod(String city,int period1,int period2){return repo.getFilterDestPeriod(city,period1,period2);}
    public List<Pack> getFilterPricePeriod(int price1,int price2,int period1,int period2){return repo.getFilterPricePeriod(price1,price2,period1,period2);}

    public void updatePack(Pack p){repo.updatePack(p);}
    public Pack findByName(String name){return repo.findByName(name);}

}
