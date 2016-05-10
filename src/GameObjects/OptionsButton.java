package GameObjects;

import Display.Grid;

/**
 * Created by dburke0731 on 4/21/2016.
 */
public class OptionsButton extends MappableObject
{

    private OptionsButton(int x, int y, Grid grid, Grid hoverGrid)
    {
        super(x,y,grid,hoverGrid);
    }
    public static OptionsButton createOptionsButton(int x, int y, Grid grid, Grid hoverGrid)
    {
        OptionsButton out = new OptionsButton(x,y,grid,hoverGrid);

        return out;
    }

    @Override
    public void interact() {

    }
}
