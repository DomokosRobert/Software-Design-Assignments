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
    public List<Pack> getLargerPeriod(int city){
        return service.getLargerPeriod(city);
    }
    public List<Pack> getSmallerPrice(int city){
        return service.getSmallerPrice(city);
    }

}
