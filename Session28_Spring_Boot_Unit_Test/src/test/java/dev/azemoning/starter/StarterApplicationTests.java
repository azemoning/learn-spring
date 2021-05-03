package dev.azemoning.starter;

import dev.azemoning.starter.model.Product;
import dev.azemoning.starter.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@SpringBootTest
class StarterApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Order(1)
	@DisplayName("Should add a product")
	void shouldAddProduct() {
		RestTemplate restTemplate = new RestTemplate();
		String addProductUrl = "http://localhost:8080/api/v1/product";
		Product product = new Product("Piring", 10);
		assertThat(restTemplate.postForObject(addProductUrl, product, String.class),
				containsString("Piring"));
	}

	@Test
	@Order(2)
	@DisplayName("Should delete a product")
	void shouldDeleteProduct() {
		RestTemplate restTemplate = new RestTemplate();
		String deleteProductUrl = "http://localhost:8080/api/v1/product";
		Product product = productRepository.getOne(1L);
		productRepository.delete(product);
		assertThat(restTemplate.getForObject(deleteProductUrl, String.class), is("[]"));
	}

}
