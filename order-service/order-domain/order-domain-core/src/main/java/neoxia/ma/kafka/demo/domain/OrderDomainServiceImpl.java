package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.demo.domain.event.OrderDeliveryEvent;
import neoxia.ma.kafka.domain.event.publisher.DomainEventPublisher;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static neoxia.ma.kafka.domain.DomainConstants.UTC;


@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {
    @Override
    public void payOrder(Order order) {
        order.pay();
        log.info("Order with id: {} is paid", order.getId().getValue());
    }

    @Override
    public OrderDeliveryEvent deliverOrder(Order order, DomainEventPublisher<OrderDeliveryEvent> orderDeliveryEventPublisher) {
        order.deliver();
        log.info("Order with id: {} is in delivery", order.getId().getValue());
        return new OrderDeliveryEvent(order, ZonedDateTime.now(ZoneId.of(UTC)), orderDeliveryEventPublisher);
    }

    @Override
    public void closeOrder(Order order) {
        order.close();
        log.info("Order with id: {} is in delivery", order.getId().getValue());
    }
}
