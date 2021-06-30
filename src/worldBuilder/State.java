package worldBuilder;

public abstract class State {
    Main instance;
    State(Main owner){
        this.instance = owner;
    }

    abstract void tick();
    abstract void render();
    void keyPressed(){

    }
    void keyReleased(){

    }
    void mousePressed(){

    }
    void mouseReleased(){

    }
    abstract String getInstructions();
}
