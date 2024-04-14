package neoxia.ma.kafka.demo.domain.ports.output.message.publisher.payment;


import neoxia.ma.kafka.demo.domain.event.OrderPaidEvent;
import neoxia.ma.kafka.domain.event.publisher.DomainEventPublisher;

public interface OrderPaymentRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
