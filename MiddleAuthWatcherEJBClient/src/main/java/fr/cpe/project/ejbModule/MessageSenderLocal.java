package fr.cpe.project.ejbModule;


import common.UserLogin;

import javax.ejb.Local;

@Local
public interface MessageSenderLocal {
    void sendMessage(String message);
    void sendMessage(UserLogin user);
}
