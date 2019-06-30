
package com.github.mircoservice.shardingjdbc.sharding.databases.dao;

import com.github.mircoservice.shardingjdbc.sharding.databases.bean.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
