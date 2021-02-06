package tester;

import dbFacade.CustomerFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FacadeTester {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);

        //Add Customer
        facade.addCustomer("Mathias", "Hvid");
        facade.addCustomer("Emil", "Dyrhøi");
        facade.addCustomer("Jack", "Jensen");

        //Find by lastname
        System.out.println("People with last name Johnson: " + facade.findByLastName("Jonson"));

        //Find all Customer
        System.out.println("All customers: " + facade.allCustomers().size());

        //Find number of Customers
        System.out.println("Number of customers" + facade.getNumberOfCustomers());

        //Find Customer by ID 2
        System.out.println("Customer with ID : " + facade.findById(2));

    }
}
