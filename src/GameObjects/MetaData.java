package GameObjects;

import Display.Display;
import Display.Grid;
import Display.DisplayUtils;
import GameEngine.GameUpdate;
import GameEngine.Map;

import javax.swing.*;
import java.util.Random;

import java.util.ArrayList;

/**
 * Created by dburke0731 on 3/31/2016.
 */
public class MetaData extends BaseGameObject
{

// UNCOMMENT FOR WINDOWS
    public static String fileroot = "C:\\Zombinator\\Resource\\";
    public static String slash = "\\";
//
// UNCOMMENT FOR MAC
//    public static String fileroot = "/Users/pchoi789/zombinator/Resource/";
//    public static String slash = "/";

    private ArrayList<BaseGameObject> gameObjects = new ArrayList<BaseGameObject>();
    private ArrayList<Turnable> turnables = new ArrayList<Turnable>();
    private Display display;
    private int lastID = 0;
    public static boolean menu = true;
    Map[] scenes = new Map[10];
    public static boolean playerTurn = false,curLockOut = false,shooting = false, moving = false;
    private int objects = 0;
    private int currentScene;
    private static MetaData instance;
    public static int score = 0;
    public static int hiScore = 0;

    private MetaData()
    {
        display = new Display("Zombinator", 700, 700);
        buildMainMenu();
        buildGameMap();
        currentScene = 0;
    }

    public static MetaData instance()
    {
        if(instance == null)
        {
            instance = new MetaData();
        }

        return instance;
    }

    public Display getDisplay()
    {
        return display;
    }

    public void addTurnable(Turnable to)
    {
        to.setID(lastID);
        lastID++;

        turnables.add(to);
    }
    public void killZombie(int ID)
    {
        for (int x = 0; x < turnables.size(); x++)
        {
            if(turnables.get(x).getID() == ID)
            {
                turnables.remove(x);
            }
        }
    }
    public void takeTurns()
    {
        spawnZombie(new Random().nextInt(5));

        curLockOut = true;
        for (int i = 0; i < turnables.size(); i++)
            turnables.get(i).turn();

        playerTurn = true;
        moving = true;
        curLockOut = false;

        score++;

        System.out.println("TOOK TURNS");

    }


    public void characterTurn()
    {

        characterShoot();

        characterMove();

    }
    private void characterShoot()
    {

    }

    private void characterMove()
    {

    }

    public void addGameObject(BaseGameObject object)
    {
        int lastValue = 0;
        for (int i = 0; i < gameObjects.size(); i++)
        {
            lastValue = object.getID() + 1;
        }
        object.setID(lastValue);
        gameObjects.add(object);
    }

    public void removeGameObject(int id)
    {
        for (int x = 0; x < gameObjects.size(); x++)
        {
            if(gameObjects.get(x).getID() == id)
            {
                gameObjects.remove(x);
            }
        }
    }

    public void removeGameObject(String name)
    {

    }

    public void setCurrentScene(SceneSheet i)
    {
        switch (i)
        {
            case GAME_SCENE:
                currentScene = 1;
                break;
            case MAIN_MENU_SCENE:
                currentScene = 0;
                break;
            case OPTIONS_MENU_SCENE:
                break;
        }
    }
    public Map getCurrentScene()
    {
        return scenes[currentScene];
    }


    ////////////PRIVATE SCENE BUILDERS//////////////////////////////////////////////////////////////////////////////////

    private void buildMainMenu()
    {
        scenes[0] = new Map(1,3, DisplayUtils.readInFile(fileroot + "MenuGrids" + slash + "MainMenuBackground.txt"),0,0);

        //TILE 1,0 PLAY BUTTON
        scenes[0].getTileByCords(0,0).setPxPy(33,10);
        scenes[0].getTileByCords(0,0).setHere( PlayButton.createPlayButton(0,0,
                                                DisplayUtils.readInFile(fileroot + "MenuGrids" + slash + "PlayButton.txt"),
                                                DisplayUtils.readInFile(fileroot + "MenuGrids" + slash + "PlayButtonHover.txt")));
        /////////
        //TILE 2,0 OPTIONS BUTTON
        scenes[0].getTileByCords(1,0).setPxPy(20,18);
        scenes[0].getTileByCords(1,0).setHere(OptionsButton.createOptionsButton(0,0,
                                                DisplayUtils.readInFile(fileroot + "MenuGrids" + slash + "optionsbutton.txt"),
                                                DisplayUtils.readInFile(fileroot + "MenuGrids" + slash + "optionsbuttonhover.txt")));
        ////////
        //TILE 3,0 EXIT BUTTON
        scenes[0].getTileByCords(2,0).setPxPy(35,26);
        scenes[0].getTileByCords(2,0).setHere(ExitButton.createExitButton(0,0,
                                                DisplayUtils.readInFile(fileroot + "MenuGrids" + slash + "exitbutton.txt")
                                                ,DisplayUtils.readInFile(fileroot + "MenuGrids" + slash + "exitbuttonhover.txt")));
        ///////

    }

    public void buildGameMap()
    {

        scenes[1] = new Map(25,25, DisplayUtils.readInFile(fileroot + "gameGrids" + slash + "maingame.txt"),5,5);

        //AIR TILES
        for (int x = 0; x < 16; x++) {
            for (int y = 0; y < 10; y++) {
                scenes[1].getTileByCords(x,y).setPxPy((6*x + 1) , (3*y + 1));
            }
        }
        if (Character.instance() == null)
            scenes[1].setMOByCords(2,2,Character.makeCharacter(2,2,DisplayUtils.readInFile(fileroot + "character.txt"),new Grid(0,0)));
        else {
            if (hiScore < score) {
                hiScore = score;
            }

            scenes[1].setMOByCords(2, 2, Character.instance());
            JOptionPane.showMessageDialog(MetaData.instance.getDisplay(), "Score: " + score + "\nHigh Score: " + hiScore);
            score = 0;
            Character.instance().resetCord();
        }

    }

    public void spawnZombie(int numOfZombies)
    {
        //check that its air
        //add zombie
        for (int j = 0; j < numOfZombies; j++) {
            Random rand = new Random();

            int x = rand.nextInt(16);
            int y = rand.nextInt(10);


            //checking air by object type
            if ((scenes[1].getTileByCords(x,y).getHere().getName().equalsIgnoreCase("air"))) {

                Zombie z = Zombie.initialize(10, 10, x, y,
                        DisplayUtils.readInFile(fileroot + "Characters" + slash + "Zombie.txt"),
                        DisplayUtils.readInFile(fileroot + "Characters" + slash + "Zombie.txt"));

                scenes[1].getTileByCords(x, y).setHere(z);
            }
        }
    }


}
