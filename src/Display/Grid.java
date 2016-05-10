/**
 *  Created by Daniel P Burke on 3/25/2016
 *
 *  The purpose of this class is to create a data object that will represent a frame to put out on to the display
 *  functionality will include ability to grab data using X,Y cords and other valuable functions
 *
 *
 *
 *
 *  Please list edits and reactors in separate multiline comments under this.
 */

// Part of the display package
package Display;


public class Grid
{
    // 1-D array to hold the contents of the graphical object
    // will be able to grab from it like a 2-D array using proper formula
    private char array [];
    // Final values holding the width and height of the array important for
    // getting the X,Y cords of things in the object.
    final private int width, height;
    // String value to hold the name of the object. Might not be of use
    // but possibly useful engine feature later on.
    private String name;

    // Constructor requiring only width and height
    public Grid(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.name = "";
        array = new char [width * height];
    }
    // Constructor that copies an existing display array object
    public Grid(Grid grid)
    {
        this.width = grid.width;
        this.height = grid.height;
        this.array = grid.array;
        this.name = grid.name;
    }
    // Constructor that takes in width height and a name.
    public Grid(int width, int height, String name)
    {
        this.width = width;
        this.height = height;
        this.name = name;
        array = new char [width * height];
    }

    public char getByCord(int x, int y)
    {
        return array[y * width + x];
    }

    public char getByIndex(int index)
    {
        return array[index];
    }
    
    public void setByCord(char ch, int x, int y)
    {
      array[y * width + x] = ch;
    }
    
    public void setByIndex(char ch, int index)
    {
      array[index] = ch;
    }

    public String generateFrameString()
    {
        // the target location to store output.
        String frame = "";
        // This tracks how far over the print head has moved
        int printHead = 1;

        for (int y = 0; y < height; y++)
        {
           for (int x = 0; x <width; x++)
           {
               frame += getByCord(x, y);
           }

            frame += "\n";
        }

        // returns the final frame.
        return frame;
    }

    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }


}
