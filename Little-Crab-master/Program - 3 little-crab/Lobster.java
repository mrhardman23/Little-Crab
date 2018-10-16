import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lobster extends Actor
{
    /**
     * act is the method that runs during every act cycle of the scenario
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void act() 
    {
        turnAwayAtEdge();
        
        checkForCrab();
        
        walk();
    } 
    
    /**
     * walk is responsible for making the Lobster move randomly. Twenty-five percent
     * of the time, the Lobster turns. When it turns, fifty percent of the time it turns
     * counterclockwise 5 degrees and the other fifty percent of the time it turns
     * clockwise 5 degrees. The Lobster moves in the current direction 2 pixels after that
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void walk()
    {
        //If the random number generated is less than 25 (the statement will only be true 25% of the time)...
        if( Greenfoot.getRandomNumber(100) < 25 )
        {
            //If the next random number generated is less than 1 (the statement will only be true 50% of the time)...
            if( Greenfoot.getRandomNumber(2) < 1 )
            {
                //Turn counterclockwise 5 degrees
                turn(-5);
            }
            else //Otherwise...
            {
                //Turn clockwise 5 degrees
                turn(5);
            }
        }
        
        //Then, move 2 pixels in the current direction
        move(2);
    }
    
    /**
     * turnAwayAtEdge will make the Lobster turn 180 degrees when it reaches the edge of
     * the world
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void turnAwayAtEdge()
    {
        if( isAtEdge() == true )
        {
            turn(180);
        }
    }
    
    /**
     * checkForCrab checks to see if the Lobster has run into a Crab
     * and, if so, the Lobster eats the Crab (the Crab gets removed from the world).
     * Then, an "Ow!" sound gets played to represent the player losing
     */
    private void checkForCrab()
    {
        if( isTouching(Crab.class) == true )
        {
            removeTouching(Crab.class);
            Greenfoot.playSound("au.wav");
        }
    }
}
