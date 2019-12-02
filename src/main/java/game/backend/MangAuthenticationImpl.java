package game.backend;
import game.backend.*;
import game.backend.DAO.*;
import game.backend.models.User;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.sql.Connection;


public class MangAuthenticationImpl implements MangAuthentication {

    private static Logger logger = Logger.getLogger(MangAuthenticationImpl.class);

    public int addUser(User u) {
        //We make the querry to the DB
        Session session = null;
        UserDAO session1 = null;
        int employeeID = 0;
        try {
            session = FactorySession.openSession();
            session1 = FactorySession.openUserDAO();
            User aux =  session1.getUserByUsername(u,"username");

            if((aux.getID() == 0 )){ //If what we get from the database it's empty we insert it
                session.save(u);
                return 0;
        }
        }catch (Exception e) {
            // LOG
            return 1;
        } finally {
            session.close();
        }
        return 1;
    }

    public int checkUser(User u) { // check the user by username and return the user to show initial stats
        Session session = null;
        UserDAO session1 = null;
        try {
            session = FactorySession.openSession();
            session1 = FactorySession.openUserDAO();
            User a =  session1.getUserByUsername(u,"username");// Here we get the user from the database from username
            String username = a.getUsername();
            String password = a.getPassword();
            if((username.equals(u.getUsername()))&&(password.equals(u.getPassword()))){
                u.clone(a);
                //logger.info("FINAL USER:  "+u.toString());

            return 0; //The user exist and we send in the POST the user in the structure UserTO
            }
            return 1;
        } catch (Exception e) {
            // LOG
            return 1;
        } finally {
            session.close();
        }
    }
}

