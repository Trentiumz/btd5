package worldBuilder;

import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<PVector> pairs = new ArrayList<>();
    int curState = 0;
    int curInd = 0;
    public static final String curWorld = "";


    public void settings() {
        size(400, 400);
    }

    public void setup() {
        frameRate(30);
    }

    public void draw() {
        background(255);
        if (curState == 0) {
            if (mousePressed) {
                pairs.add(new PVector(mouseX, mouseY));
            }
        }
    }

    public void keyPressed() {
        curState = 1;
        float completedInterval = 10;
        ArrayList<PVector> completed = new ArrayList<>();
        completed.add(pairs.get(0));
        PVector lastPair = pairs.get(0);
        int moveTo = 1;
        float distLeft = completedInterval;

        while (moveTo < pairs.size()) {
            PVector vectorTo = pairs.get(moveTo).copy().sub(lastPair);
            float distTo = vectorTo.mag();
            if (distTo < distLeft) {
                lastPair = pairs.get(moveTo);
                distLeft -= distTo;
                moveTo++;
            } else {
                PVector getsTo = vectorTo.copy().mult(distLeft / distTo);
                completed.add(lastPair.copy().add(getsTo));
                lastPair = lastPair.copy().add(getsTo);
                distLeft = completedInterval;
            }
        }
        pairs = completed;
    }

    public static void main(String[] args) {
        PApplet.main(new String[]{"worldBuilder.Main"});
    }
}
