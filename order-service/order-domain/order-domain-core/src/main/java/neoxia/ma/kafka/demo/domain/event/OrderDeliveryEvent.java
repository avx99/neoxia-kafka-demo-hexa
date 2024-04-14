package neoxia.ma.kafka.demo.domain.event;

import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class OrderDeliveryEvent extends OrderEvent{

    private final DomainEventPublisher<OrderDeliveryEvent> orderDeliveryEventEventPublisher;

    public OrderDeliveryEvent(Order order, ZonedDateTime createdAt, DomainEventPublisher<OrderDeliveryEvent> orderDeliveryEventEventPublisher) {
        super(order, createdAt);
        this.orderDeliveryEventEventPublisher = orderDeliveryEventEventPublisher;
    }

    @Override
    public void fire() {
        orderDeliveryEventEventPublisher.publish(this);
    }
}
