/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hvn15
 */
@Entity
@Table(name="orderline")
public class OrderLine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderClass orders; //same name as mappedby from order
    
    @ManyToOne
    @JoinColumn(name = "itemtype_id", nullable = false)
    private ItemType itemtypes; //same name as mappedby from itemtype

    public OrderClass getOrders() {
        return orders;
    }

    public OrderLine(Long id, int quantity, OrderClass orders, ItemType itemtypes) {
        this.id = id;
        this.quantity = quantity;
        this.orders = orders;
        this.itemtypes = itemtypes;
    }


    public OrderLine() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemType getItemtypes() {
        return itemtypes;
    }

    public void setItemtypes(ItemType itemtypes) {
        this.itemtypes = itemtypes;
    }
    
    
    
    public ItemType getItemtype() {
        return itemtypes;
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
        if (!(object instanceof OrderLine)) {
            return false;
        }
        OrderLine other = (OrderLine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.OrderLine[ id=" + id + " ]";
    }
    
}
