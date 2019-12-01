import enemies.Enemy;
import players.Healer;
import players.Player;
import rooms.Room;
import rooms.TreasureType;
import tools.HealingTool;

import java.util.ArrayList;
import java.util.Collections;

public class Game {

    private Player player;
    private HealingTool healingTool;
    private Healer healer;
    private ArrayList<Room> rooms;

    public Game(Player player, ArrayList<Room> rooms){
        this.player = player;
        this.rooms = rooms;
    }

    public Player getPlayer(){
        return this.player;
    }

    public void setPlayer(Player newPlayer){
        this.player = newPlayer;
    }

    public ArrayList<Room> getRooms(){
        return this.rooms;
    }

    public void addRoom(Room room){
        this.rooms.add(room);
    }

    public void start(){
        Enemy enemy1 = new Enemy("Aedan mac Gabrain", 50);
        Enemy enemy2 = new Enemy("Theodric", 40);
        Enemy enemy3 = new Enemy("Gartnait", 30);
        Enemy enemy4 = new Enemy("Urien", 25);
        Enemy enemy5 = new Enemy("Clyddno Eiddin", 20);
        HealingTool healingTool = new HealingTool("cross");
        Healer healer = new Healer("Colm Cille", healingTool);
        Room room1 = new Room("Dal Riata", null, enemy1, healer);
        Room room2 = new Room("Bryneich", TreasureType.SILVER, enemy2, null);
        Room room3 = new Room("Fortriu", null, enemy3, healer);
        Room room4 = new Room("Rheged", TreasureType.GOLD, enemy4, null);
        Room room5 = new Room("Gododdin", null, enemy5, null);
        Room room6 = new Room("Manaw", TreasureType.JEWELS, null, healer);
        Room room7 = new Room("Circinn", TreasureType.GOLD, null, null);
        Room room8 = new Room("Fotla", TreasureType.JEWELS, null, healer);
        Room room9 = new Room("Fib", TreasureType.SILVER, null, null);
        addRoom(room1);
        addRoom(room2);
        addRoom(room3);
        addRoom(room4);
        addRoom(room5);
        addRoom(room6);
        addRoom(room7);
        addRoom(room8);
        addRoom(room9);
        Collections.shuffle(this.rooms);
        this.rooms.remove(0);
        this.rooms.remove(0);
        this.rooms.remove(0);
        this.rooms.remove(0);
    }

    public void fight(Room room){
        int damage = room.getEnemy().getDamagePower() - player.getStrengthPoints() - player.getDamageReduction();
        player.increaseHealthPoints(-damage);
    }

    public void takeTreasure(Room room){
        player.increaseTreasurePoints(room.getTreasureType().getValue());
    }

    public void passThroughRooms(){
        for(Room room : rooms){
            if(room.getEnemy() != null){
                fight(room);
            }
            if(room.getTreasureType() != null){
                takeTreasure(room);
            }
        }
    }

    public String playQuest(){
        System.out.println("Starting the quest");
        passThroughRooms();
        if(player.getHealthPoints() > 0){
            return "Congratulations! You have completed the quest! You have won " + player.getTreasurePoints() + " treasure points.";
        }
        return "Sorry, you didn't survive the quest.";
    }


}
