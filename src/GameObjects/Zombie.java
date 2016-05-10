package GameObjects;
import Display.Grid;
import GameObjects.MetaData;
// Bturner
// 4/7/2016
// This is the zombie
// Movement, damage, health, AI/detection

public class Zombie extends MappableObject implements Turnable
{
   private int health;
   private int damage;
   private boolean smell;
   
//    private Zombie(int health, int damage, int x, int y, Grid grid, InventoryObject held)
//    {
//       
//       super(x, y, grid, held);
//       smell = false;
//       this.health = health;
//       this.damage = damage;
//    }
   
   private Zombie(int health, int damage, int x, int y, Grid grid, Grid hoverGrid)
   {
      
      super(x, y, grid, hoverGrid);
      smell = false;
      this.health = health;
      this.damage = damage;
   }
   
   public void interact()
   {
      MetaData.instance().killZombie(getID());
   }
   
   // public void detection()
//    {
//       if(Character.getX() && (Character.getY() < (Zombie.getX() && Zombie.getY())
//          smell;
//       else
//          !smell;
//    }
   
   public void turn()
   {
//      MetaData md =  MetaData.instance();
//      Character character =  Character.instance();
//         if(character.getX() == getX())
//         {
//            if(character.getY() == getY()+1)
//            {
//               character.getName();
//            }
//            else if(character.getY() == getY() - 1)
//            {
//               //turns suvived
//                character.getName();
//            }
//            else if(character.getY() > getY()+1)
//            {
//               md.getCurrentScene().swapObjects(getX(), getY(), getX() , getY()+1);
//            }
//            else if(character.getY() > getY()-1)
//            {
//               md.getCurrentScene().swapObjects(getX(), getY(), getX() , getY()-1);
//               //swap zombie with x, y - 1
//            }
//         }
//
//         else if(character.getY() == getY())
//         {
//            if(character.getX() == getX()+1)
//            {
//                character.getName();
//            }
//            else if(character.getX() == getX() - 1)
//            {
//                character.getName();
//            }
//            else if(character.getX() > getX()+1)
//            {
//               md.getCurrentScene().swapObjects(getX(), getY(), getX() + 1, getY());
//               //swap zombie with x + 1, y
//            }
//            else if(character.getX() > getX()-1)
//            {
//               md.getCurrentScene().swapObjects(getX(), getY(), getX() - 1, getY());
//               //swap zombie with x + 1, y
//            }
//         }
//         else if(character.getX() > getX())
//         {
//            md.getCurrentScene().swapObjects(getX(), getY(), getX() + 1, getY());
//         }
//         else
//         {
//            md.getCurrentScene().swapObjects(getX(), getY(), getX() - 1, getY());
//            //swap zombie with x + 1, y
//         }

   }
   
   public static Zombie initialize(int health, int damage, int  x, int y, Grid grid, Grid hoverGrid)
   {
      Zombie z = new Zombie(health, damage, x, y, grid, hoverGrid);
      MetaData md = MetaData.instance();
      md.addGameObject(z);
      md.addTurnable(z);
      return z;  
   }

   @Override
   public int getID()
   {
      return 0;
   }
   @Override
   public void setID(int i)
   {
      //setID(i);
   }

   public String getName()
   {
      MetaData.instance().buildGameMap();
      return "";
   }

}