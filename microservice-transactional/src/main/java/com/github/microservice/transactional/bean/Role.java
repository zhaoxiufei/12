package com.github.microservice.transactional.bean;

import lombok.Data;

import javax.persistence.*;


/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 14:26
 */
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32)
    private String name;
    @Column(length = 64)
    private String description;
}
