package com.tarnowski.crudspring;

import com.tarnowski.crudspring.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = CrudSpringApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrudSpringApplicationTests {


	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void testListAllCourses() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/api/courses",
				HttpMethod.GET, entity, String.class);

		assertNotNull(response.getBody());
	}

	@Test
	public void testCreateUser() {
		Course course = new Course();
		course.setName("TesteNome");
		course.setCategory("TesteCategoria");

		ResponseEntity<Course> postResponse = restTemplate.postForEntity(getRootUrl() + "/api/courses", course, Course.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}


}
