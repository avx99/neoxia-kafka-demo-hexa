package neoxia.ma.kafka.demo.domain.ports.input.message.listener.payment;


import neoxia.ma.kafka.demo.domain.entity.Payment;

public interface PaymentResponseMessageListener {

    void completePayment(Payment payment);

}
