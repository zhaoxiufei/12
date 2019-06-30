
package com.github.mircoservice.shardingjdbc.sharding.databases.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 263434701950670170L;
    @Id
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "assisted_query_pwd")
    private String assistedQueryPwd;

}
