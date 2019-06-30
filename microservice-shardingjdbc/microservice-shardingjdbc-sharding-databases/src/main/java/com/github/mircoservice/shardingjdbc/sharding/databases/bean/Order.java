package com.github.mircoservice.shardingjdbc.sharding.databases.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 661434701950670670L;
    @Id
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "status")
    private String status;

}
