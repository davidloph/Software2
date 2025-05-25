package co.edu.uco.asistenciauco.initializer;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AsistenciaucoMsApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().directory("asistenciauco-ms").load();

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(AsistenciaucoMsApplication.class, args);
	}
}
