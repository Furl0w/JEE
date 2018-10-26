package fr.cpe.project.ejbModule.ejb;

import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import common.Role;
import common.UserLogin;
import common.UserModel;
import fr.cpe.project.ejbModule.MessageSenderQueueLocal;
import fr.cpe.project.ejbModule.model.DataContainer;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "javax.jms.Topic"),
                @ActivationConfigProperty(
                        propertyName = "destination",
                        propertyValue = "java:/jms/watcherAuthJMS")
        })
public class AuthWatcherMsgDrivenEJB implements MessageListener {
    @Inject
    private DataContainer dataContainer;

    @EJB
    MessageSenderQueueLocal sender;


    public AuthWatcherMsgDrivenEJB() { }

    public void onMessage(Message message) {
        try {
            System.out.println(message);
            if (message instanceof TextMessage) {
                System.out.println("Topic: I received a TextMessage at " + new Date());
                TextMessage msg = (TextMessage) message;
                System.out.println("Message is : " + msg.getText());

            } else if (message instanceof ObjectMessage) {
                System.out.println("Topic: I received an ObjectMessage at "
                        + new Date());
                ObjectMessage msg = (ObjectMessage) message;

                if( msg.getObject() instanceof UserLogin){
                    UserLogin user=(UserLogin) msg.getObject();

                    System.out.println("User Details: ");
                    System.out.println("login:"+user.getLogin());
                    System.out.println("pwd:"+user.getPwd());

                    UserModel userFromDB=dataContainer.checkUser(user);
                    sender.sendMessage(userFromDB);
                }
            } else {
                System.out.println("Not valid message for this Queue MDB");
            }
        } catch (JMSException e){
            e.printStackTrace();
        }
    }
}