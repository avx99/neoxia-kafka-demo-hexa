package neoxia.ma.kafka.demo.domain.valueobject;


import neoxia.ma.kafka.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
