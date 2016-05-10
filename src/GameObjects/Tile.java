// Brendan Turner
// 4/7/2016
// This Class will be the base tiles of our map
// They will not move or change once they are created.
// Questions:

package GameObjects;
import Display.Grid;
public class Tile extends BaseGameObject
{
   private int px;
   private int py;
   private final int x;
   private final int y;
   private MappableObject here;
   //Hidden Items that only show up when you try to move the Character to tile
   //Maybe :private InventoryObject hidden;?
   
   private Tile(int x, int y, int px, int py, MappableObject here)
   {
      this.x = x;
      this.y = y;
      this.px = px;
      this.py = py;
      this.here = here;
   }
   
   public Grid getGrid()
   {
      return here.getGrid();
   }

   public int getTileX()
   {
      return x;
   }
   
   public int getTileY()
   {
      return y;
   }
   
   public int getPX()
   {
      return px;
   }
   
   public int getPY()
   {
      return py;
   }
   
   public MappableObject getHere()
   {
      return here;
   }

   public void setHere(MappableObject mappableObject)
   {
      this.here = mappableObject;
   }

   public void setPx(int px) {
      this.px = px;
   }

   public void setPy(int py) {
      this.py = py;
   }

   public void setPxPy(int x, int y)
   {
      this.px = x;
      this.py = y;
   }


   public static Tile createTile(int x, int y, int px, int py, MappableObject here)
   {
      Tile t = new Tile(x, y, px, py, here);
      //MetaData md = MetaData.instance();
      //md.addGameObject(t);
      return t;
   }
   
}