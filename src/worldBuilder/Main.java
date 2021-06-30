package worldBuilder;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;

/**
 * Main class for the world building
 */
public class Main extends PApplet {
    public static float pathInterval = 2;
    public static String curMapName = "park_path"; // current map name

    PImage background;
    PFont font;

    State curState;

    // information for each state, which we're going to store
    public ArrayList<PVector> pairs = new ArrayList<>();
    public ArrayList<Circle> vanityCircles = new ArrayList<>();
    public ArrayList<Circle> waterCircles = new ArrayList<>();

    public void settings() {
        size(main.Main.DEFAULT_WIDTH, main.Main.DEFAULT_HEIGHT);
    }

    public void setup() {
        frameRate(30);
        // load in the background from the current map we're using
        background = loadImage("maps/" + curMapName + "/img.png");
        background.resize(width, height);

        // set the state to starting with the path
        curState = new PathHandler(this);
        font = createFont("Arial", 20);
    }

    public void draw() {
        if(curState != null){
            // if we are still in a state, then let it tick & render
            image(background, 0, 0);
            curState.tick();
            curState.render();

            // fill in a text box with the instructions
            fill(255, 255, 255, 100);
            noStroke();
            rect(width - 300, 0, 300, 300);
            fill(0);
            textFont(font);
            textAlign(CENTER);
            text(curState.getInstructions(), width - 300, 0, 300, 300);
        }else{
            // if curState is null, then we're done with everything, so we can save it
            ArrayList<String> toSave = new ArrayList<>();

            // add each of the properties into toSave
            toSave.add("" + pairs.size());
            for(PVector p : pairs)
                toSave.add(p.x + " " + p.y);
            toSave.add("" + vanityCircles.size());
            for(Circle c : vanityCircles)
                toSave.add(c.center.x + " " + c.center.y + " " + c.radius);
            toSave.add("" + waterCircles.size());
            for(Circle c : waterCircles)
                toSave.add(c.center.x + " " + c.center.y + " " + c.radius);

            // save the ArrayList into a String[]
            String[] t = new String[toSave.size()];
            toSave.toArray(t);

            // save the strings
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
