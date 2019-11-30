import creatures.Creature;
import players.Healer;
import players.Magician;
import players.Player;
import players.Warrior;
import rooms.Room;
import tools.HealingTool;
import tools.Spell;
import tools.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

import static javax.xml.bind.DatatypeConverter.parseString;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Weapon weapon = new Weapon("Dyrnwyn");
        Spell spell = new Spell("Fire");
        Creature creature = new Creature("Twrch Trwyth");
        HealingTool healingTool = new HealingTool("Bell");
        ArrayList<Room> rooms = new ArrayList<Room>();
        Warrior warrior =  new Warrior("Rhydderch", weapon);
        Healer healer = new Healer("Cynderyn", healingTool);
        Magician magician = new Magician("Myrddin", spell, creature);
        Game game = new Game(warrior, rooms);

        System.out.println("Kingdom of Strathclyde, AD 590.");
        System.out.println("You will travel to enemy kingdoms to find treasure and glory.");
        System.out.println("But, if the enemy confronts you, you must fight.");
        System.out.println("Will you survive?");
        System.out.println();
        System.out.println("Will you play as:");
        System.out.println(" - Rhydderch, King of Dumbarton Rock, an mighty warrior.");
        System.out.println("His strength is in his sword Dyrnwyn, which blazes with fire.");
        System.out.println("- Cynderyn, the holy man, founder of Glas Cau.");
        System.out.println("He can heal himself and others with his sacred bell.");
        System.out.println("- Myrddin, the magician of the wild woods.");
        System.out.println("He can cast a spell of fire and is protected by wild boar spirit, Twrch Trwyth.");
        System.out.println();
        System.out.println("Enter the name of the player you wish to be (Rhydderch is the default choice).");

        String input = scanner.next();


        if(input.equals("Rhydderch")){
//            Warrior warrior = new Warrior("Rhydderch", weapon);
            game.setPlayer(warrior);
        }
        if(input.equals("Cynderyn")){
//            Healer healer = new Healer("Cynderyn", healingTool);
            game.setPlayer(healer);
        }
        if(input.equals("Myrddin")){
//            Magician magician = new Magician("Myrddin", spell, creature);
            game.setPlayer(magician);
        }

        System.out.println("You are playing as " + game.getPlayer().getName());
        System.out.println();

        System.out.println("Enter 's' to start your journey.");
        String input2 = scanner.next();
        System.out.println();



        game.start();

        for(Room room : rooms){
            System.out.println("You are now in the kingdom of " + room.getName());
//            if(room.getEnemy() != null){
//                fight(room);
//            }
//            if(room.getTreasureType() != null){
//                takeTreasure(room);
//            }
        }

    }
}
