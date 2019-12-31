package game.backend;
import game.backend.DAO.SessionImpl;
import game.backend.models.Obj;
import game.backend.models.User;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class MangShopTest {
    MangShop mangShop;
    @Test
    public void testAddShopList() {
        mangShop = new MangShopImpl();
        List<Obj> myList = new LinkedList<Obj>();
        Obj exampleObj = new Obj("14","o2",0,10,1,100);
        Obj exampleObj1 = new Obj("14","o2",0,10,1,100);
        myList.add(exampleObj);
        myList.add(exampleObj1);
        int res = mangShop.addPurchase(myList);
        Assert.assertEquals(0,res);


    }
}
