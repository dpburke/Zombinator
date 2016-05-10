package GameEngine;

import GameObjects.MetaData;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by dburke0731 on 4/7/2016.
 */
public class GameIO implements KeyListener {
    static boolean up, down, left, right, a, b, x, y;
    static int lastDirection = -1;
    public static void checkIO()
    {
        if (up)
            upPressed();
        if(down)
            downPressed();
        if(left)
            leftPressed();
        if(right)
            rightPressed();
        if(a)
            aPressed();
        if(b)
            bPressed();
        if(x)
            xPressed();
        if(y)
            yPressed();
    }

    private static void upPressed()
    {
        System.out.println("UP IS PRESSED!!!");
        Cursor c = Cursor.instance();
        c.moveCursor(0);
        lastDirection = 0;
        up = false;
    }

    private static void downPressed()
    {
        System.out.println("Down IS PRESSED!!!");
        Cursor c = Cursor.instance();
        c.moveCursor(2);
        lastDirection = 1;
        down = false;
    }

    private static void leftPressed()
    {
        System.out.println("Left IS PRESSED!!!");
        Cursor c = Cursor.instance();
        c.moveCursor(1);
        lastDirection = 2;
        left = false;
    }

    private static void rightPressed()
    {
        System.out.println("Right IS PRESSED!!!");
        Cursor c = Cursor.instance();
        c.moveCursor(3);
        lastDirection = 3;
        right = false;
    }

    private static void aPressed()
    {
        System.out.println("A IS PRESSED!!!");

        Cursor c= Cursor.instance();
        c.interact();

        a = false;
    }

    private static void bPressed()
    {
        System.out.println("B IS PRESSED!!!");
        MetaData.instance().spawnZombie(1);
        b = false;
    }

    private static void xPressed()
    {
        System.out.println("X IS PRESSED!!!");

        x = false;
    }

    private static void yPressed()
    {
        System.out.println("Y IS PRESSED!!!");

        y = false;
    }

    public static int returnDirection()
    {


        return lastDirection;

    }

    public static void clearBuffer()
    {
        lastDirection = -1;
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == 65)
            a = true;
        if(e.getKeyCode() == 83)
            b = true;
        if(e.getKeyCode() == 68)
            x = true;
        if(e.getKeyCode() == 70)
            y = true;
        if(e.getKeyCode() == 38)
            up =true;
        if(e.getKeyCode() == 40)
            down = true;
        if(e.getKeyCode() == 37)
            left = true;
        if(e.getKeyCode() == 39)
            right = true;

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }
}
