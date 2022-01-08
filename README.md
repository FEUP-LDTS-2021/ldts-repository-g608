# LDTS_T06_G0608 - PACMAN

## Game Description

Our game is based on a game called Pacman, originally created by ®NAMCO, the player is running to get pellets in a maze while ghosts are chasing him. If he gets all the pellets, he wins and if the ghosts catches him he loses. The player can eat a special pelllet that works like a powerup and lets the player eat the ghosts to earn extra points and facilitate catching all the pellets.

This project was developed by Vinícius Macedo Corrêa (up202001417@fe.up.pt), André Morais (up202005303@edu.fe.up.pt) and Carlota Leite (up202005428@edu.fe.up.pt) for LDTS 2021-22.

## Implemented Features

- **Keyboard control** - Keyboard inputs are received through the respective events and interpreted according to the current game state.
- **Player control** - The player may move with the keyboard control.

## Planned Features

- **Collisions detection** - Collisions between different objects are verified. (Ex: Player, Enemies, Obstacles).
- **Score System** - Everytime the player catches the pellets or eat the ghosts he gets a score that is registeres and displayed in the end of the game.
- **Menus** - The user has the capability of browsing through the different menus. (Main Menu, Instructions, Play, Pause, Leaderboard).
- **Animations** - The pacman change the side is looking depending of the direction he is moving

## Design

### General Structure
#### Problem in Context:
The first concern of our project was how the structure would look like. Since our game is dealling with a GUI some specific patterns came to mind in order to fullfil our needs the best way possible.

#### The Pattern:
The main pattern applied to the project is the **_Architectural Pattern_**, more specifically the Model-View-Controller used in a GUI.

#### Implementation:
Regarding the implementation, we now have classes which main purpose is to store data (model), classes that control the logic of the game (controllers) and classes that are responsible for the visual effects on the screen (viewers), these types of classes associate with each other in the following manner:

#### Consequences:
The use of these patterns in the current design allow the following benefits:
- A well organized code.
- Easy to add new features throughout the development stage.
