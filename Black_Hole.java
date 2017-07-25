import java.awt.*;
/**
 * Class Black_Hole is a object present in some universes. It attracts comets.
 * 
 * @author T.CHATE
 * @version 10/3/2016
 */
public class Black_Hole
{
    // instance variables - replace the example below with your own
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Universe universe;

    /**
     * @param objectDiameter this is the diameter of the object.
     * @param xPos this is the x Position of the object.
     * @param yPos this is the y Position of the object.
     * @param Universe this is which universe the object is present in.
     * The color is preset to Black.
     */
    public Black_Hole(int objectDiamter, int xPos, int yPos, Universe theUniverse)
    {
        color = Color.BLACK;
        diameter=objectDiamter;
        xPosition=xPos;
        yPosition=yPos;
        universe = theUniverse;
    }
    /**
     * Returns the x coords of the object.
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this object
     */
    public int getYPosition()
    {
        return yPosition;
    }

    /**
     * return the colour of this object
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * return the diameter of this object
     */
    public int getDiameter()
    {
        return diameter;
    }
     /**
     * return the radius of the object.
     */
    public int getRadius(){
        return (int) (diameter/2);
    }
}
