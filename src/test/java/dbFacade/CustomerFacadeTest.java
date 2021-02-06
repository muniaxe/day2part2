/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbFacade;

import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jack
 */
public class CustomerFacadeTest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("puTest");

    @BeforeAll
    public static void setUpClass() {
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);

        //Add Customers
        cf.addCustomer("Mathias", "Hvid");
        cf.addCustomer("Emil", "Dyrhøi");
        cf.addCustomer("Jack", "Jensen");
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findById method, of class CustomerFacade.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 2;
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        Customer expResult = new Customer("Emil", "Dyrehøi");
        Customer result = cf.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByLastName method, of class CustomerFacade.
     */
    @Test
    public void testFindByLastName() {
        System.out.println("findByLastName");
        String name = "Hvid";
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        Customer c1 = new Customer("Mathias", "Hvid");
        List<Customer> cL = new ArrayList<>();
        cL.add(c1);
        List<Customer> expResult = cL;
        List<Customer> result = cf.findByLastName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfCustomers method, of class CustomerFacade.
     */
    @Test
    public void testGetNumberOfCustomers() {
        System.out.println("getNumberOfCustomers");
        CustomerFacade cf = CustomerFacade.getCustomerFacade(emf);
        long expResult = 3;
        long result = cf.getNumberOfCustomers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
