package com.github.mircoservice.shardingjdbc.sharding.databases.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 263434701950670170L;

    @Id
    @Column(name = "order_item_id")
    private long orderItemId;
    @Column(name = "order_id")
    private long orderId;
    @Column(name = "userId")
    private int userId;
    @Column(name = "status")
    private String status;

}
