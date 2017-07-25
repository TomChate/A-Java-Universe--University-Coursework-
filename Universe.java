import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * Class Universe - a universe which contains many methods used for demostrating the coursework.
 *
 * @author Robert Topp & Thomas Chate
 * @version 2016.3.10
 */

public class Universe  
{
    private Canvas universe;
    private int leftEdge = 0;     // coordinates of the edges of the universe
    private int topEdge = 0;
    private int rightEdge;
    private int bottomEdge;
    private ArrayList<Space_Object> comets;
    private ArrayList<Star> stars;
    private ArrayList<Planet> planets;
    private ArrayList<Black_Hole> blackHoles;
    /**
     * Create a universe with default name and size. Creates a fresh canvas to display the universe
     */
    public Universe()
    {
        universe = new Canvas("Universe 774061", 600, 500);
        rightEdge = 600;
        bottomEdge = 500;
        initalizeLists();
    }

    /**
     *  Create a universe with given name and size
     *  @param name The name to give the universe
     *  @param rightEdge The maximum x coordinate
     *  @param bottomEdge The maximum y coordinate
     */
    public Universe(String name, int rightEdge, int bottomEdge)
    {
        universe = new Canvas(name, rightEdge, bottomEdge);
        this.rightEdge = rightEdge;
        this.bottomEdge = bottomEdge;
        initalizeLists();
    }

    /**
     * Initalises arrayLists
     */
    public void initalizeLists()
    {
        comets = new ArrayList<Space_Object>();
        stars = new ArrayList<Star>();
        planets = new ArrayList<Planet>();
        blackHoles = new ArrayList<Black_Hole>();
    }

    /**
     * Erase an object from the view of the universe
     * 
     * @param spaceObj The object to be erased
     */
    public void erase(Space_Object spaceObj)
    {
        universe.eraseCircle(spaceObj.getXPosition(), spaceObj.getYPosition(), spaceObj.getDiameter());
    }

    /**
     * Erase an planet bject from the view of the universe
     * 
     * @param planet The planet to be erased
     */
    public void erasePlanet(Planet planet)
    {
        universe.eraseCircle(planet.getXPosition(), planet.getYPosition(), planet.getDiameter());
    }

    /**
     * Draw an object at its current position onto the view of the universe.
     * 
     * @param spaceObj The object to be drawn
     */
    public void draw(Space_Object spaceObj)
    {
        universe.setForegroundColor(spaceObj.getColor());
        universe.fillCircle(spaceObj.getXPosition(), spaceObj.getYPosition(), spaceObj.getDiameter());
    }

    /**
     * Draw an star object at its current position onto the view of the universe.
     * 
     * @param starToDraw The object to be drawn
     */
    public void drawStar(Star starToDraw){
        universe.setForegroundColor(starToDraw.getColor());
        universe.fillCircle(starToDraw.getXPosition(), starToDraw.getYPosition(), starToDraw.getDiameter());

    }

    /**
     * Draw an planet object at its current position onto the view of the universe.
     * 
     * @param planetToDraw The object to be drawn
     */
    public void drawPlanet(Planet planetToDraw){
        universe.setForegroundColor(planetToDraw.getColor());
        universe.fillCircle(planetToDraw.getXPosition(), planetToDraw.getYPosition(), planetToDraw.getDiameter());

    }

    /**
     * Draw an black hole object at its current position onto the view of the universe.
     * 
     * @param blackHoleToDraw The object to be drawn
     */
    public void drawBlackHole(Black_Hole blackHoleToDraw){
        universe.setForegroundColor(blackHoleToDraw.getColor());
        universe.fillCircle(blackHoleToDraw.getXPosition(), blackHoleToDraw.getYPosition(), blackHoleToDraw.getDiameter());

    }

    /**
     * Return the x cordinate of the right side of the universe
     */
    public int getRightEdge(){
        return rightEdge;

    }

    /**
     * Return the y cordinate of the bottom of the universe
     */
    public int getGround()
    {
        return bottomEdge;
    }

