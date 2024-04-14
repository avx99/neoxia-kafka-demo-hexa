package neoxia.ma.kafka.demo.domain;


import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.demo.domain.event.OrderDeliveryEvent;
import neoxia.ma.kafka.domain.event.publisher.DomainEventPublisher;

public interface OrderDomainService {


    void payOrder(Order order);

    OrderDeliveryEvent deliverOrder(Order order, DomainEventPublisher<OrderDeliveryEvent> orderDeliveryEventPublisher);

    void closeOrder(Order order);

}
