package worldBuilder;

import processing.core.PVector;

import java.util.ArrayList;

public class PairsHandler extends State{
    ArrayList<PVector> pairs = new ArrayList<>();
    Main instance;

    PairsHandler(Main owner){
        this.instance = owner;
    }

    @Override
    public void tick() {
        if (instance.mousePressed) {
            pairs.add(new PVector(instance.mouseX, instance.mouseY));
        }
    }

    @Override
    public void render() {
        instance.stroke(0, 0, 255);
        instance.strokeWeight(2);
        for (PVector p : pairs) instance.point(p.x, p.y);
    }

    @Override
    public void keyPressed() {
        ArrayList<PVector> completed = new ArrayList<>();
        completed.add(pairs.get(0));
        PVector lastPair = pairs.get(0);
        int moveTo = 1;
        float distLeft = Main.pathInterval;

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
                distLeft = Main.pathInterval;
            }
        }
        pairs = completed;
        instance.pairs = pairs;
    }

    @Override
    String getInstructions() {
        return "Trace out the path that bloons should take. Press any key to render the mouse movements and progress to the next step";
    }
}
