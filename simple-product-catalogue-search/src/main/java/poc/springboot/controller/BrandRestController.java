package poc.springboot.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import poc.springboot.domain.Brand;
import poc.springboot.repos.BrandRepository;

@Slf4j
@RequestMapping("/brands")
@RestController
public class BrandRestController {

	@Autowired
	private BrandRepository br;

	@GetMapping
	public Iterable<Brand> findAll() {
		br.findAll().forEach(r -> {
			log.debug("r: " + r);
		});
		return br.findAll();
	}

	@GetMapping("/{id}")
	public Brand findById(@PathVariable long id) {
		return br.findById(id).orElseThrow(NoSuchElementException::new);
	}
}
