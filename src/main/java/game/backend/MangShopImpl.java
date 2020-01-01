package game.backend;

import game.backend.DAO.FactorySession;
import game.backend.DAO.Session;
import game.backend.DAO.UserDAO;
import game.backend.models.Obj;

import java.util.List;

public class MangShopImpl implements MangShop {
    /**
     *
     * @param myList for each object in the list we add it to the database
     * @return
     */
    @Override
    public int addPurchase(List<Obj> myList) {
        UserDAO session = null;
        session = FactorySession.openUserDAO();
        if(myList.size() == 0) {
            return 1;
        }
        else {
            for (int i = 0; i < myList.size(); i++) {
                Obj aux = myList.get(i);
                session.saveMyObj(aux);
            }
            return 0;
        }
    }
}
