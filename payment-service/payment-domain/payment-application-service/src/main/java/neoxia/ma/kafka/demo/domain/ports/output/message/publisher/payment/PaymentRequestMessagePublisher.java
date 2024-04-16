package neoxia.ma.kafka.demo.domain.ports.output.message.publisher.payment;


import neoxia.ma.kafka.demo.domain.event.PaymentCreationEvent;
import neoxia.ma.kafka.domain.event.publisher.DomainEventPublisher;

public interface PaymentRequestMessagePublisher extends DomainEventPublisher<PaymentCreationEvent> {
}
