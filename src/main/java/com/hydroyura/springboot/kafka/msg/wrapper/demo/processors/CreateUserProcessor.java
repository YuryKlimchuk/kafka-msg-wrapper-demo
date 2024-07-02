package com.hydroyura.springboot.kafka.msg.wrapper.demo.processors;

import com.hydroyura.springboot.kafka.msg.wrapper.consumer.services.MsgWrapperProcessor;
import com.hydroyura.springboot.kafka.msg.wrapper.demo.models.CreateUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateUserProcessor implements MsgWrapperProcessor<CreateUser> {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public void processInternal(CreateUser event) {
        LOG.info("Processing msg ...");
        LOG.info("Create new user: name = [{}], surname = [{}], email = [{}]", event.getName(), event.getSurname(), event.getEmail());
    }

    @Override
    public Class<CreateUser> getEventClass() {
        return CreateUser.class;
    }

    @Override
    public String getEventType() {
        return "USER";
    }
}
