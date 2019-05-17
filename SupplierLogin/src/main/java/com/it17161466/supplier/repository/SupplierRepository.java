package com.it17161466.supplier.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.it17161466.supplier.login.model.User;

@Repository
public interface SupplierRepository extends CrudRepository<User, Integer>,SupplierCustomRepository  {

}
