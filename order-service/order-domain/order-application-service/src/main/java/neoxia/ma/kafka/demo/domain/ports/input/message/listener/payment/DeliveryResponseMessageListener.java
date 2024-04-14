package neoxia.ma.kafka.demo.domain.ports.input.message.listener.payment;

import neoxia.ma.kafka.demo.domain.dto.message.DeliveryResponse;

public interface DeliveryResponseMessageListener {
    void deliveryCompleted(DeliveryResponse deliveryResponse);
}
