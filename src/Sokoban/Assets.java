package Sokoban;

import Base.GameObject;

import java.io.File;

import java.lang.reflect.*;

public class Assets {


    public static GameObject player = new GameObject(4, new File("sokoban_icons/player.png"), 100, 100);
    public static GameObject crate = new GameObject(2, new File("sokoban_icons/crate.png"), 100, 100);
    public static GameObject crateMarked = new GameObject(5, new File("sokoban_icons/cratemarked.png"), 100, 100);
    public static GameObject blank = new GameObject(0, new File("sokoban_icons/blank.png"), 100, 100);
    public static GameObject blankMarked = new GameObject(3, new File("sokoban_icons/blankmarked.png"), 100, 100);
    public static GameObject wall = new GameObject(1 , new File("sokoban_icons/wall.png"),100,100);
    public static GameObject playermarked = new GameObject(6, new File("sokoban_icons/playermarked.png"),100,100);
    private GameObject[] assetArray = new GameObject[10];

    public Assets(){

        assetArray[player.getObjectID()] = player;

        assetArray[crate.getObjectID()] = crate;

        assetArray[crateMarked.getObjectID()] = crateMarked;

        assetArray[blankMarked.getObjectID()] = blankMarked;

        assetArray[wall.getObjectID()] = wall;

        assetArray[blank.getObjectID()] = blank;

    }


    public GameObject getAsset(int objectID){
        return assetArray[objectID];
    }


    }


