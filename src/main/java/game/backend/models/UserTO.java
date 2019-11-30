package game.backend.models;

import game.backend.models.User;

/**
 * Auxiliar class to send the User information after the registration
 * and check it from the Android Application
 */
public class UserTO {


    int ID;
    String username;
    String name;
    String password;
    int healthPoints;
    int attack;
    int defense;
    int money;

    public UserTO() {

    }

    public UserTO(User user) {
        this.ID =user.getID();
        this.username = user.getUsername();
        this.name = user.getName();
        this.password = user.getPassword();
        this.healthPoints = user.getHealthPoints();
        this.attack = user.getAttack();
        this.defense = user.getDefense();
        this.money = user.getMoney();

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
}
