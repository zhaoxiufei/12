package com.github.microservice.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * 车主运单相关接口
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019/12/25 下午12:51
 */
@SpringBootApplication
public class StatemachineApplication implements CommandLineRunner {
    @Autowired
    private StateMachine<States, Events> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(StatemachineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        System.out.println("------");
        stateMachine.sendEvent(Events.ToB);
        System.out.println("------");
        stateMachine.sendEvent(Events.ToC);
        System.out.println("------");
        stateMachine.sendEvent(Events.ToD);
        System.out.println("------");
        stateMachine.sendEvent(Events.ToA);
        stateMachine.stop();
    }
}
