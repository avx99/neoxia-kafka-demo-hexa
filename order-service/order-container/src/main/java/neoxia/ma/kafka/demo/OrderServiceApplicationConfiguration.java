package neoxia.ma.kafka.demo;

import neoxia.ma.kafka.demo.annotations.ServiceInitializer;
import neoxia.ma.kafka.demo.domain.PaymentDomainService;
import neoxia.ma.kafka.demo.domain.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;

@ServiceInitializer
public class OrderServiceApplicationConfiguration {
    @Bean
    public PaymentDomainService orderDomainService() {
        return new PaymentDomainServiceImpl();
    }
}
