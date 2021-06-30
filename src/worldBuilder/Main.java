package worldBuilder;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {
    public static float pathInterval = 2;
    public static String curMapName = "park_path";
    PImage background;
    PFont font;

    State curState;
    public ArrayList<PVector> pairs = new ArrayList<>();
    public ArrayList<Circle> vanityCircles = new ArrayList<>();
    public ArrayList<Circle> waterCircles = new ArrayList<>();

    public void settings() {
        size(main.Main.DEFAULT_WIDTH, main.Main.DEFAULT_HEIGHT);
    }

    public void setup() {
        frameRate(30);
        background = loadImage("maps/" + curMapName + "/img.png");
        background.resize(width, height);
        curState = new PairsHandler(this);
        font = createFont("Arial", 20);
    }

    public void draw() {
        if(curState != null){
            image(background, 0, 0);
            curState.tick();
            curState.render();

            fill(255, 255, 255, 100);
            noStroke();
            rect(width - 300, 0, 300, 300);
            fill(0);
            textFont(font);
            textAlign(CENTER);
            text(curState.getInstructions(), width - 300, 0, 300, 300);
        }else{
            ArrayList<String> toSave = new ArrayList<>();
            toSave.add("" + pairs.size());
            for(PVector p : pairs)
                toSave.add(p.x + " " + p.y);
            toSave.add("" + vanityCircles.size());
            for(Circle c : vanityCircles)
                toSave.add(c.center.x + " " + c.center.y + " " + c.radius);
            toSave.add("" + waterCircles.size());
            for(Circle c : waterCircles)
                toSave.add(c.center.x + " " + c.center.y + " " + c.radius);
            String[] t = new String[toSave.size()];
            toSave.toArray(t);
            saveStrings("data/maps/" + curMapName + "/info.txt", t);
            exit();
        }
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
