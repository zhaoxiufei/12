package com.github.microservice.statemachine;

import java.util.EnumSet;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

/**
 * 完成状态机的配置，包括：（1）状态机的初始状态和所有状态；（2）状态之间的转移规则
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates().initial(States.A).states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
        transitions
            .withExternal()
            .source(States.A).target(States.B)
            .event(Events.ToB).action(customerA2B())
            .and()
            .withExternal()
            .source(States.B).target(States.C)
            .event(Events.ToC).action(customerB2C())
            .and()
            .withExternal()
            .source(States.C).target(States.D)
            .event(Events.ToD).action(customerC2D())
            .and()
            .withExternal()
            .source(States.D).target(States.A)
            .event(Events.ToA).action(customerD2A());
    }
    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
        throws Exception {
        config.withConfiguration().machineId("stateMachine");
    }

    public Action<States, Events> customerA2B() {
        return context -> System.out.println("A->B");
    }

    public Action<States, Events> customerB2C() {
        return context -> System.out.println("B->C");
    }

    public Action<States, Events> customerC2D() {
        return context -> System.out.println("C->D");
    }

    public Action<States, Events> customerD2A() {
        return context -> System.out.println("D->A");
    }
}
