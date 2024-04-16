package neoxia.ma.kafka.demo.domain.entity;


import neoxia.ma.kafka.demo.domain.exception.OrderDomainException;
import neoxia.ma.kafka.demo.domain.valueobject.OrderItemId;
import neoxia.ma.kafka.domain.entity.AggregateRoot;
import neoxia.ma.kafka.domain.valueobject.CustomerId;
import neoxia.ma.kafka.domain.valueobject.Money;
import neoxia.ma.kafka.domain.valueobject.OrderId;
import neoxia.ma.kafka.domain.valueobject.OrderStatus;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class Order extends AggregateRoot<OrderId> implements Serializable {
    private final CustomerId customerId;
    private final Money price;
    private final List<OrderItem> items;

    private OrderStatus orderStatus;
    private List<String> failureMessages;

    public static final String FAILURE_MESSAGE_DELIMITER = ",";


    public void init() {
        if (orderStatus != null) {
            throw new OrderDomainException("Order is not in correct state to be initialized!");
        }
        orderStatus = OrderStatus.PENDING;
    }

    public void pay() {
        if (orderStatus != OrderStatus.PENDING) {
            throw new OrderDomainException("Order is not in correct state for pay operation!");
        }
        orderStatus = OrderStatus.PAID;
    }

    public void deliver() {
        if (orderStatus != OrderStatus.PAID) {
            throw new OrderDomainException("Order is not in correct state for delivering operation!");
        }
        orderStatus = OrderStatus.IN_DELIVERY;
    }

    public void close() {
        if (orderStatus != OrderStatus.IN_DELIVERY || orderStatus != OrderStatus.DELIVERED) {
            throw new OrderDomainException("Order is not in correct state to be closed!");
        }
        orderStatus = OrderStatus.DELIVERED;
    }


    private Order(Builder builder) {
        super.setId(builder.orderId);
        customerId = builder.customerId;
        price = builder.price;
        items = builder.items;
        orderStatus = builder.orderStatus;
        failureMessages = builder.failureMessages;
    }

    public static Builder builder() {
        return new Builder();
    }

    public CustomerId getCustomerId() {
        return customerId;
    }


    public Money getPrice() {
        return price;
    }

    public List<OrderItem> getItems() {
        return items;
    }


    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }


    public static final class Builder {
        private OrderId orderId;
        private CustomerId customerId;
        private Money price;
        private List<OrderItem> items;
        private OrderStatus orderStatus;
        private List<String> failureMessages;

        private Builder() {
        }

        public Builder orderId(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }


        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder items(List<OrderItem> val) {
            items = val;
            return this;
        }

        public Builder orderStatus(OrderStatus val) {
            orderStatus = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
