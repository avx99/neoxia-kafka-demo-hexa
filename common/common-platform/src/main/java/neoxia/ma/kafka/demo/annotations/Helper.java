package neoxia.ma.kafka.demo.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Indicates that the annotated class is a helper class, providing utility methods or functions
 * to assist with specific tasks within an application. Helper classes often encapsulate
 * reusable logic or algorithms to enhance code modularity and maintainability.
 * <p>
 * This annotation can be used to identify helper classes for documentation and runtime processing.
 * When applied to a class, it allows for easier identification and categorization of helper
 * components within a software system.
 * <p>
 * Example:
 * <pre>
 *     &#064;Helper
 *     public class StringHelper {
 *         // Utility methods for string manipulation
 *     }
 * </pre>
 * <p>
 * This annotation is typically used in conjunction with Spring Framework's component scanning
 * mechanism to automatically detect and register helper classes as beans within the application
 * context.
 * <p>
 * Note: This annotation is meta-annotated with Spring's {@code @Component} annotation to
 * enable automatic detection and registration of helper classes as Spring beans.
 * <p>
 * <b>Retention Policy:</b> {@code RUNTIME}
 * <b>Target:</b> {@code TYPE}
 * <b>Documented:</b> Yes
 * <b>Inherited:</b> No
 * <b>Thread Safety:</b> This annotation is not inherently thread-safe. It is the responsibility
 * of the user to ensure that the annotated classes and their usage are thread-safe.
 *
 * @see org.springframework.stereotype.Component
 * @see java.lang.annotation.Documented
 * @see java.lang.annotation.ElementType
 * @see java.lang.annotation.RetentionPolicy
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Helper {
}
