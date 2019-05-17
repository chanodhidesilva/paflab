package com.it17161466.supplier.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it17161466.supplier.login.model.User;
import com.it17161466.supplier.service.SupplierManagementService;


@RestController
@RequestMapping(value="/api/suppliers")
public class SupplierController {

	@Autowired
	private SupplierManagementService supplierManagementService;
	
	@PostMapping(value="/create")
	public User createSupplier(@RequestBody User user) {
		return supplierManagementService.createSupplier(user);
	}
	
	@GetMapping(value="/supplier/{supplierId}")
	public Optional<User> getSupplierById(@PathVariable("supplierId") Integer supplierId) {
		return supplierManagementService.getSupplierById(supplierId);
	}

	@GetMapping(value="/supplier/username/{supplierUsername}")
	public List<User> getSupplierByUsername(@PathVariable("supplierUsername") String supplierUsername) {
		return supplierManagementService.findByUsername(supplierUsername);
	}
	

	@GetMapping(value="/supplier/login/{supplierUsername}/{supplierPwd}")
	public List<User> getSupplierByLogin(@PathVariable("supplierUsername") String supplierUsername,@PathVariable("supplierPwd") String supplierPwd) {
		return supplierManagementService.getSupplierByLogin(supplierUsername,supplierPwd);
	}
	
	@GetMapping(value="/supplier/login1/{supplierUsername}/{supplierPwd}")
	public String getSupplierByLogin1(@PathVariable("supplierUsername") String supplierUsername,@PathVariable("supplierPwd") String supplierPwd) {
		return supplierManagementService.getSupplierByLogin1(supplierUsername,supplierPwd);
	}
	
	@GetMapping(value="/supplier/allsuppliers")
	public Iterable<User> getAllSuppliers(){
		
		return supplierManagementService.getAllSuppliers();
	}
	
	@DeleteMapping(value="/supplier/{supplierId}")
	public void deleteSupplier(@PathVariable("supplierId") Integer supplierId) {
		supplierManagementService.deleteSupplier(supplierId);
	}
	
	@PutMapping(value="/supplier/{supplierId}/{nsupplierContact:.+}")
	public User updateSupplierContact(@PathVariable("supplierId") Integer supplierId, @PathVariable("nsupplierContact") String nsupplierContact) {
		return supplierManagementService.updateSupplierContact(supplierId,nsupplierContact);
	}
}
