package fr.cpe.project.ejbModule;

import common.UserLogin;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Topic;

@Stateless
@LocalBean
public class MessageSender implements MessageSenderLocal {
    @Inject
    JMSContext context;
    @Resource(mappedName = "java:/jms/watcherAuthJMS")
    Topic topic;

    public void sendMessage(String message) {
        context.createProducer()
                .send(topic, message);
    }

    @Override
    public void sendMessage(UserLogin user) {
        System.out.println(user);
        Message message =context.createObjectMessage(user);
        context.createProducer().send(topic, message);
    }
}