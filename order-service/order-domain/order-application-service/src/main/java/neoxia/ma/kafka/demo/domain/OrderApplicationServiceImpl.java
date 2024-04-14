package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderCommand;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderResponse;
import neoxia.ma.kafka.demo.domain.ports.input.service.OrderApplicationService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderApplicationServiceImpl implements OrderApplicationService {
    private final OrderCreateCommandHandler orderCreateCommandHandler;

    public OrderApplicationServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
    }

    @Override
    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand) {
        return orderCreateCommandHandler.createOrder(createOrderCommand);
    }
}
