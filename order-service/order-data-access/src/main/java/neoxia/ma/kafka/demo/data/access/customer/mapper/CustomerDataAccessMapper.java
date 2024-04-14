package neoxia.ma.kafka.demo.data.access.customer.mapper;

import neoxia.ma.kafka.demo.annotations.Mapper;
import neoxia.ma.kafka.demo.data.access.customer.entity.CustomerEntity;
import neoxia.ma.kafka.demo.domain.entity.Customer;

@Mapper
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(customerEntity.getId().toString());
    }
}
