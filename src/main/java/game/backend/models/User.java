package game.backend.models;

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
//    List<LQ> myObj;
//    List<Game>myGames;
    public User(){}

    public User(String un, String pw, String nm){
        /* Simple constructor for when we add a user by default*/
        this.username = un;
        this.password = pw;
        this.name = nm;
        this.healthPoints=100;
        this.attack=20;
        this.defense=0;
        this.money=100;
     //   this.myObj= null;
     //   this.myGames=null;
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
/*
    public List<LQ> getMyObj() {
        return myObj;
    }

   public void setMyObj(List<LQ> myObj) {
        this.myObj = myObj;
    }
    public List<Game> getMyGames() {
        return myGames;
    }

    public void setMyGames(List<Game> myGames) {
        this.myGames = myGames;
    }
*/
    /**
     * LQ it's a subclass that allow us
     * to have a list of objects and quantity for each user
     */
    public class LQ {
        Obj object;
        int quantity;
        public LQ (Obj u, int x){
            this.object = u;
            this.quantity = x;
        }
        public LQ (){
        }
        public Obj getObject() {
            return object;
        }

        public void setObject(Obj object) {
            this.object = object;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    public String toString() {
        return "ID:"+this.ID+"username: "+this.username+" name:"+this.name+" passwd: "+this.password+" attack:"+this.attack+" defense:"+this.defense+" health:"+this.healthPoints+" money:"+this.money;
    }

}
