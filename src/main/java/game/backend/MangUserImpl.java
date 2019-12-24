package game.backend;

import game.backend.DAO.FactorySession;
import game.backend.DAO.Session;
import game.backend.DAO.SessionImpl;
import game.backend.DAO.UserDAO;
import game.backend.models.Game;
import game.backend.models.Obj;
import game.backend.models.User;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class MangUserImpl implements MangUser {
    private Logger logger = Logger.getLogger(SessionImpl.class);
    @Override
    public List<Obj> getAllMyObjects(String idPlayer) {
        UserDAO session1 = null;
        List <Obj> myObj = new LinkedList<>();
        try {
            session1 = FactorySession.openUserDAO();
            myObj = session1.getAllObj(idPlayer);
            logger.debug("Final size of myObj List "+ myObj.size());
            return myObj;//ALL OKEY WE CAN GET THE LIST FROM myObj

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myObj;
    }

    @Override
    public List<Game> getAllMyGames(String idPlayer) {
        UserDAO session1 = null;
        List <Game> myGame = new LinkedList<>();
        try {
            session1 = FactorySession.openUserDAO();
            myGame = session1.getAllGame(idPlayer);
            logger.debug("Final size of myGame List "+ myGame.size());
            return myGame;//ALL OKEY WE CAN GET THE LIST FROM myObj

        } catch (Exception e) {
            e.printStackTrace();
        }
        return myGame;
    }
}
