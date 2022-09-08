package pe.com.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class PrjConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjConfigServiceApplication.class, args);
	}

}
