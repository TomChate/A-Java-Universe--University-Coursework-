import java.awt.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Class Space_Object - an object that exists in a finite Universe. The object bounces off
 * the bottom edge of the universe. And interact with other items in the universe (Planets, Stars etc..)
 * 
 * 

 * 
 * @author Robert Topp & Thomas Chate
 *
 * @version 2016.01.22
 */

public class Space_Object
{
    private Color color;
    private int diameter;
    protected int xPosition;
    protected int yPosition;
    private final int groundPosition;     // y position of the bottom of the Universe
    private final int rightPosition;
    private Universe universe;
    protected int xSpeed;                 // current horizontal speed   (+  moving left to right, - right to left
    protected int ySpeed;                // current vertical speed ( + moving down, - moving up)
    private int lifeTime;
    private int type;
    private int probabilityOfChange;
    private ArrayList<Color> colours;
    private double radius;
    private int repeatFactor;
    /**
     * Constructor for objects of class Space_Object
     *
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectDiameter  the diameter (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theUniverse  the universe this object is in
     * @param typeNumber the type number of the object. In this demo it can be 1 or 4.
     * @param probability the probabilty of changing when moving, out of 100.
     * @param repeatFactor the amount of times a comet has moved towards a black hole, it influences speed.
     */
    public Space_Object(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse, int typeNumber,int probability)
    {
        xPosition = xPos;
        yPosition = yPos;
        xSpeed = xVel;
        ySpeed = yVel;
        color = objectColor;
        diameter = objectDiameter;
        universe = theUniverse;
        groundPosition = universe.getGround();
        rightPosition = universe.getRightEdge();
        lifeTime = 1000000;
        type = typeNumber;
        probabilityOfChange=probability;
        radius=diameter/2;
        repeatFactor = 1;
    }

    /**
     * Constructor for objects of class Space_Object
     *
     * @param xPos  the horizontal coordinate of the object
     * @param yPos  the vertical coordinate of the object
     * @param xVel  the horizontal speed of the object
     * @param yVel  the vertical speed of the object
     * @param objectDiameter  the diameter (in pixels) of the object
     * @param objectColor  the color of the object
     * @param theUniverse  the universe this object is in
     * @param typeNumber the type number of the object. In this demo it can be 1 or 4.
     * @param probability the probabilty of changing when moving, out of 100.
     * @param time the lifetime of the comet.
     */
    public Space_Object(int xPos, int yPos, int xVel, int yVel, int objectDiameter, Color objectColor, Universe theUniverse, int typeNumber,int probability, int time)
    {
        xPosition = xPos;
        yPosition = yPos;
        xSpeed = xVel;
        ySpeed = yVel;
        color = objectColor;
        diameter = objectDiameter;
        universe = theUniverse;
        groundPosition = universe.getGround();
        rightPosition = universe.getRightEdge();
        lifeTime = time;
        type = typeNumber;
        probabilityOfChange=probability;
        radius=diameter/2;

    }

