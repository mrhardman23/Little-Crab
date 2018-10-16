import greenfoot.*;

/**
 * This class defines a crab. Crabs live on the beach.
 */
public class Crab extends Actor
{
    // openCrabLegs is a boolean that lets us know if the crab's first image is displayed
    private boolean openCrabLegs = true;
    
    /**
     * act is the method that runs during every act cycle of the scenario
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        walk(2);
        
        checkForWorms();
        
        checkKeys();
    }
    
    private void walk( int distance )
    {
        // Moves distance pixels in the current direction
        move( distance );
        
        if( openCrabLegs == true )
        {
            setImage("crab.png");
            openCrabLegs = false;
        }
        else
        {
            setImage("crab2.png");
            openCrabLegs = true;
        }
    }
    
    /**
     * checkKeys will allow the Crab to complete actions (turns) based on keyboard presses
     * (left and right arrow keys)
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkKeys()
    {
        //If the user presses the left arrow key...
        if( Greenfoot.isKeyDown("left") == true )
        {
            //Turn the crab -5 degrees
            turn(-5);
        }
        else if( Greenfoot.isKeyDown("right") == true ) //Otherwise, if the user presses the right arrow key...
        {
            //Turn the crab 5 degrees
            turn(5);
        }
    }
    
    /**
     * checkForWorms checks if the Crab has touched a Worm
     * and if so, eats the worm (removes the worm from the world)
     * and plays a slurping sound
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkForWorms()
    {
        //If the Crab is touching a Worm...
        if( isTouching(Worm.class) == true )
        {
            //Eat the Worm (remove the Worm from the World)
            removeTouching(Worm.class);
            Greenfoot.playSound("slurp.wav");
        }
    }
}




