/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import JPA.Customer;
import JPA.OrderClass;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author hvn15
 */
public class FacadeClass {

    EntityManagerFactory emf;

    public FacadeClass() {
    }

    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("pu");

        FacadeClass f = new FacadeClass();
        f.addEntityManagerFactory(emf);
        //Create a Customer
        //f.addCustomer(new Customer(3L, "AnnaEmail@email.com", "Anna"));

        //Find a Customer (with id?)
        //System.out.println(f.findCustomer(1)); System.out.println(f.findCustomer(2));
        
        //Get all Customers
        //System.out.println(f.getAllCustomers());
        
        //Create an Order (foreign key customer_id needs to exist in costumer pk) this is also "add an order to a customer"
        //f.createOrder(new OrderClass(3L, new Customer(2L)));
        
 
        
    }

    public void addCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public String findCustomer(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer costumer = em.find(JPA.Customer.class, id);
            return costumer.getName() + ", " + costumer.getEmail();
        } finally {
            em.close();
        }
    }

    public String getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Customer> query
                    = em.createQuery("SELECT c FROM Customer c", Customer.class);
            List<Customer> results = query.getResultList();
            String fill = "";
            for (int i = 0; i < results.size(); i++) {
                fill += results.get(i).getName() + ", " + results.get(i).getEmail() + "\n";
            }
            return fill;

        } finally {
            em.close();
        }
    }

    public void createOrder(OrderClass order) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
