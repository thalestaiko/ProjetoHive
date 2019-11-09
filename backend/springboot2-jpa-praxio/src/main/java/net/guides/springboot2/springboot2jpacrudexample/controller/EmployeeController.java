package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Transportadora;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/trasportadora")
	public List<Transportadora> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/trasportadora/{id}")
	public ResponseEntity<Transportadora> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Transportadora employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/trasportadora")
	public Transportadora createEmployee(@Valid @RequestBody Transportadora employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/trasportadora/{id}")
	public ResponseEntity<Transportadora> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Transportadora employeeDetails) throws ResourceNotFoundException {
		Transportadora employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmail());
		employee.setNome(employeeDetails.getNome());
	  //employee.setEmail(employeeDetails.getEmail());
		employee.setTelefone(employeeDetails.getTelefone());
		employee.setCelular(employeeDetails.getCelular());
		employee.setWhatsapp(employeeDetails.getWhatsapp());
		employee.setCep(employeeDetails.getCep());
		employee.setEstado(employeeDetails.getEstado());
		employee.setCidade(employeeDetails.getCidade());
		employee.setBairro(employeeDetails.getBairro());
		employee.setRua(employeeDetails.getRua());
		employee.setNumero(employeeDetails.getNumero());
		
		final Transportadora updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/trasportadora/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Transportadora employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
