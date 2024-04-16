package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.domain.dto.CreatePaymentCommand;
import neoxia.ma.kafka.demo.domain.dto.CreatePaymentResponse;
import neoxia.ma.kafka.demo.domain.ports.input.service.PaymentApplicationService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentApplicationServiceImpl implements PaymentApplicationService {
    private final PaymentCreateCommandHandler paymentCreateCommandHandler;

    public PaymentApplicationServiceImpl(PaymentCreateCommandHandler paymentCreateCommandHandler) {
        this.paymentCreateCommandHandler = paymentCreateCommandHandler;
    }

    @Override
    public CreatePaymentResponse createPayment(CreatePaymentCommand createOrderCommand) {
        return null;
    }
}
