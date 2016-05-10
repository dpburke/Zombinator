/**
 *  Created by Daniel P Burke on 3/25/2016
 *
 *  The purpose of this class is to contain utility static functions that will be required throughout the program
 *  to process graphical objects and parse data
 *
 *
 *
 *
 *  Please list edits and reactors in separate multiline comments under this.
 */


package Display;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayUtils
{
    public static Grid readInFile(String fileName)
    {
        Grid output;
        
        int width = 0, height = 0;
        int xTemp = 0;
        String rawString = getFileToString(fileName);
        String [] tokenizedString = rawString.split("\\n");

        for (int x = 0; x < tokenizedString.length; x++)
        {
            if (xTemp < tokenizedString[x].length())
            {
                xTemp = tokenizedString[x].length();
            }
        }

        width = xTemp;
        height = tokenizedString.length;



        output = new Grid(width,height);

        for(int y = 0; y < tokenizedString.length; y++)
        {
            for (int x = 0; x < tokenizedString[y].length(); x++)
            {
                output.setByCord(tokenizedString[y].charAt(x),x,y);
            }
        }
        return output;

    }

    public static void insertIntoExistingDisplay(Grid input, Grid target, int x, int y)
    {

        for(int yPos = 0; yPos < input.getHeight(); yPos++)
        {
            for (int xPos = 0; xPos < input.getWidth(); xPos++)
            {
                target.setByCord(input.getByCord(xPos,yPos), x + xPos, y + yPos);
            }
        }

    }

    public static String getFileToString(String fileName)
    {
        String line;
        String output = "";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                output += line+"\n";
            }
        } catch(IOException i)
        {
            i.printStackTrace();
        }
        return output;
    }

}
