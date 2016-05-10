package GameObjects;

//The x and y needs to be taken out

public abstract class BaseGameObject
{
   private String name;
   private int ID;
   private int turns;

   public BaseGameObject()
   {
   }

   public String getName()
   {
      return this.name;
   }
   public int getID()
   {
      return this.ID;
   }


   public void setID(int id)
   {
      this.ID = id;
   }
   public void setName(String name)
   {
      this.name = name;
   }
   
   public int getTurns()
   {
      return turns;
   }

}