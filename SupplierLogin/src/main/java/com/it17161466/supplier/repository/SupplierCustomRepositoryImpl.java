package com.it17161466.supplier.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.it17161466.supplier.login.model.User;

@Repository
@Transactional(readOnly = true)
public class SupplierCustomRepositoryImpl implements SupplierCustomRepository{

	@PersistenceContext
    EntityManager entityManager;
    @SuppressWarnings("unchecked")
	@Override
    public List<User> findByUsername(String supplierUsername) {
        Query query = entityManager.createNativeQuery("SELECT s.* FROM supplierdb.user as s " +
                "WHERE s.email LIKE ?", User.class);
        query.setParameter(1, supplierUsername + "%");
        return query.getResultList();
    }
    
	@SuppressWarnings("unchecked")
	@Override
    public List<User> findByUser(String supplierUsername,String supplierPwd) {
        Query query = entityManager.createNativeQuery("SELECT s.* FROM supplierdb.user as s " +
                "WHERE s.email=? and s.password=?", User.class);
        query.setParameter(1, supplierUsername);
        query.setParameter(2, supplierPwd);
        
        return query.getResultList();
        	
        
    }
	
	
	@Override
    public String findByUser1(String supplierUsername,String supplierPwd) {
		
		String s1= "Empty";
        Query query = entityManager.createNativeQuery("SELECT s.* FROM supplierdb.supplier as s " +
                "WHERE s.supplier_username=? and s.supplier_pwd=?", User.class);
        query.setParameter(1, supplierUsername);
        query.setParameter(2, supplierPwd);
        
        String s2= "Not Empty1";
        
        if(query.getResultList()!=null)
        	return s1;
        else
		   return s2;
        	
        
    }
	
}
