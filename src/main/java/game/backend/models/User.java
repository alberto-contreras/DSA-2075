package game.backend.models;

import game.backend.models.Obj;
import java.util.LinkedList;
import java.util.List;

public class User {
    /**
     * Atributes
     */
    int ID;
    String username;
    String name;
    String password;
    int healthPoints;
    int attack;
    int defense;
    int money;

  //  private List<Obj> objects = null;
   // private List<Game> games = null;

    public User(){}

    public User(String un, String pw, String nm){
        /* Simple constructor for when we add a user by default*/
        this.username = un;
        this.password = pw;
        this.name = nm;
        this.healthPoints = 100;
        this.attack = 20;
        this.defense = 0;
        this.money = 100;
        //this.objects = new LinkedList<Obj>();
        //this.games = new LinkedList<Game>();
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

//    public List<Obj> getMyObject() {
//        return objects;
//    }
//    public void setMyObject(List<Obj> objects) {
//        this.objects = objects;
//    }
//
//    public List<Game> getMyGames() {
//        return games;
//    }
//    public void setMyGames(List<Game> games) {
//        this.games = games;
//    }
//
//    public void addObject(String objName, int objAttack, int objDefense, int price){
//        Obj object = new Obj(objName, objAttack, objDefense, price);
//        this.objects.add(object);
//    }
//    public void addGame(String id, String data, int myDeaths, int kills, int level, int points){
//        Game game = new Game(id, data, myDeaths, kills, level, points);
//        this.games.add(game);
//    }

    public String toString() {
        return "ID: "+this.ID +" username: "+this.username+" name:"+this.name+" passwd: "+this.password+" attack:"+this.attack+" defense:"+this.defense+" health:"+this.healthPoints+" money:"+this.money;
    }
    public void clone(User clone){
        this.ID = clone.getID();
        this.username = clone.getUsername();
        this.password = clone.getPassword();
        this.name = clone.getName();
        this.healthPoints=clone.getHealthPoints();
        this.attack=clone.getAttack();
        this.defense= clone.getDefense();
        this.money=clone.getMoney();
    }

}
