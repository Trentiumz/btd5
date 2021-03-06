package main;

import menu.MenuState;
import processing.core.PApplet;

public class Main extends PApplet {

    public static Main client = null;
    private static final boolean[] charPressed = new boolean[500];
    private static final boolean[] codePressed = new boolean[500];

    private State activeState;

    public static final int DEFAULT_WIDTH = 1000;
    public static final int DEFAULT_HEIGHT = 800;
    public static final int DEFAULT_FRAME_RATE = 30;

    public static void main(String[] args) {
        PApplet.main(new String[]{"main.Main"});
    }

    public void settings() {
        size(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Main() {
        if (client != null) {
            throw new RuntimeException("Singleton main.Main Client was Initialized a second time!");
        }
        client = this;
    }

    public void setup() {
        frameRate(DEFAULT_FRAME_RATE);
        activeState = new MenuState();
        activeState.setup();
    }

    public void draw() {
        activeState.tick();
        activeState.render();
    }

    public void keyPressed(){
        if(key < charPressed.length){
            charPressed[key] = true;
        }
        if(keyCode < codePressed.length){
            codePressed[keyCode] = true;
        }
        activeState.keyPressed();
    }

    public void keyReleased(){
        if(key < charPressed.length){
            charPressed[key] = false;
        }
        if(keyCode < codePressed.length){
            codePressed[keyCode] = false;
        }
        activeState.keyReleased();
    }

    public void mousePressed(){
        activeState.mousePressed();
    }

    public void mouseReleased(){
        activeState.mouseReleased();
    }

    /**
     * returns if the char k is pressed
     * @param k the character
     * @return if k is pressed
     */
    public boolean pressed(char k){
        return charPressed[k];
    }

    /**
     * returns if the keyCode is pressed
     * @param code the key code
     * @return if code is pressed
     */
    public boolean pressed(int code){
        return codePressed[code];
    }
}
