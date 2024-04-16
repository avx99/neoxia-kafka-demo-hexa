package neoxia.ma.kafka.demo.service.messaging.mapper;

import neoxia.ma.kafka.demo.annotations.Mapper;
import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.demo.domain.event.OrderDeliveryEvent;

@Mapper
public class OrderMessagingDataMapper {
    public Order eventToModel(OrderDeliveryEvent domainEvent) {
        return domainEvent.getOrder();
    }
}
