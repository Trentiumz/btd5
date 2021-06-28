package main;

import processing.core.PApplet;

public class Main extends PApplet {

    public static Main client = null;
    private static final boolean[] charPressed = new boolean[500];
    private static final boolean[] codePressed = new boolean[500];

    public static final int DEFAULT_WIDTH = 1000;
    public static final int DEFAULT_HEIGHT = 800;
    public static final int DEFAULT_FRAME_RATE = 30;

    public Main() {
        if (client != null) {
            throw new RuntimeException("Singleton main.Main Client was Initialized a second time!");
        }
        client = this;
    }

    public void setup() {
        frameRate(DEFAULT_FRAME_RATE);
    }

    public void draw() {
        rect(100, 100, 100, 100);
    }

    public void keyPressed(){
        if(key < charPressed.length){
            charPressed[key] = true;
        }
        if(keyCode < codePressed.length){
            codePressed[key] = true;
        }
    }

    public void keyReleased(){
        if(key < charPressed.length){
            charPressed[key] = false;
        }
        if(keyCode < codePressed.length){
            codePressed[key] = false;
        }
    }

    public void settings() {
        size(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"main.Main"});
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
