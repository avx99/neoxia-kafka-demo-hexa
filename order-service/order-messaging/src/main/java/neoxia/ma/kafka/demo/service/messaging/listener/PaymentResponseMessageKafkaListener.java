package neoxia.ma.kafka.demo.service.messaging.listener;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.consumer.KafkaConsumer;
import neoxia.ma.kafka.demo.annotations.Listener;
import neoxia.ma.kafka.demo.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@Listener
@Slf4j
public class PaymentResponseMessageKafkaListener implements KafkaConsumer<Object> {
    private final PaymentResponseMessageListener paymentResponseMessageListener;

    public PaymentResponseMessageKafkaListener(PaymentResponseMessageListener paymentResponseMessageListener) {
        this.paymentResponseMessageListener = paymentResponseMessageListener;
    }


    @Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}", topics = "${order-service.payment-response-topic-name}")
    public void receive(List<Object> messages, List<String> keys, List<Integer> partitions, List<Long> offsets) {
        log.info("{} number of payment responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());
        paymentResponseMessageListener.paymentCompleted(null);
        log.info("Processing successful payment for order id: {}", 1);

    }
}
