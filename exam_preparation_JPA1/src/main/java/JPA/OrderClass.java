/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author hvn15
 */
@Entity
public class OrderClass implements Serializable {
    /*
    OPS! reason this class isnt named Order is that
    Order is a keyword in SQL making fx create table Order
    not work...
    */

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customers; //same name as mappedby from customer
    
    @OneToMany(mappedBy="orders", cascade = CascadeType.ALL)
    private List<OrderLine> orderlines;

    public OrderClass(Long id, Customer customers, List<OrderLine> orderlines) {
        this.id = id;
        this.customers = customers;
        this.orderlines = orderlines;
    }

    public OrderClass() {
    }

    public OrderClass(Long id, Customer customers) {
        this.id = id;
        this.customers = customers;
    }
    
    
    
    
    
    

    public List<OrderLine> getOrderLines() {
        return orderlines;
    }
    
    public Customer getCustomer() {
        return customers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderClass)) {
            return false;
        }
        OrderClass other = (OrderClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.Order[ id=" + id + " ]";
    }
    
}
