package GameObjects;

import Display.Grid;

/**
 * Created by dburke0731 on 4/21/2016.
 */
public class ExitButton extends MappableObject
{
    private ExitButton(int x, int y, Grid grid, Grid hoverGrid)
    {
        super(x,y,grid,hoverGrid);
    }
    public static ExitButton createExitButton(int x, int y, Grid grid, Grid hoverGrid)
    {
        ExitButton out = new ExitButton(x,y,grid,hoverGrid);
        return out;
    }

    @Override
    public void interact() {

    }
}
