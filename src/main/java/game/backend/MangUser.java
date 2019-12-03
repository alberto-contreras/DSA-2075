package game.backend;

import game.backend.models.User;

public interface MangUser {
    public void addUser(String userName, String password, String name);
    public int size();
    public User getUserByUserName(String userName);
    public void addObjetWithUserName(String userName, String name, int defense, int attack, int price);
    public void addGamesWithUserName(String userName, String id, String data, int miDeaths, int kills, int level, int points);
}
