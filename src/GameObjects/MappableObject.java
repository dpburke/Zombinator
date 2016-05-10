// Bturner
// 4/7/2016
// This class will be the parent of all mappable objects
// it will contain the x and y coordinates and grid value
// Questions:

package GameObjects;
import Display.Grid;

public abstract class MappableObject extends BaseGameObject
{
   private int x;
   private int y;
   private Grid grid;
   private Grid cursor;
   //private InventoryObject held;
   private boolean hasCursor = false;
   
   // private MappableObject(int x, int y, Grid grid, InventoryObject held)
   // {}
   
   public MappableObject(int x, int y, Grid grid, Grid hoverGrid)
   {
      this.x = x;
      this.y = y;
      this.grid = grid;
      this.cursor = hoverGrid;
   }
   
   public void setHasCursor(boolean huh)
   {
      hasCursor = huh;
   }
   
   public Grid render()
   {
      if (hasCursor)
         return cursor;
      else
         return grid;
   }
   
   public int getX()
   {
      return x;
   }
   
   public int getY()
   {
      return y;
   }
   
   public void setX(int x)
   {
      this.x = x;
   }
   
   public void setY(int y)
   {
      this.y = y;
   }  
   
   public Grid getGrid()
   {
      return grid;
   }
   
   public abstract void interact();
   
   
}