package worldBuilder;

public abstract class State {
    /**
     * An instance of main, helpful for transitioning states, updating variables for when we need storage at the end, and drawing
     */
    Main instance;

    State(Main owner){
        this.instance = owner;
    }

    /**
     * "Logic" Updates, abstracted into each state
     */
    abstract void tick();

    /**
     * Drawing the current state onto the screen
     */
    abstract void render();

    void keyPressed(){

    }
    void keyReleased(){

    }
    void mousePressed(){

    }
    void mouseReleased(){

    }

    /**
     * @return the instructions to display to the user while in the current state
     */
    abstract String getInstructions();
}
