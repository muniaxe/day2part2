package dbFacade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class CustomerFacade {

    private static EntityManagerFactory emf;
    public static CustomerFacade instance;

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    public Customer findById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer customer = em.find(Customer.class, id);
            return customer;
        } finally {
            em.close();
        }

    }

    public List<Customer> findByLastName(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> q = em.createQuery("Select c from Customer c WHERE c.lastName = :lastName", Customer.class);
            q.setParameter("lastName", name);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public long getNumberOfCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("Select COUNT(c) FROM Customer c");
            return (long)q.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Customer> allCustomers() {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Customer> q = em.createQuery("Select c from Customer c", Customer.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Customer addCustomer(String firstName, String lastName) {
        EntityManager em = emf.createEntityManager();
        Customer tmpCustomer = new Customer(firstName, lastName);
        try {
            em.getTransaction().begin();
            em.persist(tmpCustomer);
            em.getTransaction().commit();
            return tmpCustomer;
        } finally {
            em.close();
        }

    }

    void addCustomer(Customer c1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
