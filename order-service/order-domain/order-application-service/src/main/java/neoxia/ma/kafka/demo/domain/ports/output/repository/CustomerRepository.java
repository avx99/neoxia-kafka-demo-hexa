package neoxia.ma.kafka.demo.domain.ports.output.repository;

import neoxia.ma.kafka.demo.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<Customer> findCustomer(UUID customerId);
}
