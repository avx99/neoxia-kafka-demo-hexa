package neoxia.ma.kafka.demo.domain;

import lombok.extern.slf4j.Slf4j;
import neoxia.ma.kafka.demo.annotations.Listener;
import neoxia.ma.kafka.demo.domain.dto.message.DeliveryResponse;
import neoxia.ma.kafka.demo.domain.ports.input.message.listener.payment.DeliveryResponseMessageListener;

@Listener
@Slf4j
public class DeliveryResponseMessageListenerImpl implements DeliveryResponseMessageListener {
    @Override
    public void deliveryCompleted(DeliveryResponse deliveryResponse) {

    }
}
