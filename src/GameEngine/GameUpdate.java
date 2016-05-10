package GameEngine;

import GameObjects.Character;
import GameObjects.MetaData;

/**
 * This be the method to hold the loop that contains the update to the game logic.
 * Created by dburke0731 on 3/31/2016.
 */
public class GameUpdate {


    /**
     * The point of returning an int is to give a state to the program so that if you want to exit
     * you will return a 0 which will trigger close down procedure.
     *
     * @return To compute or not compute.
     */
    public int update()
    {
        // THIS SHOULD BE CALLED AT THE TOP OF THIS METHOD PLOX DON'T MOVE
        GameIO.checkIO();
        if(!MetaData.instance().playerTurn) {
            MetaData.curLockOut = true;
            MetaData.instance().takeTurns();
        }

        if(MetaData.moving ) {
        Character.instance().move();
        }



        return 1;
    }
}
