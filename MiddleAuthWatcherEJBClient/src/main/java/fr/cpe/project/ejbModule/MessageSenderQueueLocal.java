package fr.cpe.project.ejbModule;

import common.UserModel;

public interface MessageSenderQueueLocal {

    void sendMessage(String message);
    void sendMessage(UserModel user);

}
