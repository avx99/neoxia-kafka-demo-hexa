package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.annotations.Listener;
import neoxia.ma.kafka.demo.domain.dto.message.PaymentResponse;
import neoxia.ma.kafka.demo.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;

@Listener
@Slf4j
public class PaymentResponseMessageListenerImpl implements PaymentResponseMessageListener {
    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {

    }
}
