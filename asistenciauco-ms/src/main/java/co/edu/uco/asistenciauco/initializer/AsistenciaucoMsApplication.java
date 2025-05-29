package co.edu.uco.asistenciauco.initializer;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"co.edu.uco.asistenciauco.application.outputport.entity"})
@EnableJpaRepositories(basePackages = {"co.edu.uco.asistenciauco.application.outputport.repository"})
public class AsistenciaucoMsApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().directory("./asistenciauco-ms").load();

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(AsistenciaucoMsApplication.class, args);
	}
}
