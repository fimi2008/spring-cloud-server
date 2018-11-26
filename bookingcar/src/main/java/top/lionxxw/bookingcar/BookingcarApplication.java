package top.lionxxw.bookingcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookingcarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingcarApplication.class, args);
	}
}
