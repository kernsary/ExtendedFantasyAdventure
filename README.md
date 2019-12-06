# FantasyAdventure

This is a game written in Java as a Maven project using the IntelliJ IDE. The game is a 'text adventure' played in the console.
To play the game, open the project in an IDE, run the Runner file, and enter text in the console when prompted.

The project meets all the requirements of the brief below, although the version of the game played via the Runner file does not currently use all of the wider project's capabilities. The project was begun as a lab with another CodeClan student and then extended as a solo homework project.


Project brief:

# Lab - Fantasy Adventure

The task is to model a fantasy adventure. The game will have players, who will have a number of health points and weapons/spells. Players will fall into different categories:

* Dwarves, Barbarians, Knights
	* each of these will have a weapon and fight with other players (Sword, Axe, Club, etc)
	* should be able to change their weapon at any point in the game.
* Warlocks and Wizards
	* they will be able to cast spells on others (Fireball, Lightning Strike, etc).
	* they will have a mythical creature (e.g. Ogre, Dragon) who will defend them from attackers.
	* should be able to change spells or creature at any point in the game.
* Clerics
	* they will have healing tools with which they can heal other players (potion, herbs, etc).
	* should be able to change healing tool at any point in the game.

The game will also have rooms to work through. Each room should either have some kind of treasure (Gold, Gems) to collect or an Enemy (Troll, Orc) to defeat before moving on.

## Remember
 * Use TDD
 * Git commit regularly

## MVP

* Create the players and rooms for the adventure. (Don't worry about giving the rooms any exits.)
* Give different players properties/methods that are specific to their own class. (e.g. a Knight could have armour that could reduce damage they take)
* The user should complete rooms by either collecting treasure or defeating an enemy and a new room will be presented to them.  

## Extensions

* Create a Quest for the players to work through. Possibly a collection of rooms to go through and the quest completes when all rooms are completed
* Expand any other way you wish.
