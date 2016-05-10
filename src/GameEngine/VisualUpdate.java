package GameEngine;

import Display.Display;
import Display.Grid;
import Display.DisplayUtils;
import GameObjects.MetaData;

/**
 * This is an object that will be passed to the engine to hold the calls for updating the visuals
 *
 * Created by dburke0731 on 3/31/2016.
 */
public class VisualUpdate {

    Display display;
   // Grid finalFrame;

    public VisualUpdate()
    {
        display = MetaData.instance().getDisplay();
    }

    /**
     * The point of returning an int is to give a state to the program so that if you want to exit
     * you will return a 0 which will trigger close down procedure.
     *
     * @return To compute or not compute.
     */
    public int update()
    {
        display.cycleFrames(MetaData.instance().getCurrentScene().renderMap());
        return 1;
    }
}
