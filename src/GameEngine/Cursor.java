package GameEngine;

/**
 * Created by dburke0731 on 4/7/2016.
 */
 import GameObjects.MappableObject;
 import GameObjects.MetaData;
public class Cursor
{
   private int x = 0;
   private int y = 0;
   private static Cursor instance;
   private int maxX,maxY;
   private Cursor()
   {
   }

   public static Cursor instance()
   {
      if(instance == null)
      {
         instance = new Cursor();
      }
      
      return instance;
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
   
   public void moveCursor(int a)
   {
      if (!MetaData.curLockOut) {
         Map md = MetaData.instance().getCurrentScene();

         maxY = md.getWidth()-1;
         maxX = md.getHeight()-1;

         MappableObject here = md.getTileByCords(getX(), getY()).getHere();
         here.setHasCursor(false);

         if(a == 0) // up
         {
            if (x > 0)
               x--;
         }
         else if (a == 1) // left
         {
            if (y > 0)
               y--;
         }
         else if (a == 2) // down
         {
            if(x< maxX)
               x++;
         }
         else // right
         {
            if(y < maxY)
               y++;
         }

         System.out.println("x: " + x + " y: " + y + " maxX: " + maxX + " maxY: " + maxY);

         here = md.getTileByCords(getX(), getY()).getHere();
         here.setHasCursor(true);
      }


   }

   public void interact()
   {
      MetaData metaData = MetaData.instance();

      Map map = metaData.getCurrentScene();

      map.getTileByCords(x,y).getHere().interact();
   }

}
