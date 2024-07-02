package com.hydroyura.springboot.kafka.msg.wrapper.demo.processors;

import com.hydroyura.springboot.kafka.msg.wrapper.consumer.services.MsgWrapperProcessor;
import com.hydroyura.springboot.kafka.msg.wrapper.demo.models.UpdateEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UpdateEmailProcessor implements MsgWrapperProcessor<UpdateEmail> {

    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Override
    public void processInternal(UpdateEmail event) {
        LOG.info("Processing msg ...");
        LOG.info("Updated email for userId = [{}] to value = [{}]", event.getId(), event.getUpdatedEmail());
    }

    @Override
    public Class<UpdateEmail> getEventClass() {
        return UpdateEmail.class;
    }

    @Override
    public String getEventType() {
        return "USER";
    }
}
