package game.backend;

import game.backend.models.Obj;
import game.backend.models.User;
import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class MangShopImp implements MangShop {
    private static MangShop instance;
    protected List<Obj> objects;
    protected List<User> users;
    final static Logger logger = Logger.getLogger(MangShopImp.class);

    public MangShopImp() {
        this.objects = new LinkedList<>();
        this.users = new LinkedList<>();
    }

    public static MangShop getInstance() {
        if (instance==null) instance = new MangShopImp();
        return instance;
    }

    public void addObject(String objName, int objAttack, int objDefense, int price) {
        Obj object = new Obj(objName, objAttack, objDefense, price);
        logger.info(object+" añadido ");
        this.objects.add(object);
    }

    public int size() {
        int ret = this.objects.size();
        logger.info("size " + ret);
        return ret;
    }

    public List<Obj> allObjects(){
        List<Obj> objectList = new LinkedList<Obj>();
        objectList.addAll(this.objects);

        return objectList;
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
}