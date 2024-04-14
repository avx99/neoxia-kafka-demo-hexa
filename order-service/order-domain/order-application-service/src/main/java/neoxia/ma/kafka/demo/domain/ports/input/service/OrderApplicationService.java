package neoxia.ma.kafka.demo.domain.ports.input.service;


import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderCommand;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderResponse;

import javax.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
}
