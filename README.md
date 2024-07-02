Demo project for usage 
  1. kafka-producer-starter https://github.com/YuryKlimchuk/kafka-msg-wrapper-producer
  2. kafka-comsumer-starter https://github.com/YuryKlimchuk/kafka-msg-wrapper-consumer

1. Start kafka image: docker/docker-compose.yaml
2. Specify topic in in application.yaml: kafka-topic: DEFAULT_TOPIC
3. Use 2 two link for testing:
   - http://localhost:8080/update-email?id=666&email=new-email
   - http://localhost:8080/create-user?name=test-name&surname=test-sur-name&email=test-email
