package GameObjects;

import Display.Grid;
/**
 * Created by Daniel Burke on 4/21/2016.
 */
public class PlayButton extends MappableObject {

    private PlayButton(int x, int y, Grid grid, Grid hoverGrid)
    {
        super(x,y,grid, hoverGrid);
    }

    public static PlayButton createPlayButton(int x, int y, Grid grid, Grid hoverGrid)
    {
        PlayButton output = new PlayButton(x,y,grid, hoverGrid);

        return output;
    }



    @Override
    public void interact() {

        System.out.println("play button pressed");
        MetaData.instance().setCurrentScene(SceneSheet.GAME_SCENE);
        MetaData.menu = false;

    }
}
