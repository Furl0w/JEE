package rest.impl;

import common.UserLogin;
import rest.ILoginService;
import common.LoginResponse;
import fr.cpe.project.ejbModule.MessageReceiverSyncLocal;
import fr.cpe.project.ejbModule.MessageSenderLocal;

import javax.inject.Inject;

public class LoginServiceImpl implements ILoginService {
    @Override
    public LoginResponse doPost(UserLogin user) {
        sender.sendMessage(user);
        return receiver.receiveMessage();
    }

    @Inject
    MessageReceiverSyncLocal receiver;

    @Inject
    MessageSenderLocal sender;

}
