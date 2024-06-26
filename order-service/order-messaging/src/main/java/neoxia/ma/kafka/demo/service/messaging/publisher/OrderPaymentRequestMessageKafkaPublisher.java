//package neoxia.ma.kafka.demo.service.messaging.publisher;
//
//import lombok.extern.slf4j.Slf4j;
//import neoxia.ma.kafka.demo.annotations.Publisher;
//import neoxia.ma.kafka.demo.domain.config.OrderServiceConfigData;
//import neoxia.ma.kafka.demo.domain.event.PaymentCreationEvent;
//import neoxia.ma.kafka.demo.domain.ports.output.message.publisher.payment.OrderPaymentRequestMessagePublisher;
//import neoxia.ma.kafka.demo.producer.KafkaMessageHelper;
//import neoxia.ma.kafka.demo.producer.service.KafkaProducer;
//import neoxia.ma.kafka.demo.service.messaging.mapper.OrderMessagingDataMapper;
//
//@Slf4j
//@Publisher
//public class OrderPaymentRequestMessageKafkaPublisher implements OrderPaymentRequestMessagePublisher {
//    private final OrderMessagingDataMapper orderMessagingDataMapper;
//    private final OrderServiceConfigData orderServiceConfigData;
//    private final KafkaProducer<String, String> kafkaProducer; // TODO replace second string by model we want to send
//    private final KafkaMessageHelper orderKafkaMessageHelper;
//
//    public OrderPaymentRequestMessageKafkaPublisher(OrderMessagingDataMapper orderMessagingDataMapper, OrderServiceConfigData orderServiceConfigData, KafkaProducer<String, String> kafkaProducer, KafkaMessageHelper orderKafkaMessageHelper) {
//        this.orderMessagingDataMapper = orderMessagingDataMapper;
//        this.orderServiceConfigData = orderServiceConfigData;
//        this.kafkaProducer = kafkaProducer;
//        this.orderKafkaMessageHelper = orderKafkaMessageHelper;
//    }
//    @Override
//    public void publish(PaymentCreationEvent domainEvent) {
////        var orderId = domainEvent.getOrder().getId().getValue().toString();
////        log.info("Received OrderDeliveryEvent for order id: {}", orderId);
////        try {
////            var model = orderMessagingDataMapper.eventToModel(domainEvent);
////
////            kafkaProducer.send(orderServiceConfigData.getPaymentRequestTopicName(),
////                    orderId,
////                    model,
////                    orderKafkaMessageHelper
////                            .getKafkaCallback(orderServiceConfigData.getDeliveryResponseTopicName(),
////                                    model,
////                                    orderId,
////                                    "PaymentRequestAvroModel"));
////
////            log.info("order model sent to Kafka for order id: {}", model.getOrderId());
////        } catch (Exception e) {
////            log.error("Error while sending order model message" +
////                    " to kafka with order id: {}, error: {}", orderId, e.getMessage());
////        }
//    }
//}
