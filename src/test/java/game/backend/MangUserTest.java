package game.backend;

import game.backend.DAO.SessionImpl;
import game.backend.models.Obj;
import game.backend.models.Game;
import game.backend.models.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
public class MangUserTest {
    MangUser mauth1;
    @Test
    public void testAllObj(){
        mauth1 = new MangUserImpl();
        List <Obj> myObj = new LinkedList<>();
        myObj = mauth1.getAllMyObjects("14");
        Assert.assertEquals(0,myObj.size());
    }
    @Test
    public void testAllGame(){
        mauth1 = new MangUserImpl();
        List <Game> myGame = new LinkedList<>();
        myGame = mauth1.getAllMyGames("12");
        Assert.assertEquals(1,myGame.size());
    }
}
