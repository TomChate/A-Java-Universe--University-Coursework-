import java.util.Scanner;
/**
 * Class Menu used for navigating around the coursework.
 * 
 * @author T.CHATE
 * @version 10/3/2016
 */
public class Menu

{
    private int selection;
    private Scanner reader;

    public Menu()
    {
        selection = -1;
        reader = new Scanner(System.in);
    }

    public void displayMenu()
    {
        while(true){
            System.out.println("       774061 UNIVERSE");
            System.out.println("");
            System.out.println("1:  Comets Bouncing Of Edges");
            System.out.println("2:  Planets Orbiting A Star");
            System.out.println("3:  Comet Type 1, with 100% Change Rate");
            System.out.println("4:  Comet Type 1 with 505 Change Rate");
            System.out.println("5:  Comet Type 4 with 100% Change Rate"); 
            System.out.println("6:  Comet Type 4 with 50% Change Rate"); 
            System.out.println("7:  Comet Dying"); 
            System.out.println("8:  Comets of Same Type Colliding");
            System.out.println("9:  Comets of Differnt Types and different sizes"); 
            System.out.println("10: Comets of Differnt Types and different speeds but same size");
            System.out.println("11: Comets of Differnt Types, same speed and same size"); 
            System.out.println("12: Comet hitting a Planet"); 
            System.out.println("13: Comet hitting a Star"); 
            System.out.println("14: Comet hitting a Black Hole"); 
            System.out.println("15: A Mini Solar System"); 
            optionChoser(returnInput());

        }
    }

    public int returnInput(){

        System.out.println(" Please input your selection:");
        selection = reader.nextInt();
        return selection;
    }

    public void optionChoser(int option){
        switch(option){
            case 1: Universe universe1 = new Universe("Comets Bouncing",600,500);
            universe1.wallsBounceDemo();
            break;

            case 2: Universe universe2 = new Universe("Planets Orbitting",600,500);
            universe2.planetOrbitSDemo();
            break;

            case 3: Universe universe3 = new Universe("Comet Type 1 With 100% Change Rate",600,500);
            universe3.comet1Demo100();
            break;

            case 4: Universe universe4 = new Universe("Comet Type 1 With 50% Change Rate",600,500);
            universe4.comet1Demo50();
            break;

            case 5: Universe universe5 = new Universe("Comet Type 4 With 100% Change Rate",600,500);
            universe5.comet4Demo100();
            break;

            case 6: Universe universe6 = new Universe("Comet Type 4 With 50% Change Rate",600,500);
            universe6.comet4Demo50();
            break;

            case 7: Universe universe7 = new Universe("Comet Dying",600,500);
            universe7.cometDying();
            break;

            case 8: Universe universe8 = new Universe("Comets of Same Type Colliding",600,500);
            universe8.sameTypeCollison();
            break;

            case 9: Universe universe9 = new Universe("Comets of Different Type & Different Sizes", 600,500);
            universe9.differentSizesComet();
            break;

            case 10: Universe universe10 = new Universe("Comets of Different Type & Same Size & Different Speed",600,500);
            universe10.differentSpeedsComet();
            break;

            case 11: Universe universe11 = new Universe("Comets of Different Type but Same Size & Speed",600,500);
            universe11.sameSizeandSpeed();
            break;

            case 12: Universe universe12 = new Universe("A Comet Hitting a Planet",600,500);
            universe12.comitHitPlanet();
            break;

            case 13:  Universe universe13 = new Universe("A Comet Hitting a Star",600,500);
            universe13.comitHitStar();
            break;

            case 14:  Universe universe14 = new Universe("Interaction Between Black Hole and a Comet",600,500);
            universe14.cometBlackHole();
            break;

            case 15:   Universe universe15 = new Universe("A Mini Solar System",600,500);
            universe15.miniSolarSystem();
            break;

            default: System.out.println("Please enter a number relating to an option.");

        
        }
    }
}
