import greenfoot.*;  // (Actor, World, Greenfoot, GreenfootImage)

public class CrabWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x560 cells, where every cell is just 1 pixel.
     */
    public CrabWorld() 
    {
        super(560, 560, 1);

        prepare();
    }
    
    /**
     * prepare prepares the world for the game by adding a Crab in the centre of the world,
     * six Worms in random locations, and two Lobsters (one randomly on the left side of the
     * screen and one randomly on the right side of the screen)
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void prepare()
    {
        addObject(new Crab(), getWidth()/2, getHeight()/2);
        
        addObject( new Worm(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()) );
        addObject( new Worm(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()) );
        addObject( new Worm(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()) );
        addObject( new Worm(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()) );
        addObject( new Worm(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()) );
        addObject( new Worm(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()) );
        
        addObject( new Lobster(), Greenfoot.getRandomNumber(getWidth()/2), Greenfoot.getRandomNumber(getHeight()) );
        addObject( new Lobster(), Greenfoot.getRandomNumber(getWidth()/2) + getWidth()/2, Greenfoot.getRandomNumber(getHeight()) );
    }
    
    /**
     * act is the method that runs during every act cycle of the scenario
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    public void act()
    {
        checkForWin();
    }
    
    /**
     * checkForWin checks to see if the user has eaten all worms. If so, the player
     * hears a winning sound and the scenario stops
     * 
     * @param None There are no parameters
     * @return Nothing is returned
     */
    private void checkForWin()
    {
        if( getObjects(Worm.class).isEmpty() == true )
        {
            Greenfoot.playSound("fanfare.wav");
            Greenfoot.stop();
        }
    }
}



