package neoxia.ma.kafka.demo.domain.event;


import neoxia.ma.kafka.demo.domain.entity.Payment;
import neoxia.ma.kafka.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class PaymentCreationEvent extends PaymentEvent {

    private final DomainEventPublisher<PaymentCreationEvent> orderPaidEventDomainEventPublisher;

    public PaymentCreationEvent(Payment payment,
                                ZonedDateTime createdAt,
                                DomainEventPublisher<PaymentCreationEvent> orderPaidEventDomainEventPublisher) {
        super(payment, createdAt);
        this.orderPaidEventDomainEventPublisher = orderPaidEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderPaidEventDomainEventPublisher.publish(this);
    }
}
