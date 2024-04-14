package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.annotations.Helper;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderCommand;
import neoxia.ma.kafka.demo.domain.entity.Customer;
import neoxia.ma.kafka.demo.domain.entity.Order;
import neoxia.ma.kafka.demo.domain.exception.OrderDomainException;
import neoxia.ma.kafka.demo.domain.mapper.OrderDataMapper;
import neoxia.ma.kafka.demo.domain.ports.output.repository.CustomerRepository;
import neoxia.ma.kafka.demo.domain.ports.output.repository.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Helper
@Slf4j
public class OrderCreateHelper {

    private final OrderRepository orderRepository;

    private final CustomerRepository customerRepository;

    private final OrderDataMapper orderDataMapper;


    public OrderCreateHelper(OrderRepository orderRepository,
                             CustomerRepository customerRepository,
                             OrderDataMapper orderDataMapper) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public Order persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        var order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        order.init();
        var output = saveOrder(order);
        log.info("Order is created with id: {}", output.getId().getValue());
        return output;
    }


    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customer);
        }
    }

    private Order saveOrder(Order order) {
        Order orderResult = orderRepository.save(order);
        if (orderResult == null) {
            log.error("Could not save order!");
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order is saved with id: {}", orderResult.getId().getValue());
        return orderResult;
    }
}
