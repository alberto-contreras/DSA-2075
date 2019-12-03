package game.backend.models;


public class Game {
    private String idGame;
    private String data;              //fecha de la partida
    private int myDeaths;
    private int kills;
    private int level;
    private int points;

    public Game() {
        //this.idGame = RandomUtils.getId();  ?¿?¿?
    }

    public Game(String idGame, String data, int myDeaths, int kills, int level, int points) {
        this.idGame = idGame;
        this.data = data;
        this.myDeaths = myDeaths;
        this.kills = kills;
        this.level = level;
        this.points = points;
    }

    public String getIdGame() {
        return idGame;
    }
    public void setIdGame(String idGame) {
        this.idGame = idGame;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public int getMyDeaths() {
        return myDeaths;
    }
    public void setMyDeaths(int myDeaths) {
        this.myDeaths = myDeaths;
    }

    public int getKills() {
        return kills;
    }
    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}