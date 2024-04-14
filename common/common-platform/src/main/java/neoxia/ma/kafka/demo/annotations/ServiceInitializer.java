package neoxia.ma.kafka.demo.annotations;

import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;


/**
 * Indicates that the annotated class is a service initializer configuration, used to specify
 * which service implementation to use within an application. Service initializer configurations
 * provide a way to configure the dependency injection container with the appropriate service
 * implementations.
 * <p>
 * This annotation can be used to mark service initializer configurations for documentation and
 * runtime processing. When applied to a class, it allows for easier identification and
 * categorization of service initialization components within a software system.
 * <p>
 * Example:
 * <pre>
 *     &#064;ServiceInitializer
 *     public class ServiceConfiguration {
 *       // Configuration methods to specify service implementations:
 *        {@code @Bean}
 *        public OrderDomainService orderDomainService() {
 *            return new OrderDomainServiceImpl();
 *        }
 *     }
 * </pre>
 * <p>
 * This annotation is typically used in conjunction with Spring Framework's configuration mechanism
 * to specify which service implementation to use for dependency injection.
 * <p>
 * Note: This annotation is meta-annotated with Spring's {@code @Configuration} annotation to
 * enable automatic detection and registration of service initializer configurations.
 * <p>
 * <b>Retention Policy:</b> {@code RUNTIME}
 * <b>Target:</b> {@code TYPE}
 * <b>Documented:</b> Yes
 * <b>Inherited:</b> No
 * <b>Thread Safety:</b> This annotation is not inherently thread-safe. It is the responsibility
 * of the user to ensure that the annotated classes and their usage are thread-safe.
 *
 * @see org.springframework.context.annotation.Configuration
 * @see java.lang.annotation.Documented
 * @see java.lang.annotation.ElementType
 * @see java.lang.annotation.RetentionPolicy
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
public @interface ServiceInitializer {
}
