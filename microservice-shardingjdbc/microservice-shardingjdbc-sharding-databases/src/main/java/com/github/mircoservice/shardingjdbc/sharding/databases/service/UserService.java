package com.github.mircoservice.shardingjdbc.sharding.databases.service;

import com.github.mircoservice.shardingjdbc.sharding.databases.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserRepository userRepository;

    /**
     * 插入走主库
     */
    @Transactional(rollbackFor = Exception.class)
    public void save() {
    }
}
