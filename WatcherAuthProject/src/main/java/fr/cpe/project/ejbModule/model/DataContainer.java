package fr.cpe.project.ejbModule.model;

import common.DaoUserManager;
import common.UserLogin;
import common.UserModel;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class DataContainer {

    @Inject
    private DaoUserManager dao;

    private List<UserModel> users;

    public DataContainer() {
    }

    @PostConstruct
    public void init() {
        users = new ArrayList<UserModel>();
        users.add(new UserModel());
    }

    public UserModel checkUser(UserLogin user) {

        return dao.getUser(user);

    }
}