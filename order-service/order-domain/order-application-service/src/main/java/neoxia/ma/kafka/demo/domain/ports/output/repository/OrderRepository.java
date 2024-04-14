package neoxia.ma.kafka.demo.domain.ports.output.repository;


import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.domain.valueobject.OrderId;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(OrderId orderId);
}
