
package com.github.mircoservice.shardingjdbc.sharding.databases.dao;

import com.github.mircoservice.shardingjdbc.sharding.databases.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
