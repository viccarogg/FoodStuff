package com.revature.foodstuff.controller;

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

import com.revature.foodstuff.model.Followers;
import com.revature.foodstuff.repository.AffiliationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

//@CrossOrigin(origins = "*")	

@RequestMapping("/Affiliations")
public class AffiliationController {
	@Autowired
	private AffiliationRepository affiliationRepository;

	@GetMapping("/followers")
	public List<Followers> getAllFollowers() {
		return affiliationRepository.findAll();
	}

	
//	  @GetMapping("/Affiliations/{id}") //for get method public
//	  ResponseEntity<Followers> getEmployeeById(@PathVariable(value = "id") Long
//	  employeeId) throws ResourceNotFoundException { Employee employee =
//	  affiliationRepository.findById(employeeId) .orElseThrow(() -> new
//	  ResourceNotFoundException("Employee not found for this id :: " +
//	  employeeId)); return ResponseEntity.ok().body(employee); }
//	  
//	  @PostMapping("/employees") // for post method public Employee
//	  createEmployee(@Valid @RequestBody Employee employee) { return
//	  affiliationRepository.save(employee); }
//	  
//	  @PutMapping("/employees/{id}") public ResponseEntity<Employee>
//	  updateEmployee(@PathVariable(value = "id") Long employeeId,
//	  
//	  @Valid @RequestBody Employee employeeDetails) throws
//	  ResourceNotFoundException { Employee employee =
//	  affiliationRepository.findById(employeeId) .orElseThrow(() -> new
//	  ResourceNotFoundException("Employee not found for this id :: " +
//	  employeeId)); employee.setEmailId(employeeDetails.getEmailId());
//	  employee.setLastName(employeeDetails.getLastName());
//	 employee.setFirstName(employeeDetails.getFirstName()); final Employee
//	  updatedEmployee = affiliationRepository.save(employee); return
//	  ResponseEntity.ok(updatedEmployee); }
//	  
//	  @DeleteMapping("/employees/{id}") public Map<String, Boolean>
//	  deleteEmployee(@PathVariable(value = "id") Long employeeId) throws
//	  ResourceNotFoundException { Employee employee =
//	  affiliationRepository.findById(employeeId) .orElseThrow(() -> new
//	  ResourceNotFoundException("Employee not found for this id :: " +
//	  employeeId)); affiliationRepository.delete(employee); Map<String, Boolean>
//	 response = new HashMap<>(); response.put("deleted", Boolean.TRUE); return
//	  response; }
	 
	
	
	
}