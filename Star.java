import java.awt.*;
/**
 * Class Star - an object that exists in a finate universe. This object is static and can have planets
 * orbitting it. 
 * 
 * @author t.chate 774061
 * @version 2/03/2016
 */
public class Star
{
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private Universe universe;
    protected int lifeTime;
    /**
     * @param objectDiameter the diameter of the object.
     * @param xPos the x coordinate of the object.
     * @param yPos the y corrdinate of the object.
     * @param Color the colour of the object.
     * @param Universe the universe in which the object is present in.
     */
    public Star(int objectDiamter, int xPos, int yPos, Color starColor, Universe theUniverse)
    {
      color=starColor;
      diameter=objectDiamter;
      xPosition=xPos;
      yPosition=yPos;
      universe = theUniverse;
      lifeTime = 10000;
    }
    /**
     * return the horizontal position of this object
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
     * return the radius ter of this object
     */
    public int getRadius(){
        return (int) (diameter/2);
    }
}
