package neoxia.ma.kafka.demo.data.access.order.mapper;

import neoxia.ma.kafka.demo.annotations.Mapper;
import neoxia.ma.kafka.demo.data.access.order.entity.OrderEntity;
import neoxia.ma.kafka.demo.data.access.order.entity.OrderItemEntity;
import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.demo.domain.entity.OrderItem;
import neoxia.ma.kafka.demo.domain.valueobject.OrderItemId;
import neoxia.ma.kafka.domain.valueobject.CustomerId;
import neoxia.ma.kafka.domain.valueobject.Money;
import neoxia.ma.kafka.domain.valueobject.OrderId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static neoxia.ma.kafka.demo.domain.entity.Order.FAILURE_MESSAGE_DELIMITER;


@Mapper
public class OrderDataAccessMapper {

    public OrderEntity orderToOrderEntity(Order order) {
        OrderEntity orderEntity = OrderEntity.builder()
                .id(order.getId().getValue())
                .customerId(order.getCustomerId().getValue())
                .price(order.getPrice().getAmount())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages() != null ?
                        String.join(FAILURE_MESSAGE_DELIMITER, order.getFailureMessages()) : "")
                .build();
        orderEntity.getAddress().setOrder(orderEntity);
        orderEntity.getItems().forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));

        return orderEntity;
    }

    public Order orderEntityToOrder(OrderEntity orderEntity) {
        return Order.builder()
                .orderId(new OrderId(orderEntity.getId()))
                .customerId(new CustomerId(orderEntity.getCustomerId()))
                .price(new Money(orderEntity.getPrice()))
                .items(orderItemEntitiesToOrderItems(orderEntity.getItems()))
                .orderStatus(orderEntity.getOrderStatus())
                .failureMessages(orderEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(orderEntity.getFailureMessages()
                                .split(FAILURE_MESSAGE_DELIMITER))))
                .build();
    }

    private List<OrderItem> orderItemEntitiesToOrderItems(List<OrderItemEntity> items) {
        return items.stream()
                .map(orderItemEntity -> OrderItem.builder()
                        .orderItemId(new OrderItemId(orderItemEntity.getId()))
                        .price(new Money(orderItemEntity.getPrice()))
                        .quantity(orderItemEntity.getQuantity())
                        .subTotal(new Money(orderItemEntity.getSubTotal()))
                        .build())
                .collect(Collectors.toList());
    }

}
