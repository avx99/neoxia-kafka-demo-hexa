package neoxia.ma.kafka.domain.event;

public interface DomainEvent<T> {
    void fire();
}
