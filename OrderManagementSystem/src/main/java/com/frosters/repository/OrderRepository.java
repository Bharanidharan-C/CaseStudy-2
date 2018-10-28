package com.frosters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.frosters.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders,Long>{
	

	public  List<Orders> findByCustomerId(Long customerId);
}
