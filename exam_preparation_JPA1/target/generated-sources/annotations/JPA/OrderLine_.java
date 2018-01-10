package JPA;

import JPA.ItemType;
import JPA.OrderClass;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-01-09T22:18:52")
@StaticMetamodel(OrderLine.class)
public class OrderLine_ { 

    public static volatile SingularAttribute<OrderLine, Integer> quantity;
    public static volatile SingularAttribute<OrderLine, OrderClass> orders;
    public static volatile SingularAttribute<OrderLine, Long> id;
    public static volatile SingularAttribute<OrderLine, ItemType> itemtypes;

}