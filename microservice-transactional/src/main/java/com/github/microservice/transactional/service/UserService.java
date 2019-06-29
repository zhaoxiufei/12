package com.github.microservice.transactional.service;

import com.github.microservice.transactional.bean.User;
import com.github.microservice.transactional.dao.UserDao;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Autowired
    private RoleService roleService;

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        //会被回滚
        saveDB("张三");
        //不会被回滚
        ((UserService) (AopContext.currentProxy())).save2();
        //noinspection NumericOverflow,divzero,unused
        int iii = 1 / 0;
    }

    private void saveDB(String name) {
        userDao.save(new User().setName(name).setPassword("123456"));
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void save2() {
        saveDB("李四");
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void save3() {
        //回滚
        roleService.save();
        //不会回滚，注解生效
        ((UserService) (AopContext.currentProxy())).save2();
        //noinspection NumericOverflow,divzero,unused
        int iii = 1 / 0;
    }


    public void save4() {
        //不会被回滚,事务不生效，本类互相调用，注解不生效
        save2();
        //noinspection NumericOverflow,divzero,unused
        int iii = 1 / 0;
    }

    public void save5() {
        //不会被回滚，注解生效
        ((UserService) (AopContext.currentProxy())).save2();
        //noinspection NumericOverflow,divzero,unused
        int iii = 1 / 0;
    }
}
