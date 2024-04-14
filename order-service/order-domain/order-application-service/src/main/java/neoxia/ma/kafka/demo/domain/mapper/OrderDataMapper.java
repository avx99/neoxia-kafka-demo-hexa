package neoxia.ma.kafka.demo.domain.mapper;


import neoxia.ma.kafka.demo.annotations.Mapper;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderCommand;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderResponse;
import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.demo.domain.entity.OrderItem;
import neoxia.ma.kafka.domain.valueobject.CustomerId;
import neoxia.ma.kafka.domain.valueobject.Money;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public class OrderDataMapper {


    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }


    private List<OrderItem> orderItemsToOrderItemEntities(
            List<neoxia.ma.kafka.demo.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }


}
