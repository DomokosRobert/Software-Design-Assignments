package repository;

import model.Pack;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ro.tutorial.lab.SD");

    public void insertUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }
    public User findByUsername(String username){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try{
            return em.createQuery(
            "SELECT u FROM User u WHERE u.username =: username", User.class).setParameter("username",username).getSingleResult();
        }catch (NoResultException e) {
            System.out.println("No user found");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }
    public void bookPack(User u,Pack p){
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        User existingUser = em.find(User.class, u.getId());
        Pack existingPack = em.find(Pack.class, p.getId());
        existingUser.getPacks().add(existingPack);
        em.getTransaction().commit();
        em.close();
    }


    public List<User> getAllUsers() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        }catch (NoResultException e) {
            System.out.println("No users made yet");
        }
        em.getTransaction().commit();
        em.close();
        return null;
    }
}
