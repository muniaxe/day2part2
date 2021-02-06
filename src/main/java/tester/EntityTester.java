package tester;

import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityTester {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        try{
            Customer c1 = new Customer("John", "Johnson");
            Customer c2 = new Customer("Lars", "Larsen");
            Customer c3 = new Customer("Anders", "Andersen");
            
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
    }
}