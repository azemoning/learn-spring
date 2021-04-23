package dev.azemoning.HelloSpring;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HelloSpringApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);


		String getUserDetailsUrl = "https://reqres.in/api/users/2";
		String getPagedUsersUrl = "https://reqres.in/api/users?page=2";
		String addNewUserUrl = "https://reqres.in/api/users";
		String updateUserUrl = "https://reqres.in/api/users/{id}";

		// Get user details
		String getUserDetailsResponse = restTemplate.getForObject(getUserDetailsUrl, String.class);
		JsonNode getUserDetailsResult = objectMapper.readTree(getUserDetailsResponse);
		System.out.println(objectMapper.writeValueAsString(getUserDetailsResult));

		// Get paged users
		String getPagedUsersResponse = restTemplate.getForObject(getPagedUsersUrl, String.class);
		JsonNode getPagedUsersResult = objectMapper.readTree(getPagedUsersResponse);
		System.out.println(objectMapper.writeValueAsString(getPagedUsersResult));

		// Add new user
		Users newUser = new Users("Upi", "Sales");
		String addNewUserResponse = restTemplate.postForObject(addNewUserUrl, newUser, String.class);
		JsonNode addNewUserResult = objectMapper.readTree(addNewUserResponse);
		System.out.println("Add new user:");
		System.out.println(addNewUserResult);

		// Update user
		String id = "2";
		HttpEntity<Users> updatedUser = new HttpEntity<Users>(new Users("Upi", "CEO"));
		ResponseEntity<String> updatedUserResponse = restTemplate.exchange(updateUserUrl,
				HttpMethod.PUT, updatedUser, String.class, id);
		String updatedUserResult = updatedUserResponse.getBody();
		System.out.println("Update user with id 2");
		System.out.println(updatedUserResult);
	}
}

@Getter
class Users {
	private String name;
	private String job;

	public Users(String name, String job) {
		this.name = name;
		this.job = job;
	}
}