    /**
     * Move this object according to its position and speed and redraw.
     * It also checks to see if the comet has hit a side. If it has it
     * changes it's x&y speed.
     * It also checks to see what type of comet it is. Dependant on this, and its
     * probabilty, 'special' changes occur.
     **/
    public void move()
    {
        // remove from universe at the current position
        universe.erase(this);

        // compute new position
        yPosition += ySpeed;
        xPosition += xSpeed;
        type = this.getType();
        // check if it has hit the ground.
        if(yPosition >= (groundPosition - diameter) && ySpeed > 0) {
            yPosition = groundPosition - diameter;
            ySpeed = -ySpeed;
            if(type==1){
                changeDiameter();
            }else if (type==4){
                changeLifeTime();     
            }
        }else if(yPosition<0 && ySpeed <0){ //Check if it has hit the top.
            yPosition = 0 + diameter;
            ySpeed = -ySpeed;
            if(type==1){
                changeDiameter();
            }else if (type==4){
                changeLifeTime();     
            }
        }else if( xPosition >= (rightPosition - diameter) && xSpeed>0){ //Checks to see if it has hit the right.
            xPosition = rightPosition - diameter;
            xSpeed = -xSpeed;
            if(type==1){
                changeDiameter();
            }else if (type==4){
                changeLifeTime();     
            }
        }else if (xPosition <= (0+diameter) && xSpeed<0){   //Checks to see if it has hit the left.
            xPosition = diameter;
            xSpeed = -xSpeed;
            if(type==1){
                changeDiameter();
            }else if (type==4){
                changeLifeTime();     
            }
        }

        Random generator = new Random();
        int i = generator.nextInt(99)+1;
        if(i<=getProbability()){
            if(type==1){
                changeSpeed();
            }else if (type==4){
                changeColour();
            }

        }
        lifeTime =  lifeTime-1;
        if(this.getLifeTime() ==0){
            universe.erase(this);
        }else{
            // draw again at new position
            universe.draw(this);}

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
     * return the current lifetime of this object.
     */
    public int getLifeTime()
    {
        return lifeTime;
    }

    /**
     * return the type of this object.
     */
    public int getType()
    { 
        return type;
    }

    /**
     * Change the diameter of the comet between a min and max value.
     */
    public void changeDiameter()
    {
        Random generator = new Random();
        int i = generator.nextInt(25)+10; //sets diameter to a random number between 10 and 25.
        diameter = i;
    }

    /**
     * return the probability of special changes happening in this object.
     */
    public int getProbability()
    {
        return probabilityOfChange;
    }

    /**
     * Change the speed of the comet dependant on a random number being generated.
     */
    public void changeSpeed()
    {
        Random generator = new Random();
        int randomNum= generator.nextInt(5)+1; //generates a random number between 1 and 4
        int newXSpeed = 0;
        int newYSpeed = 0;
        switch(randomNum){
            case 1: newXSpeed = (int) xSpeed*2; //doubles speed
            newYSpeed = (int) ySpeed*2;
            break;
            case 2: newXSpeed = (int) xSpeed/2; //halves speed
            newYSpeed = (int) ySpeed/2;
            break;
            case 3: newXSpeed = (int) xSpeed*3; //triples speed
            newYSpeed = (int) ySpeed*3;
            break;
            case 4: newXSpeed = (int) xSpeed/3; //thirds the speed
            newYSpeed = (int) ySpeed/3;
            break;
            case 5: newXSpeed = (int) xSpeed*2; //doubles the speed
            newYSpeed = (int) ySpeed*2;
            break;
        }
        if(newXSpeed == 0  || newYSpeed== 0 || newXSpeed >20 || newXSpeed <-20 || newYSpeed <-20 || newYSpeed >20){ //Checks to see that new speed is not zero (due to casting it may round down)
                                                                                                                    // Checks to see that speeds are not greater than 20, or less than -20
                                                                                                                    //This prevents very fast objects.
        }else{
            System.out.println("Changing Xspeed from " + xSpeed + " to" + newXSpeed);
             System.out.println("Changing Yspeed from " + ySpeed + " to " + newYSpeed);
            xSpeed = newXSpeed; //Sets new speed.
            ySpeed = newYSpeed;

        }
    }

    /**
     * Returns half of  the lifetime of the comet.
     */
    public void changeLifeTime()
    {
        lifeTime = lifeTime/2;

    }

    /**
     * Randomly chooses a new colour dependant on a random number generator.
     */
    public void changeColour()
    {
        colours = new ArrayList<Color>();
        colours.add(Color.RED);
        colours.add(Color.BLUE);
        colours.add(Color.CYAN);
        colours.add(Color.GRAY);
        colours.add(Color.PINK);

        Random generator = new Random();
        int i = generator.nextInt(5)-0;
        color = colours.get(i);
    }

    /**
     * Returns the radius of this object.
     */
    public double getRadius(){

        return radius;
    }

    /**
     * @param comets  An Arraylist storing all comets in the current universe.
     * @param planets  An Arraylist storing all planets in the current universe.
     * @param planets  An Arraylist storing all stars in the current universe.
     * @param planets  An Arraylist storing all black holes in the current universe.
     * 
     * This method handles the interaction between comits, planets, stars and black holes.
     * 
     */
    public void cometCollisonDetector(ArrayList<Space_Object> comets, ArrayList<Planet> planets, ArrayList<Star> stars,ArrayList<Black_Hole> holes){
        if(comets.size() != 0){ //Checks to see if anything is in the list.
            for(Space_Object a :comets){//Comparing each comet to every other comet.
                int aXPosition = a.getXPosition();
                int aYPosition = a.getYPosition();
                double aRadius= a.getRadius();
                for(Space_Object c : comets){
                    if(a!=c){   //Makes sure that same comets are not being compared.

                        int aCometType = a.getCometType();        
                        aYPosition = (int) (aYPosition + aRadius);
                        aXPosition = (int) (aXPosition + aRadius);

                        int aXSpeed = a.getXSpeed();
                        int aYSpeed = a.getYSpeed();

                        int aTotalSpeed = aXSpeed+aYSpeed;

                        int cXPosition = c.getXPosition();
                        int cYPosition = c.getYPosition(); 
                        double cRadius= c.getRadius();    
                        cYPosition = (int) (cYPosition + cRadius);
                        cXPosition = (int) (cXPosition + cRadius);
                        int cCometType = c.getCometType();
                        int cXSpeed = c.getXSpeed();
                        int cYSpeed = c.getYSpeed();
                        int cTotalSpeed = cXSpeed+cYSpeed;

                        if(aTotalSpeed <0){     //Reverses totalSpeed if result is negative.
                            aTotalSpeed = -aTotalSpeed ;
                        }
                        if(cTotalSpeed <0){
                            cTotalSpeed = -cTotalSpeed;
                        }

                        double  distance = returnDistance(aXPosition,cXPosition,aYPosition,cYPosition);

                        if(distance < (aRadius+cRadius) && distance!=0){    //Checks to see if the calculated distance is smaller than the combined radius.
                            System.out.println("Collison Detected");

                            if(aCometType==cCometType){ //If comets are the same type bounce off each other.
                                a.xSpeed = a.xSpeed*-1;
                                a.ySpeed = a.ySpeed*-1;

                            }else if(aCometType!=cCometType){//if comets are different types
                                if(aRadius>cRadius){//if comet a is larger than c; remove comet c.
                                    universe.erase(c);
                                    c.lifeTime = 0;

                                }else if(cRadius>aRadius){// if comet c is larger than a; remove comet a.
                                    universe.erase(a);
                                    a.lifeTime = 0;

                                }else if(aTotalSpeed<cTotalSpeed && cRadius==aRadius ){  //if radis are the same, check speed if a is larger remove c.
                                    universe.erase(a);
                                    a.lifeTime = 0 ;

                                }else if(aTotalSpeed>cTotalSpeed && cRadius==aRadius){ //If c's total speed is greater than a; remove a.
                                    universe.erase(c); 
                                    c.lifeTime = 0 ;

                                }else{
                                    if (aTotalSpeed<cTotalSpeed && cRadius==aRadius ){ 
                                        universe.erase(a);
                                        a.lifeTime = 0;
                                    }else{  //If both size and speed are the same; both comets are removed.
                                        universe.erase(a); 
                                        universe.erase(c);
                                        a.lifeTime = 0;
                                        c.lifeTime = 0;

                                    }
                                }
                            }
                        }
                    }
                    if(planets.size() !=0){ //Comparing comets to planets.
                        for(Planet p: planets){
                            int pXPosition = p.getXPosition();
                            int pYPosition = p.getYPosition(); 
                            double pRadius= p.getRadius();    
                            pYPosition = (int) (pYPosition + pRadius);
                            pXPosition = (int) (pXPosition + pRadius);

                            double distance =  Math.sqrt(       //Distance between comet and planet
                                    ((aXPosition-pXPosition)*(aXPosition-pXPosition) +
                                        ((aYPosition-pYPosition)*(aYPosition-pYPosition))
                                    ));

                            if(distance < (aRadius+pRadius) && distance!=0){ //Note: Even if comet is larger than the planet; the planet size is increased.

                                double cometArea = Math.PI *(aRadius*aRadius); //work out area of comet
                                double planetArea = Math.PI * (pRadius*pRadius); //work out area of planet
                                System.out.println("The old planet area " +(int) planetArea); 
                                planetArea = planetArea + cometArea; //add comet area to planet area
                                System.out.println("The new planet area " +(int) planetArea); 
                                int newRadius = (int) Math.sqrt(planetArea/Math.PI); //work out new radius 

                                p.diameter = newRadius*2; // set new radius
                                a.lifeTime = 0; //remove comet.
                                universe.erase(a);

                            }

                        }
                        for(Star s: stars) //Compare comet to stars
                        {
                            int sXPosition = s.getXPosition();
                            int sYPosition = s.getYPosition(); 
                            double sRadius= s.getRadius();    
                            sYPosition = (int) (sYPosition + sRadius);
                            sXPosition = (int) (sXPosition + sRadius);

                            double  distance = returnDistance(aXPosition,sXPosition,aYPosition,sYPosition);

                            if(distance < (aRadius+sRadius) && distance !=0)
                            {
                                a.lifeTime = 0; //removes comet.
                                universe.erase(a);
                                System.out.println("The old lifetime is " + s.lifeTime); 
                                int cometArea = (int)(Math.PI *(aRadius*aRadius)); //sets the lifetime of the star to the previous life time plus the area of the comet.
                                s.lifeTime = s.lifeTime + cometArea;
                                System.out.println("The new lifetime is " + s.lifeTime);
                            }

                        }
                    }
                }
                for(Black_Hole h: holes) //checking comets against black holes.
                {
                    int hXPosition = h.getXPosition();
                    int hYPosition = h.getYPosition(); 
                    double hRadius= h.getRadius();    
                    hYPosition = (int) (hYPosition + hRadius);
                    hXPosition = (int) (hXPosition + hRadius);
                    double  distance = returnDistance(aXPosition,hXPosition,aYPosition,hYPosition);

                    if(distance < (hRadius+aRadius)+40){ //If comet is in range of black hole
                        System.out.println("near a black hole");
                        a.probabilityOfChange = 0; //Makes sure that the 'special' features of the comets are disabled.

                        a.xSpeed = (int) ((hXPosition -aXPosition)/10)*repeatFactor;
                        a.ySpeed = (int) ((hYPosition -aYPosition)/10)*repeatFactor;
                        repeatFactor++;
                    }

                }
            }
        }
    }

    /**
     * Returns the xSpeed for the object.
     */
    public int getXSpeed(){
        return xSpeed;
    }

    /**
     * Returns the ySpeed for the object.
     */
    public int getYSpeed(){
        return ySpeed;
    }

    /**
     * Returns the comet type for the object.
     */
    public int getCometType(){
        return type;

    }

    /**
     * Returns the comet type for the object.
     * @param aXPosition x coord of the first object
     * @param bXPosition x coord of the second object
     * @param aYPosition y coord of the first object
     * @param bYPosition y coord of the second object.
     */
    public double returnDistance(int aXPosition, int bXPosition, int aYPosition, int bYPosition){

        return Math.sqrt( //checking distance
            ((aXPosition-bXPosition)*(aXPosition-bXPosition) +
                ((aYPosition-bYPosition)*(aYPosition-bYPosition))
            ));

    }

}
