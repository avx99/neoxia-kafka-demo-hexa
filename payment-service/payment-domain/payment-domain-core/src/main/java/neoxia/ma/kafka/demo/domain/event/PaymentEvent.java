package neoxia.ma.kafka.demo.domain.event;


import neoxia.ma.kafka.demo.domain.entity.Payment;
import neoxia.ma.kafka.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class PaymentEvent implements DomainEvent<Payment> {
    private final Payment payment;
    private final ZonedDateTime createdAt;

    public PaymentEvent(Payment payment, ZonedDateTime createdAt) {
        this.payment = payment;
        this.createdAt = createdAt;
    }

    public Payment getPayment() {
        return payment;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
