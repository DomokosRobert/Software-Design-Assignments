package repository;

import model.Pack;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

import static model.Status.IN_PROGRESS;
import static model.Status.NOT_BOOKED;

public class PackageRepository {
    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertPackage(Pack pack) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(pack);
        em.getTransaction().commit();
        em.close();
    }
    public List<Pack> getAllPacks() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT p FROM Pack p", Pack.class).getResultList();
        }catch (NoResultException e) {
            System.out.println("No packs made yet");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }

    public void updatePrice(String name,int price){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("UPDATE Pack p SET p.price =: price WHERE p.name =: name").setParameter("name",name ).setParameter("price",price).executeUpdate();
        }catch (NoResultException e) {
            System.out.println("No packs found");
        }
        em.getTransaction().commit();
        em.close();

    }
    public void updateSlots(String name,int peopleNum){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("UPDATE Pack p SET p.peopleNum =: peopleNum WHERE p.name =: name").setParameter("name",name ).setParameter("peopleNum",peopleNum).executeUpdate();
        }catch (NoResultException e) {
            System.out.println("No packs found");
        }
        em.getTransaction().commit();
        em.close();

    }
    public void updatePeriodTime(String name,int periodTime){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("UPDATE Pack p SET p.periodTime =: periodTime WHERE p.name =: name").setParameter("name",name ).setParameter("periodTime",periodTime).executeUpdate();
        }catch (NoResultException e) {
            System.out.println("No packs found");
        }
        em.getTransaction().commit();
        em.close();

    }
    public void updateDetails(String name,String details){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("UPDATE Pack p SET p.details =: details WHERE p.name =: name").setParameter("name",name ).setParameter("details",details).executeUpdate();
        }catch (NoResultException e) {
            System.out.println("No packs found");
        }
        em.getTransaction().commit();
        em.close();

    }
    public void deletePack(String name){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("DELETE FROM Pack p WHERE p.name =: name").setParameter("name",name ).executeUpdate();
        }catch (NoResultException e) {
            System.out.println("Fail to delete");
        }
        em.getTransaction().commit();
        em.close();

    }
    public void deleteDestPack(int destinations)
    {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("DELETE FROM Pack p WHERE p.destinations.id =: destinations").setParameter("destinations",destinations ).executeUpdate();
        }catch (NoResultException e) {
            System.out.println("Fail to delete");
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Pack> getAvailablePacks() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT p FROM Pack p WHERE p.stat =: NOT_BOOKED or p.stat =: IN_PROGRESS", Pack.class).setParameter("NOT_BOOKED",NOT_BOOKED).setParameter("IN_PROGRESS",IN_PROGRESS).getResultList();
        }catch (NoResultException e) {
            System.out.println("No packs made yet");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }
    public List<Pack> getByDst(String city) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT p FROM Pack p WHERE p.destinations.city =: city", Pack.class).setParameter("city",city).getResultList();
        }catch (NoResultException e) {
            System.out.println("No packs made yet");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }
    public List<Pack> getSmallerPrice(int price) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT p FROM Pack p WHERE p.price <=: price", Pack.class).setParameter("price",price).getResultList();
        }catch (NoResultException e) {
            System.out.println("No packs made yet");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }
    public List<Pack> getLargerPeriod(int periodTime) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT p FROM Pack p WHERE p.periodTime >=: periodTime", Pack.class).setParameter("periodTime",periodTime).getResultList();
        }catch (NoResultException e) {
            System.out.println("No packs made yet");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }


}

