package com.hydroyura.springboot.kafka.msg.wrapper.demo;

import com.hydroyura.springboot.kafka.msg.wrapper.demo.models.CreateUser;
import com.hydroyura.springboot.kafka.msg.wrapper.demo.models.UpdateEmail;
import com.hydroyura.springboot.kafka.msg.wrapper.producer.services.MsgWrapperProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TestController {

    @Value("${kafka-topic:topic-name}")
    private String topic;

    @Autowired
    private MsgWrapperProducer producer;

    private String USER_CREATE_RESPONSE =
            "New user with values: name = [%s], surname = [%s], email = [%s] was sent to topic = [%s]";
    private String USER_UPDATE_EMAIL_RESPONSE =
            "Update email event for userId = [%s] and value = [%s]  was sent to topic = [%s]";


    @GetMapping(value = "/create-user")
    public String createUser(
            @RequestParam Optional<String> surname,
            @RequestParam Optional<String> name,
            @RequestParam Optional<String> email) {
        CreateUser user = new CreateUser()
            .setEmail(email.orElse("default@email.com"))
            .setName(name.orElse("default-name"))
            .setSurname(surname.orElse("default-surname"));
        producer.sendEvent(topic, user, "USER");
        return USER_CREATE_RESPONSE.formatted(user.getName(), user.getSurname(), user.getEmail(), topic);
    }

    @GetMapping(value = "/update-email")
    public String updateEmail(
            @RequestParam Optional<Long> id,
            @RequestParam Optional<String> email) {
        UpdateEmail updateEmail = new UpdateEmail()
            .setId(id.orElse(100L))
            .setUpdatedEmail(email.orElse("new_default@email.com"));
        producer.sendEvent(topic, updateEmail, "USER");
        return USER_UPDATE_EMAIL_RESPONSE.formatted(updateEmail.getId(), updateEmail.getUpdatedEmail(), topic);
    }

}
