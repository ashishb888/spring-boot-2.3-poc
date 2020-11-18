package poc.springboot;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Brand;
import poc.springboot.domain.Product;
import poc.springboot.repos.BrandRepository;

@Slf4j
@SpringBootApplication
public class SimpleProductCatalogueSearchApplication {

	@Autowired
	private BrandRepository br;

	public static void main(String[] args) {
		SpringApplication.run(SimpleProductCatalogueSearchApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			Brand b1 = new Brand("B1");
			Product p1 = new Product("p1", 10, b1);
			Product p2 = new Product("p2", 20, b1);
			Set<Product> s1 = new HashSet<>();
			s1.add(p1);
			s1.add(p2);
			b1.setProducts(s1);
			log.debug("b1:" + b1);
			br.save(b1);

			Brand b2 = new Brand("B2");
			Product p3 = new Product("p3", 1000, b2);
			Product p4 = new Product("p4", 2000, b2);
			Set<Product> s2 = new HashSet<>();
			s2.add(p3);
			s2.add(p4);
			b2.setProducts(s2);
			log.debug("b2:" + b2);
			br.save(b2);

			// b1.addProduct(p1);
			// b2.addProduct(p2);

		};
	}
}
