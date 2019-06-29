package com.github.microservice.shardingjdbc.masterslave.dao;

import com.github.microservice.shardingjdbc.masterslave.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 14:08
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
}
