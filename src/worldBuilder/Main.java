package worldBuilder;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {
    public static float pathInterval = 2;
    public static String curMapName = "park_path";
    PImage background;

    State curState;
    public ArrayList<PVector> pairs = new ArrayList<>();

    public void settings() {
        size(main.Main.DEFAULT_WIDTH, main.Main.DEFAULT_HEIGHT);
    }

    public void setup() {
        frameRate(60);
        background = loadImage("maps/" + curMapName + "/img.png");
        background.resize(width, height);
        curState = new PairsHandler(this);
    }

    public void draw() {
        image(background, 0, 0);
        curState.tick();
        curState.render();
    }

    public void keyPressed() {
        curState.keyPressed();
    }

    public void keyReleased() {
        curState.keyReleased();
    }

    public void mousePressed() {
        curState.mousePressed();
    }

    public void mouseReleased() {
        curState.mouseReleased();
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"worldBuilder.Main"});
    }
}
