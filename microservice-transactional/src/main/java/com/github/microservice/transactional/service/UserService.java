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
        userDao.save(new User().setName("张三").setPassword("123456"));
        //会被回滚
        save2();
        //不会被回滚
        ((UserService) (AopContext.currentProxy())).save2();
        //noinspection NumericOverflow,divzero,unused
        int iii = 1 / 0;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void save2() {
        userDao.save(new User().setName("李四").setPassword("123456"));
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void save3() {
        roleService.save();//回滚
        //不会回滚
        ((UserService) (AopContext.currentProxy())).save2();
        //noinspection NumericOverflow,divzero,unused
        int iii = 1 / 0;
    }


}
