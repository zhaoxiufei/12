package com.github.microservice.shardingjdbc.masterslave.service;

import com.github.microservice.shardingjdbc.masterslave.bean.User;
import com.github.microservice.shardingjdbc.masterslave.dao.UserDao;
import org.apache.shardingsphere.api.hint.HintManager;
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

    /**
     * 插入走主库
     */
    @Transactional(rollbackFor = Exception.class)
    public void save() {
        userDao.save(new User().setName("张三").setPassword("123456"));
    }

    /**
     * 查询走从库
     */
    public void find() {
        userDao.findAll(Example.of(new User().setName("张三")));
    }


    /**
     * 强制查询走主库
     */
    public void findMaster() {
        HintManager.clear();//一定要先清理，防御编程
        HintManager.getInstance().setMasterRouteOnly();//设置走主库
        userDao.findAll(Example.of(new User().setName("张三")));
    }
}
