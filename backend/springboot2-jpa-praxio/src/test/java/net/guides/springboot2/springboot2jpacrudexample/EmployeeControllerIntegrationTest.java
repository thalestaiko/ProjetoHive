package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import net.guides.springboot2.springboot2jpacrudexample.model.Transportadora;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/transportadora",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmployeeById() {
		Transportadora employee = restTemplate.getForObject(getRootUrl() + "/employees/1", Transportadora.class);
		System.out.println(employee.getNome());
		assertNotNull(employee);
	}

	@Test
	public void testCreateEmployee() {
		Transportadora employee = new Transportadora();
		employee.setEmailId("admin@gmail.com");
		employee.setNome("admin");
		

		ResponseEntity<Transportadora> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", employee, Transportadora.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateEmployee() {
		int id = 1;
		Transportadora employee = restTemplate.getForObject(getRootUrl() + "/transportadora/" + id, Transportadora.class);
		employee.setNome("admin1");
		
		restTemplate.put(getRootUrl() + "/transportadora/" + id, employee);

		Transportadora updatedEmployee = restTemplate.getForObject(getRootUrl() + "/transportadora/" + id, Transportadora.class);
		assertNotNull(updatedEmployee);
	}

	@Test
	public void testDeleteEmployee() {
		int id = 2;
		Transportadora employee = restTemplate.getForObject(getRootUrl() + "/transportadora/" + id, Transportadora.class);
		assertNotNull(employee);

		restTemplate.delete(getRootUrl() + "/transportadora/" + id);

		try {
			employee = restTemplate.getForObject(getRootUrl() + "/transportadora/" + id, Transportadora.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
