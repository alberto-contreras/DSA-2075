package game.backend.DAO;

import game.backend.models.Game;
import game.backend.models.Obj;
import game.backend.models.User;
import org.apache.log4j.Logger;
import org.eclipse.persistence.queries.ResultSetMappingQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UserDAOImpl implements UserDAO{

    private final Connection conn;

    private Logger logger = Logger.getLogger(SessionImpl.class);

    public UserDAOImpl(Connection conn) {
        this.conn = conn;
    }


    /**
     *  We search in the DB the user with the field and then in MangAuthenticationImpl we
     *  check if the password and username are the same in order to login
     * @param user
     * @param field
     * @return User that we are searching after the SELECT * FROM Users WHERE username = "user.getUsername"
     */

    @Override
    public  User getUserByUsername(User user, String field) {
        String selectQuery = QueryHelper.createQuerySELECT(user,field);
        logger.debug("Select User Query:"+ selectQuery);
        User returnUser = new User();
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            int i = 1;
            Object value = null;
            value = ObjectHelper.getter(user, field); //Here we get the username of the user that we put as parmeters
            pstm.setObject(i, value); //We set in the in the question symbol the value
            logger.debug("FINAL SELECT:"+pstm);
            ResultSet res =pstm.executeQuery(); // Execute the query in the database
            while(res.next()){
                returnUser.setUsername(res.getString("username"));//We fill the return User with
                returnUser.setPassword(res.getString("password"));//what we obtain from the DB
                returnUser.setName(res.getString("name"));
                returnUser.setID(res.getInt("ID"));
                returnUser.setAttack(res.getInt("attack"));
                returnUser.setDefense(res.getInt("defense"));
                returnUser.setHealthPoints(res.getInt("healthpoints"));
                returnUser.setMoney(res.getInt("money"));
                returnUser.setID(res.getInt("ID"));
            }
            //logger.debug("FINAL User to return:"+returnUser.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return returnUser;
    }
    @Override
    public void deleteUser(User user){

        String selectQuery = QueryHelper.createQueryDELETE(user,"username","password");
        //logger.debug("DELETE User Query:"+ selectQuery);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(selectQuery);
            Object value = null;
            int i = 1;
            value = ObjectHelper.getter(user, "username");//We get the value of the username
            pstm.setObject(i, value); //We set in the in the question symbol the value
            value = ObjectHelper.getter(user, "password");//We get the value of the password
            i=i+1;
            pstm.setObject(i, value);
            //logger.debug("FINAL DELETE:"+pstm);
            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateUserMoney (User entity){

        String updatequery = QueryHelper.createQueryUPDATE(entity, "money", "username");
        logger.debug("UPDATE User Query:"+ updatequery);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(updatequery);
            //Now we set the value in the question symbol
            pstm.setObject(1, entity.getMoney());
            pstm.setObject(2, entity.getUsername());
            pstm.executeUpdate();
            logger.debug("FINAL UPDATE Money :"+pstm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateUsername (User entity){

        String updatequery = QueryHelper.createQueryUPDATE(entity, "username", "ID");
        logger.debug("UPDATE User Query:"+ updatequery);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(updatequery);
            //Now we set the value in the question symbol
            pstm.setObject(1, entity.getUsername());
            pstm.setObject(2, entity.getID());
            logger.debug("FINAL UPDATE Username :"+pstm);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUserPassword (User entity){

        String updatequery = QueryHelper.createQueryUPDATE(entity, "password", "username");
        logger.debug("UPDATE User Query:"+ updatequery);
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(updatequery);
            //Now we set the value in the question symbol
            pstm.setObject(1, entity.getPassword());
            pstm.setObject(2, entity.getUsername());
            pstm.executeUpdate();
            logger.debug("FINAL UPDATE Password :"+pstm);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Obj> getAllObj(String idUser) {
        Obj aux = new Obj();
        String fieldAux = "idUser";
        //Create the SELECT query --> SELECT * FROM Obj WHERE idUser = ?
        String selectQuery = QueryHelper.createQuerySELECT(aux,fieldAux);
        logger.debug("Select Obj Query:"+ selectQuery);
        // User returnUser = new User();
        PreparedStatement pstm = null;
        List <Obj> myObj = new LinkedList<>();//Initialize the list that we are going to return
        try {
            pstm = conn.prepareStatement(selectQuery);
            Object value = null;
            int i = 1;
            pstm.setObject(i, idUser); //We set in the in the question symbol the value in this case
            //it's the id of the obj that it's the correspond to the iduser
            logger.debug("FINAL GET ALL OBJ:"+pstm);
            ResultSet res = pstm.executeQuery();

            while (res.next()){
                Obj auxObj = new Obj();
                logger.debug("Checking return info from database :"+ res.getString("objName"));
                auxObj.setId(res.getInt("id")); //We set in the auxObj all the parameters
                auxObj.setIdUser(res.getString("idUser"));
                auxObj.setObjName(res.getString("objName"));
                auxObj.setObjAttack(res.getInt("objAttack"));
                auxObj.setObjDefense(res.getInt("objDefense"));
                auxObj.setPrice(res.getInt("price"));
                auxObj.setHealthPoints(res.getInt("healthPoints"));
                logger.debug("FINAL OBJ: " + auxObj.getObjName());
                myObj.add(auxObj);//We add to the list the object one by one
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myObj;
    }
    @Override
    public List<Game> getAllGame(String idUser) {
        Game aux = new Game();
        String fieldAux = "idGame";
        //Create the SELECT query --> SELECT * FROM Game WHERE idGame = ?
        String selectQuery = QueryHelper.createQuerySELECT(aux,fieldAux);
        logger.debug("Select Game Query:"+ selectQuery);
        // User returnUser = new User();
        PreparedStatement pstm = null;
        List <Game> myGame = new LinkedList<>();//Initialize the list that we are going to return
        try {
            pstm = conn.prepareStatement(selectQuery);
            Object value = null;
            int i = 1;
            pstm.setObject(i, idUser); //We set in the in the question symbol the value in this case
            //it's the id of the obj that it's the correspond to the iduser
            logger.debug("FINAL GET ALL GAMES:"+pstm);
            ResultSet res = pstm.executeQuery();

            while (res.next()){
                Game auxGame = new Game();
                logger.debug("Checking return info from database idGame :"+ res.getString("idGame"));
                auxGame.setId(res.getInt("id")); //We set in the auxObj all the parameters
                auxGame.setIdGame(res.getString("idGame"));
                auxGame.setData(res.getString("data"));
                auxGame.setKills(res.getInt("kills"));
                auxGame.setLevel(res.getInt("level"));
                auxGame.setMyDeaths(res.getInt("myDeaths"));
                auxGame.setPoints(res.getInt("points"));
                logger.debug("FINAL GAMES level of ech game in the list: " + auxGame.getLevel());
                myGame.add(auxGame);//We add to the list the object one by one
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myGame;
    }
    public void saveMyObj(Obj myObj){
        String insertQuery = QueryHelper.createQueryINSERTModified(myObj);

        logger.debug("insertQuery "+ insertQuery);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;
            Object value = null;
            for (String field: ObjectHelper.getFields(myObj)) {
                if (!field.equals("id")) {
                    value = ObjectHelper.getter(myObj, field);
                    logger.debug("i: "+i+" field "+field+" value "+value);
                    pstm.setObject(i++, value);
                }
            }

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
