package fr.cpe.project.ejbModule.model;

import common.Role;
import common.UserLogin;
import common.UserModel;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class DataContainer {

    private List<UserModel> users;

    public DataContainer() { }

    @PostConstruct
    public void init(){
        users = new ArrayList<UserModel>();
        users.add(new UserModel());
    }

    public UserModel checkUser(UserLogin user) {

        for(UserModel u : users){
            if(u.getLogin() == user.getLogin() && u.getPwd() == user.getPwd()){
                return u;
            }
        }
        UserModel empty = new UserModel();
        empty.setRole(Role.None);
        return empty;
    }

}
