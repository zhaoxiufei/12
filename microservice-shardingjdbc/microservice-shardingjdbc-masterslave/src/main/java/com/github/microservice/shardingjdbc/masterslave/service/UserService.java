package com.github.microservice.shardingjdbc.masterslave.service;

import com.github.microservice.shardingjdbc.masterslave.bean.User;
import com.github.microservice.shardingjdbc.masterslave.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 13:40
 */

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        userDao.save(new User().setName("张三").setPassword("123456"));
    }

    public void find() {
        userDao.findAll(Example.of(new User().setName("张三")));
    }
}
