import java.awt.*;
/**
 * Class Planet. This class represent objects which orbit a set sun.
 * 
 * @author T.CHATE
 * @version 10/3/2016
 */
public class Planet
{
    private Color color;
    protected int diameter;
    private int xPosition;
    private int yPosition;
    private double speed;
    private Star centralStar;
    private Universe universe;
    private int lifeTime;
    /**
     * @param planetColour this specifies the colour of the planet.
     * @param xPos this is the x coord of the planet.
     * @param yPos this is the y coord of the planet.
     * @param Star this is the 'central' star the planet orbits.
     * @param universe this is the universe in which the object is present in.
     */

    public Planet(Color planetColour,int objectDiamter, int xPos, int yPos, double planetSpeed, Star star, Universe theUniverse)
    {
        color =planetColour;
        diameter=objectDiamter;
        xPosition=xPos;
        yPosition=yPos;
        speed = planetSpeed;
        centralStar= star;
        universe = theUniverse;
        lifeTime = 100000;
    }
    /**
     * This method orbits the planet around a central star.
     */
    public void orbit(){

        universe.erasePlanet(this);

        int starX = getCentralStar().getXPosition()+getCentralStar().getRadius();
        int starY = getCentralStar().getYPosition()+getCentralStar().getRadius();

        int currentX = xPosition+getRadius();
        int currentY = yPosition+getRadius();
        int dx = starX - currentX;
        int dy = starY - currentY;

        xPosition = (int)(starX + dx * Math.cos(speed) - dy * Math.sin(speed)); 
        yPosition = (int)(starY  + dx * Math.sin(speed) + dy * Math.cos(speed));
        lifeTime =  --lifeTime;         
        universe.drawPlanet(this);
        
    }
    /**
     * Returns the y Position of the object.
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
     * Returns the radius  of the object.
     */
    public int getRadius(){

        return (int) (diameter/2);
    }
     /**
     * Returns the x Position  of the object.
     */
    public int getXPosition()
    {
        return xPosition;
    }
     /**
     * Returns the central star  of the object.
     */
    public Star getCentralStar(){
        return centralStar;

    }
    /**
     * return the current lifetime of this object.
     */
    public int getLifeTime()
    {
        return lifeTime;
    }
}
