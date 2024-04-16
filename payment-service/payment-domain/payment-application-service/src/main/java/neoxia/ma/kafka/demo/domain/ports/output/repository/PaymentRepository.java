package neoxia.ma.kafka.demo.domain.ports.output.repository;


import neoxia.ma.kafka.demo.domain.entity.Payment;

public interface PaymentRepository {

    Payment save(Payment payment);

}
