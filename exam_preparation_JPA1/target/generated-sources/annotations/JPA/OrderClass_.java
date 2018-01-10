package JPA;

import JPA.Customer;
import JPA.OrderLine;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-09T22:18:52")
@StaticMetamodel(OrderClass.class)
public class OrderClass_ { 

    public static volatile ListAttribute<OrderClass, OrderLine> orderlines;
    public static volatile SingularAttribute<OrderClass, Long> id;
    public static volatile SingularAttribute<OrderClass, Customer> customers;

}