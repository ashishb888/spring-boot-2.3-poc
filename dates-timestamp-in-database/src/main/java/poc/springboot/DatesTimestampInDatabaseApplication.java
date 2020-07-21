package poc.springboot;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Employee;
import poc.springboot.repos.EmployeeRepository;

@Slf4j
@SpringBootApplication
public class DatesTimestampInDatabaseApplication {

	@Autowired
	private EmployeeRepository er;

	public static void main(String[] args) {
		SpringApplication.run(DatesTimestampInDatabaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			log.debug("commandLineRunner sevice");

			DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			long millis = System.currentTimeMillis();

			er.save(new Employee(1, "A", new Date(millis), new Timestamp(millis)));
			er.save(new Employee(2, "B", new Date(millis), new Timestamp(millis)));
			er.save(new Employee(3, "C", new Date(millis), new Timestamp(millis)));
			er.save(new Employee(4, "C", new Date(millis), Timestamp.valueOf(timestampFormatter
					.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault())))));

			er.findAll().forEach(e -> {
				log.debug("e: " + e);
			});
		};
	}
}
