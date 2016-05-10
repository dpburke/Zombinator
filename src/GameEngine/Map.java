package GameEngine;

import Display.DisplayUtils;
import GameObjects.Air;
import GameObjects.BaseGameObject;
import Display.Grid;
import GameObjects.MappableObject;
import GameObjects.Tile;



/**
 * Created by: Paul H Choi
 * Contact:    pchoi4116@student.mc3.edu
 * Date:       4/14/16
 */
public class Map
{

   //UNCOMMENT FOR WINDOWS
    public static String fileroot = "C:\\Zombinator\\Resource\\";
    public static String slash = "\\";

   //UNCOMMENT FOR MAC
//   public static String fileroot = "/Users/pchoi789/zombinator/Resource/";
//   public static String slash = "/";


   /** array of tiles
    *  get grid called background
    * getters and setters
    */
   private Tile      tile [];
   private Tile      nonInts[];
   Grid              background;

   private final int width,
                     height,
                     niWidth,
                     niHeight;

   public Map(int x , int y, Grid background, int nix, int niy)
   {
      niWidth = nix;
      niHeight = niy;
      width = x;
      height = y;

      this.background = background;
      nonInts = new Tile[niWidth * niHeight];
      tile = new Tile[x * y];

      for (int xPos = 0; xPos < y ; xPos++)
      {
         for (int yPos = 0; yPos < x; yPos++)
         {
            tile[yPos * y + xPos] =  Tile.createTile(xPos,yPos,0,0,  Air.initialize(0,0,
                                                      DisplayUtils.readInFile(fileroot + "Air.txt"),
                                                      DisplayUtils.readInFile(fileroot + "Air.txt")));
         }
      }
      for (int xPos = 0; xPos < niy ; xPos++) {
         for (int yPos = 0; yPos < nix; yPos++) {
            nonInts[yPos * niy + xPos] = Tile.createTile(xPos, yPos, 0, 0, Air.initialize(0, 0,
                    DisplayUtils.readInFile(fileroot + "Air.txt"),
                    DisplayUtils.readInFile(fileroot + "Air.txt")));
         }
      }


   }


   public void setTileCords(int x, int y, int pX, int pY)
   {
      tile[width*y +x].setPx(pX);
      tile[width*y +x].setPy(pY);

   }

   public Grid getBackground() {
      return background;
   }

   public void setBackground(Grid background) {
      this.background = background;
   }

   public int getWidth()
   {
      return width;
   }

   public int getHeight()
   {
      return height;
   }

   public Tile getTileByCords(int x, int y)
   {
      return tile[height * y + x];
   }

   public void setMOByCords(int x, int y, MappableObject mappableObject)
   {
      tile[height * y + x].setHere(mappableObject);
   }
   public void swapObjects(int x, int y, int xx, int yy)
   {

      MappableObject temp = getTileByCords(xx,yy).getHere();

      setMOByCords(xx,yy,getTileByCords(x,y).getHere());

      setMOByCords(x,y,temp);

   }
   public String renderMap()
   {
      Grid output = new Grid(background);

      for (int i = 0; i < tile.length; i++)
      {
         DisplayUtils.insertIntoExistingDisplay(tile[i].getHere().render(), output, tile[i].getPX(), tile[i].getPY());
      }

      return output.generateFrameString();
   }





}
