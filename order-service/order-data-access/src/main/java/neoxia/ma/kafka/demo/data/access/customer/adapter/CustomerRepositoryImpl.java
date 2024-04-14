package neoxia.ma.kafka.demo.data.access.customer.adapter;


import neoxia.ma.kafka.demo.annotations.Adapter;
import neoxia.ma.kafka.demo.data.access.customer.mapper.CustomerDataAccessMapper;
import neoxia.ma.kafka.demo.data.access.customer.repository.CustomerJpaRepository;
import neoxia.ma.kafka.demo.domain.entity.Customer;
import neoxia.ma.kafka.demo.domain.ports.output.repository.CustomerRepository;

import java.util.Optional;
import java.util.UUID;

@Adapter
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final CustomerDataAccessMapper customerDataAccessMapper;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository,
                                  CustomerDataAccessMapper customerDataAccessMapper) {
        this.customerJpaRepository = customerJpaRepository;
        this.customerDataAccessMapper = customerDataAccessMapper;
    }

    @Override
    public Optional<Customer> findCustomer(UUID customerId) {
        return customerJpaRepository.findById(customerId).map(customerDataAccessMapper::customerEntityToCustomer);
    }
}
