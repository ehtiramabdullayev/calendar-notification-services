import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
@ComponentScan("com.notificationservices")
@SpringBootApplication
public class NotificationServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServicesApplication.class, args);

    }
}
