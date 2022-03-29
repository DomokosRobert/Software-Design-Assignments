package controller;

import model.Destination;
import model.Pack;
import model.User;
import services.DestinationService;
import services.PackageService;

import java.util.List;

import static model.Status.NOT_BOOKED;

public class PackageController {
    private final PackageService service;
    public PackageController() {
        service = new PackageService();
    }

    public void createPackage(int id,String name,int price,int peopleNum,int period,String details, Destination dest){
        service.createPackage(new Pack(id,name,price,peopleNum,period,details,NOT_BOOKED,dest));
    }
    public List<Pack> getAllPacks(){
        return service.getAllPacks();
    }
    public void updatePrice(String name,int price){
        service.updatePrice(name,price);
    }
    public void updateSlots(String name,int slots){
        service.updateSlots(name,slots);
    }
    public void updatePeriodTime(String name,int period){
        service.updatePeriodTime(name,period);
    }
    public void updateDetails(String name,String details){
        service.updateDetails(name,details);
    }
    public void deletePack(String name){
        service.deletePack(name);
    }
    public void deleteDestPack(int dest){
        service.deleteDestPack(dest);
    }
    public List<Pack> getAvailable(){
        return service.getAvailablePack();
    }
    public List<Pack> getByDst(String city){
        return service.getByDst(city);
    }
    public List<Pack> getLargerPeriod(int period1,int period2){
        return service.getLargerPeriod(period1,period2);
    }
    public List<Pack> getSmallerPrice(int price1,int price2){
        return service.getSmallerPrice(price1,price2);
    }
    public List<Pack> getFilterAll(String city,int price1,int price2,int period1,int period2){return service.getFilterAll(city,price1,price2,period1,period2);}
    public List<Pack> getFilterDestPrice(String city,int price1,int price2){return service.getFilterDestPrice(city,price1,price2);}
    public List<Pack> getFilterDestPeriod(String city,int period1,int period2){return service.getFilterDestPeriod(city,period1,period2);}
    public List<Pack> getFilterPricePeriod(int price1,int price2,int period1,int period2){return service.getFilterPricePeriod(price1,price2,period1,period2);}
    public Pack findByName(String name){
        return service.findByName(name);
    }
    public void updatePack(Pack p){
        service.updatePack(p);
    }
}
