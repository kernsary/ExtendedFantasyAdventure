import enemies.Enemy;
import org.junit.Before;
import org.junit.Test;
import players.Warrior;
import rooms.Room;
import rooms.TreasureType;
import tools.Weapon;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    private Room room;
    private Enemy enemy;
    private Weapon weapon;
    private Warrior warrior;

    @Before
    public void before(){
        enemy = new Enemy("Bill", 10);
        weapon = new Weapon("Dyrnwyn");
        warrior = new Warrior("Alan", weapon);
        room = new Room("Grog", TreasureType.JEWELS, enemy, warrior);
    }

    @Test
    public void canGetName() {
        assertEquals("Grog", room.getName());
    }

    @Test
    public void canGetTreasureType() {
        assertEquals(TreasureType.JEWELS, room.getTreasureType());
    }

    @Test
    public void canGetEnemy() {
        assertEquals(enemy, room.getEnemy());
    }

    @Test
    public void canGetOtherPlayer(){assertEquals(warrior, room.getOtherPlayer());}
}
