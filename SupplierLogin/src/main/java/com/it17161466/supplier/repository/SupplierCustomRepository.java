package com.it17161466.supplier.repository;

import java.util.List;


import com.it17161466.supplier.login.model.User;

public interface SupplierCustomRepository {
	
	 
	 List<User> findByUsername(String supplierUsername);
	 
	 List<User> findByUser(String supplierUsername,String supplierPwd);
	 String findByUser1(String supplierUsername,String supplierPwd);
}
