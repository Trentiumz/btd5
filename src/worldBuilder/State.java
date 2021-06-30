package worldBuilder;

public abstract class State {
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
