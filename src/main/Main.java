package main;

import processing.core.PApplet;

public class Main extends PApplet {
    public static Main client = null;
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

    public void settings() {
        size(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"main.Main"});
    }
}
