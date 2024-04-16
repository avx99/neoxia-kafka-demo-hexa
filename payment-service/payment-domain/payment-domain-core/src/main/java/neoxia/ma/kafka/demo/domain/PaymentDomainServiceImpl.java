package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.domain.entity.Payment;
import neoxia.ma.kafka.domain.event.publisher.DomainEventPublisher;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static neoxia.ma.kafka.domain.DomainConstants.UTC;


@Slf4j
public class PaymentDomainServiceImpl implements PaymentDomainService {
    @Override
    public void createPayment(Payment payment) {
        payment.validate();
        log.info("Order with id: {} is paid", payment.getOrderId().getValue().toString());
    }
}
