package game.backend;

import game.backend.models.User;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class MangUserImp implements MangUser {
    private static MangUser instance;
    protected List<User> users;
    protected List<Object> objects;
    final static Logger logger = Logger.getLogger(MangUserImp.class);

    public MangUserImp() {

        this.users = new LinkedList<>();
        this.objects = new LinkedList<>();
    }

    public static MangUser getInstance() {
        if (instance==null) instance = new MangUserImp();
        return instance;
    }

    public void addUser(String userName, String password, String name) {
        User user = new User(userName, password, name);
        logger.info(user+" añadido ");
        this.users.add(user);
    }

    public int size() {
        int ret = this.users.size();
        logger.info("size " + ret);

        return ret;
    }

    public User getUserByUserName(String userName) {
        logger.info("getUser("+userName+")");

        for (User u: this.users) {
            if (u.getUsername().equals(userName)) {
                logger.info("getObject("+userName+"): "+u);
                return u;
            }
        }
        logger.warn("not found " + userName);
        return null;
    }

    public void addObjetWithUserName(String userName, String name, int defense, int attack, int price){
        logger.info("getUsuario("+userName+")");
        for(User user: this.users){
            if (user.getUsername().equals(userName)){
                logger.info("getObjeto("+userName+"): "+user);
                user.addObject(name, defense, attack, price);
            }
            else {
                logger.warn("not found " + userName);
            }
        }
    }

    public void addGamesWithUserName(String userName, String id, String data, int miDeaths, int kills, int level, int points){
        logger.info("getUsuario("+userName+")");
        for(User user: this.users){
            if (user.getUsername().equals(userName)){
                logger.info("getGame("+userName+"): "+user);
                user.addGame(id, data, miDeaths, kills, level, points);
            }
            else {
                logger.warn("not found " + userName);
            }
        }
    }
}
