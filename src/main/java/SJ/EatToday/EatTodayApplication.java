package SJ.EatToday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"SJ.EatToday.domain.Weather_Var"})
public class EatTodayApplication {


	public static void main(String[] args) {
		SpringApplication.run(EatTodayApplication.class, args);
	}

}
