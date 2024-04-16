package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.annotations.Helper;
import neoxia.ma.kafka.demo.domain.mapper.PaymentDataMapper;
import neoxia.ma.kafka.demo.domain.ports.output.message.publisher.payment.PaymentRequestMessagePublisher;

@Helper
@Slf4j
public class PaymentCreateCommandHandler {
    private final PaymentCreateHelper paymentCreateHelper;

    private final PaymentDataMapper paymentDataMapper;

    private final PaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher;

    public PaymentCreateCommandHandler(PaymentCreateHelper paymentCreateHelper,
                                       PaymentDataMapper paymentDataMapper,
                                       PaymentRequestMessagePublisher orderCreatedPaymentRequestMessagePublisher) {
        this.paymentCreateHelper = paymentCreateHelper;
        this.paymentDataMapper = paymentDataMapper;
        this.orderCreatedPaymentRequestMessagePublisher = orderCreatedPaymentRequestMessagePublisher;
    }
}
