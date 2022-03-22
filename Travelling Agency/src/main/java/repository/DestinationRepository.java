package repository;

import model.Destination;
import model.Pack;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

public class DestinationRepository {
    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertDestination(Destination dest) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(dest);
        em.getTransaction().commit();
        em.close();
    }

    public Destination findByCity(String city) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try{
            return em.createQuery(
                    "SELECT d FROM Destination d WHERE d.city =: city", Destination.class).setParameter("city",city).getSingleResult();
        }catch (NoResultException e) {
            System.out.println("No destination found");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }

    public List<Destination> getAllDest() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT d FROM Destination d", Destination.class).getResultList();
        }catch (NoResultException e) {
            System.out.println("No users made yet");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }

    public void deleteDest(String city) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            em.createQuery("DELETE FROM Destination d WHERE d.city=:city").setParameter("city", city).executeUpdate();
        }catch (NoResultException e) {
            System.out.println("No users made yet");
        }
        em.getTransaction().commit();
        em.close();

    }
}
