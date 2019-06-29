package com.github.microservice.shardingjdbc.masterslave.service;

import com.github.microservice.shardingjdbc.masterslave.bean.Role;
import com.github.microservice.shardingjdbc.masterslave.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 13:40
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * Transactional 只能应用到 public 方法才有效
     *
     * @see org.springframework.data.repository.core.support.AbstractFallbackTransactionAttributeSource.computeTransactionAttribute
     * <p>
     * name	当在配置文件中有多个 TransactionManager , 可以用该属性指定选择哪个事务管理器。
     * propagation	事务的传播行为，默认值为 REQUIRED。
     * isolation	事务的隔离度，默认值采用 DEFAULT。
     * timeout	事务的超时时间，默认值为-1。如果超过该时间限制但事务还没有完成，则自动回滚事务。
     * read-only	指定事务是否为只读事务，默认值为 false；为了忽略那些不需要事务的方法，比如读取数据，可以设置 read-only 为 true。
     * 【注意是一次执行多次查询来统计某些信息，这时为了保证数据整体的一致性，要用只读事务】
     * rollback-for	用于指定能够触发事务回滚的异常类型，如果有多个异常类型需要指定，各类型之间可以通过逗号分隔。
     * no-rollback- for	抛出 no-rollback-for 指定的异常类型，不回滚事务。
     * <p>
     * 事务传播行为类型
     * <p>
     * PROPAGATION_REQUIRED 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
     * PROPAGATION_SUPPORTS 支持当前事务，如果当前没有事务，就以非事务方式执行。
     * PROPAGATION_MANDATORY 使用当前的事务，如果当前没有事务，就抛出异常。
     * PROPAGATION_REQUIRES_NEW 新建事务，如果当前存在事务，把当前事务挂起。
     * PROPAGATION_NOT_SUPPORTED 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     * PROPAGATION_NEVER 以非事务方式执行，如果当前存在事务，则抛出异常。
     * PROPAGATION_NESTED 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     */
    @Transactional(rollbackFor = Exception.class)
    public void save() {
        roleDao.save(new Role().setName("管理员").setDescription("只有一个"));
    }
}
