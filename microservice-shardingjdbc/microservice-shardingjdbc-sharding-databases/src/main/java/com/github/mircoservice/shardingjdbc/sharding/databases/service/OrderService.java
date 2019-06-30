package com.github.mircoservice.shardingjdbc.sharding.databases.service;

import com.github.mircoservice.shardingjdbc.sharding.databases.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 13:40
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

}
