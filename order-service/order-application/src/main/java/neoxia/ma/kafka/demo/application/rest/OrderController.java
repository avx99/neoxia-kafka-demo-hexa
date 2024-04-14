package neoxia.ma.kafka.demo.application.rest;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderCommand;
import neoxia.ma.kafka.demo.domain.dto.create.CreateOrderResponse;
import neoxia.ma.kafka.demo.domain.ports.input.service.OrderApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        log.info("Creating order for customer: {} at restaurant: {}", createOrderCommand.getCustomerId(),
                createOrderCommand.getRestaurantId());
        CreateOrderResponse createOrderResponse = orderApplicationService.createOrder(createOrderCommand);
        log.info("Order created with status: {}", createOrderResponse.getOrderStatus());
        return ResponseEntity.ok(createOrderResponse);
    }

}
