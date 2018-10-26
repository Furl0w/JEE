package fr.cpe.project.ejbModule;

import common.LoginResponse;


import javax.ejb.Local;

@Local
public interface MessageReceiverSyncLocal {

    LoginResponse receiveMessage();
}
