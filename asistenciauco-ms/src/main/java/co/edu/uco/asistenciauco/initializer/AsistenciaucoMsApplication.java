package co.edu.uco.asistenciauco.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "co.edu.uco.asistenciauco.application.outputport.repository")
@EntityScan(basePackages = "co.edu.uco.asistenciauco.application.outputport.entity")
@ComponentScan(basePackages = "co.edu.uco.asistenciauco")
public class AsistenciaucoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsistenciaucoMsApplication.class, args);
	}
}
