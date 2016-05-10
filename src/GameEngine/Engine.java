package GameEngine;

/**
 * This is the final interface for working with the engine this will actually kick the loops
 * off and there can be only one.
 * Created by dburke0731 on 3/31/2016.
 */
public class Engine {
    private static Engine instance;
    private boolean running;

    private Engine(GameUpdate gameUpdate, VisualUpdate visualUpdate)
    {
        running = true;
        int check;
        while(running)
        {

            check = gameUpdate.update();
            if (check != 1)
                running = false;

            check = visualUpdate.update();
            if (check != 1)
                running=false;
        }
    }

    public static Engine makeEngine()
    {
        if(instance == null)
        {
            instance = new Engine(new GameUpdate(), new VisualUpdate());
        }
        return instance;
    }

    public void killTheGame()
    {
        running = false;
    }

}
