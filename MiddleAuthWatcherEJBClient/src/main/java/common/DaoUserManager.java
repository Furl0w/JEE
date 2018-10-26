package common;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Stateless
public class DaoUserManager {

    @PersistenceContext
    EntityManager em;

    private UserModel getUserByLogin(String login){
        try {
            return (UserModel) em.createQuery("from UserModel u where u.login = :login").setParameter("login", login).getSingleResult();
        }
        catch (NoResultException e) {
            System.out.println("No result");
            return null;
        }
    }

    public UserModel getUser(UserLogin user) {

        UserModel u = getUserByLogin(user.getLogin());

        if(u != null){
            return u;
        }

        UserModel empty = new UserModel();
        empty.setLogin(user.getLogin());
        empty.setRole(Role.None);
        return empty;
    }
}
