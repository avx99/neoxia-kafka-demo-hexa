package neoxia.ma.kafka.demo.data.access.order.adapter;

import neoxia.ma.kafka.demo.annotations.Adapter;
import neoxia.ma.kafka.demo.data.access.order.mapper.OrderDataAccessMapper;
import neoxia.ma.kafka.demo.data.access.order.repository.OrderJpaRepository;
import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.demo.domain.ports.output.repository.OrderRepository;
import neoxia.ma.kafka.domain.valueobject.OrderId;

import java.util.Optional;

@Adapter
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository,
                               OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository
                .save(orderDataAccessMapper.orderToOrderEntity(order)));
    }


    @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderJpaRepository.findById(orderId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }
}
