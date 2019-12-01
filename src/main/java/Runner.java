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
        System.out.println(" - Rhydderch, King of Dumbarton Rock, a mighty warrior.");
        System.out.println("His strength is in his sword Dyrnwyn, which blazes with fire.");
        System.out.println("- Cynderyn, the holy man, founder of Glas Cau.");
        System.out.println("He can heal himself and others with his sacred bell.");
        System.out.println("- Myrddin, the magician of the wild woods.");
        System.out.println("He can cast a spell of fire and is protected by a wild boar spirit, Twrch Trwyth.");
        System.out.println();
        System.out.println("Enter the name of the player you wish to be (Rhydderch is the default choice).");

        String input = scanner.next();


        if(input.equals("Rhydderch")){
            game.setPlayer(warrior);
        }
        if(input.equals("Cynderyn")){
            game.setPlayer(healer);
        }
        if(input.equals("Myrddin")){
            game.setPlayer(magician);
        }

        System.out.println("You are playing as " + game.getPlayer().getName());
        System.out.println("Your life force is " + game.getPlayer().getHealthPoints());
        System.out.println("You have " + game.getPlayer().getTreasurePoints() + " treasure points");
        System.out.println();

        System.out.println("Enter 's' to start your journey.");
        String input2 = scanner.next();
        System.out.println();

        game.start();

        for(Room room : rooms){
            System.out.println("You are now in the kingdom of " + room.getName());

            if(room.getTreasureType() != null){
                System.out.println("There is " + room.getTreasureType().getName() + " here");
            }
            else
            {
                System.out.println("There is no treasure here");
            }
            if(room.getEnemy() != null){
                System.out.println("Your enemy " + room.getEnemy().getName() + " is here. You must fight");
                game.fight(room);
                if(game.getPlayer().getHealthPoints() <= 0) {
                    System.out.println("Your life force is gone. Your quest is over");
                    return;
                }
                else {
                    System.out.println("You have defeated " + room.getEnemy().getName());
                }
            }

            if(room.getTreasureType() != null){
                game.takeTreasure(room);
                System.out.println("You have the treasure");
            }

            System.out.println("Your life force is " + game.getPlayer().getHealthPoints());
            System.out.println("You have " + game.getPlayer().getTreasurePoints() + " treasure points");
            System.out.println();

            if(room.getOtherPlayer() != null && room.getOtherPlayer() instanceof Healer){
                System.out.println("There is a healer in the room.");
                if(game.getPlayer().getTreasurePoints() >= 20){
                    System.out.println("Do you want the healer to heal you, for 20 treasure points?");
                    System.out.println("If you are healed, your life force will increase by 20");
                    System.out.println("Enter y to be healed, any other key if not");
                    String input3 = scanner.next();

                    if(input3.equals("y")){
                        Healer roomHealer = ((Healer) room.getOtherPlayer());
                        Player player = game.getPlayer();
                        player.beHealed(roomHealer);
                        System.out.println("Your life force is " + game.getPlayer().getHealthPoints());
                        System.out.println("You have " + game.getPlayer().getTreasurePoints() + " treasure points");
                        System.out.println();
                    }
                    else {
                        System.out.println("You have chosen not to be healed");
                    }
                }
                else
                {
                    System.out.println("But you do not have enough treasure points to pay");
                }
            }

            System.out.println("Enter 'c' to continue your journey.");
            String input4 = scanner.next();
            System.out.println();
        }

        System.out.println("You have completed your quest, and have " + game.getPlayer().getTreasurePoints() + " treasure points!");

    }
}
