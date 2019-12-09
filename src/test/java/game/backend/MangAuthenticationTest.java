package game.backend;

import game.backend.DAO.SessionImpl;
import game.backend.models.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class MangAuthenticationTest {
    MangAuthentication mauth;


    @Test
    public void testAddUser() {
        mauth = new MangAuthenticationImpl();
        int res = mauth.addUser(new User("a", "b", "c"));
        Assert.assertEquals(0,res);
    }

    @Test
    public void testGetUser() {
        mauth = new MangAuthenticationImpl();
        User aux = new User("Elon","tesla","Alb");
        int res = mauth.checkUser(aux);
        Assert.assertEquals(0,res);
        Assert.assertEquals("Elon Musk",aux.getName());
    }
    @Test
    public void  testDeleteUser(){
        mauth = new MangAuthenticationImpl();
        User aux = new User("a","","");
        int res = mauth.deleteUser(aux);
        Assert.assertEquals(0,res);
    }
}
