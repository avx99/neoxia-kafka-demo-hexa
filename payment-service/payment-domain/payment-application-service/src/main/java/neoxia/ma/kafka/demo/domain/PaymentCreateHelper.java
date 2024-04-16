package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.annotations.Helper;
import neoxia.ma.kafka.demo.domain.mapper.PaymentDataMapper;
import neoxia.ma.kafka.demo.domain.ports.output.repository.PaymentRepository;

@Helper
@Slf4j
public class PaymentCreateHelper {

    private final PaymentRepository paymentRepository;


    private final PaymentDataMapper paymentDataMapper;


    public PaymentCreateHelper(PaymentRepository paymentRepository,
                               PaymentDataMapper paymentDataMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentDataMapper = paymentDataMapper;
    }


}
