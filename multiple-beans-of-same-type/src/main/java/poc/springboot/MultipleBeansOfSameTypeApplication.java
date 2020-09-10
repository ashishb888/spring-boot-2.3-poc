package poc.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Person;

@Slf4j
@SpringBootApplication
public class MultipleBeansOfSameTypeApplication {

	@Autowired
	private Person abPerson;
	@Autowired
	private Person sbPerson;

	public static void main(String[] args) {
		SpringApplication.run(MultipleBeansOfSameTypeApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			log.debug("abPerson: " + abPerson);
			log.debug("sbPerson: " + sbPerson);
		};
	}
}
