package neoxia.ma.kafka.demo.service.messaging.listener;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.consumer.KafkaConsumer;
import neoxia.ma.kafka.demo.annotations.Listener;
import neoxia.ma.kafka.demo.domain.ports.input.message.listener.payment.DeliveryResponseMessageListener;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@Listener
@Slf4j
public class DeliveryResponseMessageKafkaListener implements KafkaConsumer<Object> {

    private final DeliveryResponseMessageListener deliveryResponseMessageListener;

    public DeliveryResponseMessageKafkaListener(DeliveryResponseMessageListener deliveryResponseMessageListener) {
        this.deliveryResponseMessageListener = deliveryResponseMessageListener;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.delivery-consumer-group-id}", topics = "${order-service.delivery-response-topic-name}")
    public void receive(List<Object> messages, List<String> keys, List<Integer> partitions, List<Long> offsets) {
        log.info("{} number of payment responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());
        deliveryResponseMessageListener.deliveryCompleted(null);
        log.info("Processing successful payment for order id: {}", 1);
    }
}
