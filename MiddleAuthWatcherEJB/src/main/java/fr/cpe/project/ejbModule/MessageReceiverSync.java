package fr.cpe.project.ejbModule;

import common.LoginResponse;
import common.Role;
import common.UserLogin;
import common.UserModel;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.MessageConsumer;
import javax.jms.Queue;

@Stateless
@LocalBean
public class MessageReceiverSync implements MessageReceiverSyncLocal {

    @Inject
    JMSContext context;
    @Resource(name = "java:/jms/queue/watcherqueue")    // On va injecte la queue déclarée sur le serveur via son nom JNDI
    private Queue queue;

    @Override
    public LoginResponse receiveMessage() {
        JMSConsumer consumer = context.createConsumer(queue);
        UserModel user =  consumer.receiveBody(UserModel.class);
        if(user != null) {
            Boolean validAuth = user.getRole() != Role.None;
            return new LoginResponse(user.getLogin(),validAuth,user.getRole());
        }else {
            return new LoginResponse("error",false,Role.None);
        }
    }
}
