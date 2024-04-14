package neoxia.ma.kafka.demo.domain.ports.input.message.listener.payment;


import neoxia.ma.kafka.demo.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

}