    /**
     * This method demos the ability for comets to bounce of edges of the universe.
     */
    public void wallsBounceDemo(){
        comets.add(new Space_Object(250, 250, 0, 6, 25, Color.BLUE, this,1,0));
        comets.add(new Space_Object(500, 250, -5, 0, 10, Color.RED, this,4,0));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();

                }
            }

        }
    }

    /**
     * This method demos planets orbiting a star.
     */
    public void planetOrbitSDemo(){
        stars.add(new Star(20,250,200,Color.YELLOW,this));

        planets.add(new Planet(Color.BLUE,10,275,250,0.1,stars.get(0),this));
        planets.add(new Planet(Color.RED,17,325,300,0.02,stars.get(0),this));

        for(Star s:stars)
        {
            drawStar(s);
        }
        while(true)
            while(true){
                Iterator<Planet> it = planets.iterator();
                universe.wait(50);
                while(it.hasNext()){

                    Planet p;
                    p = it.next();
                    if(p.getLifeTime()==0){
                        it.remove();
                    }else{    
                        p.orbit();
                        p.orbit();
                    }
                }

        }
    }

    /**
     * Demos comet 1 and its 'special' ablities at a change of them happening set at 100%.
     */
    public void comet1Demo100()
    {
        comets.add(new Space_Object(250, 250, 2, 6, 25, Color.BLUE, this,1,100));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();

                }
            }

        }
    }

    /**
     * Demos comet 1 and its 'special' ablities at a change of them happening set at 50%.
     */
    public void comet1Demo50()
    {
        comets.add(new Space_Object(250, 250, 2, 6, 25, Color.BLUE, this,1,50));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();

                }
            }

        }
    }

    /**
     * Demos comet 4 and its 'special' ablities at a change of them happening set at 100%.
     */
    public void comet4Demo100()
    {
        comets.add(new Space_Object(250, 250, 0, 6, 25, Color.BLUE, this,4,100));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    System.out.println(c.getLifeTime());

                }
            }

        }
    }

    /**
     * Demos comet 4 and its 'special' ablities at a change of them happening set at 50%.
     */
    public void comet4Demo50()
    {
        comets.add(new Space_Object(250, 250, 0, 6, 25, Color.BLUE, this,4,50));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    System.out.println(c.getLifeTime());

                }
            }

        }
    }

    /**
     * Demos a comet dying in a universe. The lifetime is set to a very low number in order to demo this.
     */
    public void cometDying()
    {
        comets.add(new Space_Object(250, 250, 0, 6, 25, Color.BLUE, this,4,0,150));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    System.out.println(c.getLifeTime());

                }
            }

        }
    }

    /**
     * Demos when two comets of the same type hit one another.
     */
    public void sameTypeCollison()
    {
        comets.add(new Space_Object(10, 250, 4, 0, 25, Color.RED, this,4,50));
        comets.add(new Space_Object(490, 250, -4, 0, 25, Color.BLUE, this,4,30));
        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets,planets,stars,blackHoles);

                }
            }

        }
    }

    /**
     * Demos when two comets of differnt types and differnt sizes hit.
     */
    public void differentSizesComet()
    {
        comets.add(new Space_Object(10, 250, 4, 0, 30, Color.RED, this,4,50));
        comets.add(new Space_Object(490, 260, -4, 0, 10, Color.BLUE, this,1,30));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets,planets,stars,blackHoles);

                }
            }

        }
    }

    /**
     * Demos when two comets of differnt types and differnt speeds but same size hit.
     */
    public void differentSpeedsComet()
    {
        comets.add(new Space_Object(10, 250, 2, 0, 30, Color.RED, this,4,50));
        comets.add(new Space_Object(490, 250, -6, 0, 30, Color.BLUE, this,1,30));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets,planets,stars,blackHoles);

                }
            }

        }
    }

    /**
     * Demos when two comets of differnt types and same speeds & same size hit.
     */
    public void sameSizeandSpeed()
    {
        comets.add(new Space_Object(10, 250, 4, 0, 30, Color.RED, this,4,50));
        comets.add(new Space_Object(490, 250, -4, 0, 30, Color.BLUE, this,1,30));

        while(true){
            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets,planets,stars,blackHoles);

                }
            }

        }
    }

    /**
     * Demos when a comet hits a planet.
     */
    public void comitHitPlanet()
    {

        stars.add(new Star(20,250,200,Color.YELLOW,this));
        comets.add(new Space_Object(10, 250, 4, 0, 20, Color.RED, this,4,50));
        planets.add(new Planet(Color.BLUE,10,275,250,0.1,stars.get(0),this));

        for(Star s:stars)
        {
            drawStar(s);
        }
        while(true){
            Iterator<Space_Object> itc = comets.iterator();
            universe.wait(50);   
            while(itc.hasNext()){

                Space_Object c;
                c = itc.next();
                if(c.getLifeTime()==0)
                {
                    itc.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets, planets,stars,blackHoles);
                }
            }

            // small delay
            Iterator<Planet> it = planets.iterator();
            while(it.hasNext()){

                Planet p;
                p = it.next();

                p.orbit();
                p.orbit();

            }  

        }

    }

    /**
     * Demos when a comet hits a star.
     */
    public void comitHitStar()
    {

        stars.add(new Star(20,250,200,Color.YELLOW,this));
        comets.add(new Space_Object(5, 200, 4, 0, 10, Color.RED, this,4,50));
        planets.add(new Planet(Color.BLUE,10,275,250,0.1,stars.get(0),this));

        while(true){
            for(Star s:stars)
            {
                drawStar(s);
            }
            Iterator<Space_Object> itc = comets.iterator();
            universe.wait(50);   
            while(itc.hasNext()){

                Space_Object c;
                c = itc.next();
                if(c.getLifeTime()==0)
                {
                    itc.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets, planets,stars,blackHoles);
                }
            }

            // small delay
            Iterator<Planet> it = planets.iterator();
            while(it.hasNext()){

                Planet p;
                p = it.next();

                p.orbit();
                p.orbit();

            }  

        }

    }

    /**
     * Demos when a comet goes near a black hole.
     */
    public void cometBlackHole()
    {
        blackHoles.add(new Black_Hole(60,250,200,this));

        comets.add(new Space_Object(500, 250, -5, 0, 10, Color.RED, this,4,0));

        while(true){

            Iterator<Space_Object> it = comets.iterator();
            universe.wait(50);           // small delay
            while(it.hasNext()){

                Space_Object c;
                c = it.next();
                if(c.getLifeTime()==0)
                {
                    it.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets, planets,stars,blackHoles);
                }
            }
            for(Black_Hole b: blackHoles)
            {
                drawBlackHole(b);
            }

        }
    }

    public void miniSolarSystem(){
        stars.add(new Star(20,250,200,Color.YELLOW,this));
        planets.add(new Planet(Color.BLUE,10,275,250,0.1,stars.get(0),this));
        planets.add(new Planet(Color.RED,15,310,285,0.03,stars.get(0),this));
        planets.add(new Planet(Color.GRAY,20,350,325,0.02,stars.get(0),this));
        comets.add(new Space_Object(100, 150, 1, -2, 10, Color.BLUE, this,4,70));
        comets.add(new Space_Object(300, 450, -3, 2, 7, Color.RED, this,4,10));

        comets.add(new Space_Object(400, 100, 0, 1, 10, Color.RED, this,4,100));

        comets.add(new Space_Object(300, 200, 3, 2, 15, Color.CYAN, this,1,20));
        comets.add(new Space_Object(500, 280, 1, 1, 5, Color.GRAY, this,1,60));
        comets.add(new Space_Object(10, 480, 1, 6, 5, Color.BLUE, this,4,25));
        while(true)
        {
            for(Star s:stars)
            {
                drawStar(s);
            }
            for(Black_Hole b: blackHoles)
            {
                drawBlackHole(b);
            }
            Iterator<Space_Object> itc = comets.iterator();
            universe.wait(50);   
            while(itc.hasNext()){

                Space_Object c;
                c = itc.next();
                if(c.getLifeTime()==0)
                {
                    itc.remove();        
                }else{
                    c.move();
                    c.cometCollisonDetector(comets, planets,stars,blackHoles);
                }
            }

            // small delay
            Iterator<Planet> it = planets.iterator();
            while(it.hasNext()){

                Planet p;
                p = it.next();

                p.orbit();
                p.orbit();

            }  

    
    
        }
    
    }
}
