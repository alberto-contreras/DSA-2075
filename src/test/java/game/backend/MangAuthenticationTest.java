package game.backend;

import game.backend.DAO.SessionImpl;
import game.backend.models.Obj;
import game.backend.models.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
public class MangAuthenticationTest {

    MangAuthentication mauth;

    @Test //work!
    public void testAddUser() {
        mauth = new MangAuthenticationImpl();
        int res = mauth.addUser(new User("a", "b", "c"));
        Assert.assertEquals(0,res);
    }

    @Test //work!
    public void testGetUser() {
        mauth = new MangAuthenticationImpl();
        User aux = new User("Elon","tesla","Alb");
        int res = mauth.checkUser(aux);
        Assert.assertEquals(0,res);
        Assert.assertEquals("Elon Musk",aux.getName());
    }
    @Test //work!
    public void  testDeleteUser(){
        mauth = new MangAuthenticationImpl();
        User aux = new User("a","","");
        int res = mauth.deleteUser(aux);
        Assert.assertEquals(0,res);
    }
    @Test //work!
    public void testUpdateMoney(){
        mauth = new MangAuthenticationImpl();
        User aux = new User("Steve","","");
        aux.setMoney(2020);
        mauth.updateMoney(aux);
    }
    @Test //work!
    public void testUpdatePassword(){
        mauth = new MangAuthenticationImpl();
        User aux = new User("Steve","","");
        aux.setPassword("jobs2020");
        mauth.updatePassword(aux);
    }
    @Test //work!
    public void testUpdateUsername(){
        mauth = new MangAuthenticationImpl();
        User aux = new User("Alberto2020","","");
        //Here from frontend we will receive a complete user with all the fields
        //Here we need to work putting the ones that we want to work with
        aux.setID(19);
        int res = mauth.updateUsername(aux);

    }

}
