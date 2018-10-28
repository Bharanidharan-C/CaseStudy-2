package com.frosters.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.frosters.model.OrderLineItem;
import com.frosters.model.Orders;

@Repository
public interface LineItemRepository extends CrudRepository<OrderLineItem,Long> {

	void deleteByOrder(Orders order);
}
