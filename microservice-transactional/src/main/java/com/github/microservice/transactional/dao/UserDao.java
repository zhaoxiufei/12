package com.github.microservice.transactional.dao;

import com.github.microservice.transactional.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 14:08
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
