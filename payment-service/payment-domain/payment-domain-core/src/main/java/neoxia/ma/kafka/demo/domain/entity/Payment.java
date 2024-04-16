package neoxia.ma.kafka.demo.domain.entity;


import neoxia.ma.kafka.demo.domain.exception.PaymentDomainException;
import neoxia.ma.kafka.domain.entity.BaseEntity;
import neoxia.ma.kafka.domain.valueobject.CustomerId;
import neoxia.ma.kafka.domain.valueobject.Money;
import neoxia.ma.kafka.domain.valueobject.OrderId;
import neoxia.ma.kafka.domain.valueobject.PaymentId;


public class Payment extends BaseEntity<PaymentId> {
    private final CustomerId customerId;
    private final OrderId orderId;
    private final Money totalAmount;
    private final Money amount;


    public void validate() {
        if (!totalAmount.isGreaterThan(amount)) {
            throw new PaymentDomainException("can not pay order " + customerId.getValue().toString() + " since customer total amount is less then order amount !");
        }
    }

    public Payment(CustomerId customerId, OrderId orderId, Money totalAmount, Money amount) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.amount = amount;
    }


    private Payment(Builder builder) {
        super.setId(builder.id);
        customerId = builder.customerId;
        orderId = builder.orderId;
        totalAmount = builder.totalAmount;
        amount = builder.amount;
    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Money getTotalAmount() {
        return totalAmount;
    }

    public Money getAmount() {
        return amount;
    }


    public static final class Builder {
        private PaymentId id;
        private CustomerId customerId;
        private OrderId orderId;
        private Money totalAmount;
        private Money amount;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(PaymentId val) {
            id = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder orderId(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder totalAmount(Money val) {
            totalAmount = val;
            return this;
        }

        public Builder amount(Money val) {
            amount = val;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
