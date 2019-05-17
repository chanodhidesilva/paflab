package com.it17161466.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it17161466.supplier.login.model.User;
import com.it17161466.supplier.repository.SupplierRepository;

@Service
public class SupplierManagementService {

	@Autowired
	private SupplierRepository supplierRepository;
	public User createSupplier(User user) {
		
		return supplierRepository.save(user);
	}
	
	public Optional<User> getSupplierById(Integer supplierId) {
		
		return supplierRepository.findById(supplierId);
	}
	
	public Iterable<User> getAllSuppliers() {
		
		return supplierRepository.findAll();
	}

	public void deleteSupplier(Integer supplierId) {
		supplierRepository.deleteById(supplierId);
	}

	public User updateSupplierContact(Integer supplierId, String nsupplierContact) {
		User supplierFromDB = supplierRepository.findById(supplierId).get();
		supplierFromDB.setContactno(nsupplierContact);
		User updatedSupplier = supplierRepository.save(supplierFromDB);
		return updatedSupplier;
	}

	public List<User> findByUsername(String supplierUsername) {
		
		return supplierRepository.findByUsername(supplierUsername);
	}

	public List<User> getSupplierByLogin(String supplierUsername, String supplierPwd) {
		
		return supplierRepository.findByUser(supplierUsername, supplierPwd);
	}
	
   public String getSupplierByLogin1(String supplierUsername, String supplierPwd) {
		
		return supplierRepository.findByUser1(supplierUsername, supplierPwd);
	}


	

	


	

}
