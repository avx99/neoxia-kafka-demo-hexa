package neoxia.ma.kafka.demo.domain.ports.input.service;


import neoxia.ma.kafka.demo.domain.dto.CreatePaymentCommand;
import neoxia.ma.kafka.demo.domain.dto.CreatePaymentResponse;

import javax.validation.Valid;

public interface PaymentApplicationService {
    CreatePaymentResponse createPayment(@Valid CreatePaymentCommand createOrderCommand);
}
