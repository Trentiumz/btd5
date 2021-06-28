package menu;

/**
 * state for the menu screens
 */
public interface MenuScreen {
    void tick();
    void render();
    void keyPressed();
    void keyReleased();
    void mousePressed();
    void mouseReleased();
}
