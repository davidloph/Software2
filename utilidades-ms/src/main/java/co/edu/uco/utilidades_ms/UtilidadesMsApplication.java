package co.edu.uco.utilidades_ms;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.edu.uco.utilidades_ms")
public class UtilidadesMsApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().directory("./utilidades-ms").load();

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(UtilidadesMsApplication.class, args);


	}

}
