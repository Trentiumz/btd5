package main;

/**
 * States
 */

public interface State {
    void setup();
    void tick();
    void render();
    void keyPressed();
    void keyReleased();
    void mousePressed();
    void mouseReleased();
}
