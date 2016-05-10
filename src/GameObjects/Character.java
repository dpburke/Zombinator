package GameObjects;

import Display.Grid;
import GameEngine.GameIO;
import GameEngine.Map;

/**
 * Created by dburke0731 on 4/26/2016.
 */
public class Character extends MappableObject
{
    private static Character instance;
    private Character(int x, int y, Grid grid, Grid hoverGrid)
    {
        super(x,y,grid,hoverGrid);
    }
    public static Character makeCharacter(int x, int y, Grid grid, Grid hoverGrid)
    {
        if (instance == null)
            instance = new Character(x,y,grid,hoverGrid);
        return instance;
    }

    public static Character instance()
    {
        return instance;
    }

    public void turn()
    {
    }

    @Override
    public void interact()
    {
        //TODO ask which direction you want to move
    }

    public void move()
    {
        if (!MetaData.menu) {
            if (GameIO.returnDirection() != -1)
                System.out.println(GameIO.returnDirection());
            if (GameIO.returnDirection() == 0) {

                if (MetaData.instance().getCurrentScene().getTileByCords(getX(),getY()-1).getHere().getName().equalsIgnoreCase("air"))
                {
                    MetaData.instance().getCurrentScene().swapObjects(getX(), getY(), getX() , getY()-1);

                    setY( getY() - 1);

                    MetaData.playerTurn = false;
                    MetaData.moving = false;
                    GameIO.clearBuffer();
                }

            }
            if (GameIO.returnDirection() == 1) {
                if (MetaData.instance().getCurrentScene().getTileByCords(getX(),getY()+1).getHere().getName().equalsIgnoreCase("air")) {
                    MetaData.instance().getCurrentScene().swapObjects(getX(), getY(), getX(), getY() + 1);

                    setY(getY() + 1);
                    MetaData.playerTurn = false;
                    MetaData.moving = false;
                    GameIO.clearBuffer();
                }
            }
            if (GameIO.returnDirection() == 2) {
                if (MetaData.instance().getCurrentScene().getTileByCords(getX()-1,getY()).getHere().getName().equalsIgnoreCase("air")) {
                    MetaData.instance().getCurrentScene().swapObjects(getX(), getY(), getX() - 1, getY());

                    setX(getX() - 1);

                    MetaData.playerTurn = false;
                    MetaData.moving = false;
                    GameIO.clearBuffer();
                }
            }
            if (GameIO.returnDirection() == 3) {
                if (MetaData.instance().getCurrentScene().getTileByCords(getX()+1,getY()).getHere().getName().equalsIgnoreCase("air")) {
                    MetaData.instance().getCurrentScene().swapObjects(getX(), getY(), getX() + 1, getY());
                    setX(getX() + 1);
                    MetaData.playerTurn = false;
                    MetaData.moving = false;
                    GameIO.clearBuffer();
                }
            }
        }

        System.out.println(getX() + "" + getY());
    }

    public void resetCord()
    {
        setX(2);
        setY(2);
    }
    public String getName()
    {
        MetaData.instance().buildGameMap();
        return "";
    }

}
