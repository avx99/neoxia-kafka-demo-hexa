package neoxia.ma.kafka.domain.event.publisher;


import neoxia.ma.kafka.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
