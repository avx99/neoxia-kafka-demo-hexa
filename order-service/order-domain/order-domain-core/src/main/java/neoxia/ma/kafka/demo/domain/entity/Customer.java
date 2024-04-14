package neoxia.ma.kafka.demo.domain.entity;


import neoxia.ma.kafka.domain.entity.AggregateRoot;
import neoxia.ma.kafka.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    private final String fullname;


    public Customer(String fullname) {
        this.fullname = fullname;
    }

    public Customer(CustomerId customerId, String fullname) {
        this.fullname = fullname;
        super.setId(customerId);
    }

    private Customer(Builder builder) {
        super.setId(builder.customerId);
        fullname = builder.fullname;
    }

    public static final class Builder {
        private CustomerId customerId;
        private String fullname;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder fullname(String val) {
            fullname = val;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
