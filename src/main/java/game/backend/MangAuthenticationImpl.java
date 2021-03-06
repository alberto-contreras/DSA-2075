package game.backend;
import game.backend.*;
import game.backend.DAO.*;
import game.backend.models.User;
import org.apache.log4j.Logger;
import org.omg.CORBA.UserException;

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
    public int deleteUser(User u){
        Session session = null;
        UserDAO session1 = null;
        try {
            session = FactorySession.openSession();
            session1 = FactorySession.openUserDAO();
            User a =  session1.getUserByUsername(u,"username");// Here we get the user from the database from username
            if (a.getUsername().equals(u.getUsername()))//So the user exist
            {
                //In order to delete the user we need to delete the reference and fields
                //from the other tables Obj and Game
                session1.deleteObjs(a); //Delete the user objects
                session1.deleteGames(a);//Delete the user games
                session1.deleteUser(a); //Delete the username after the check if exists or not
            }
            return 0; //The user exist and we DELETE it
        } catch (Exception e) {
            // LOG
            return 1;
        } finally {
            session.close();
        }
    }
    public int updateMoney(User u){
        UserDAO session = null;
        try {
            session = FactorySession.openUserDAO();
            session.updateUserMoney(u);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    public int updatePassword(User u){
        UserDAO session = null;
        try {
            session = FactorySession.openUserDAO();
            session.updateUserPassword(u);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    public int updateUsername(User u){
        UserDAO session = null;
        try {
            session = FactorySession.openUserDAO();
            session.updateUsername(u);
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }

}

