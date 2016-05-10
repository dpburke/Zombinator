package GameObjects;
import Display.Grid;

// Bturner
// 4/7/2016
// This class will be the object for spaces you can move to
// Interaction is limited to movement
// Questions:
// Bturner potential for invisobjects here?

public class Air extends MappableObject
{
   private Air(int x, int y, Grid grid, Grid hoverGrid)
   {
      super(x, y, grid, hoverGrid);

   }
   
   public void interact()
   {
      //movement
   }
   
   public static Air initialize(int x, int y, Grid grid, Grid hoverGrid)
   {
      Air a = new Air(x, y, grid, hoverGrid);
      a.setName("air");
      //MetaData md = MetaData.instance();
      //md.addGameObject(a);
      return a;
   }

}