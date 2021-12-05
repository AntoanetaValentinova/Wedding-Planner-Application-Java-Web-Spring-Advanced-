package bg.softuni.weedinfplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeedinfPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeedinfPlannerApplication.class, args);
    }

}
