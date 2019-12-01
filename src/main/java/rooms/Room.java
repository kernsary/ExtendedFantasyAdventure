package rooms;

import enemies.Enemy;
import players.Player;

public class Room {

    private String name;
    private TreasureType treasuretype;
    private Enemy enemy;
    private Player otherPlayer;

    public Room(String name, TreasureType treasureType, Enemy enemy, Player otherPlayer){
        this.name = name;
        this.treasuretype = treasureType;
        this.enemy = enemy;
        this.otherPlayer = otherPlayer;
    }

    public String getName() {
        return this.name;
    }

    public TreasureType getTreasureType() {
        return this.treasuretype;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public Player getOtherPlayer(){ return this.otherPlayer;}

}
