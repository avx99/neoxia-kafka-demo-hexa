package neoxia.ma.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"neoxia.ma.kafka.demo.data.access"})
@EntityScan(basePackages = {"neoxia.ma.kafka.demo.data.access"})
@SpringBootApplication(scanBasePackages = {"neoxia.ma.kafka.demo"})
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}