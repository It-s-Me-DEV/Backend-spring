package ITisme.group.chap06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Chap06Application {
    public static void main(String[] args){
        SpringApplication.run(Chap06Application.class, args);
    }
}
