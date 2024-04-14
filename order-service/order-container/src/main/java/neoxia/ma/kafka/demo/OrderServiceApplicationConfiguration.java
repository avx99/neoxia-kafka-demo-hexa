package neoxia.ma.kafka.demo;

import neoxia.ma.kafka.demo.annotations.ServiceInitializer;
import neoxia.ma.kafka.demo.domain.OrderDomainService;
import neoxia.ma.kafka.demo.domain.OrderDomainServiceImpl;
import org.springframework.context.annotation.Bean;

@ServiceInitializer
public class OrderServiceApplicationConfiguration {
    @Bean
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
