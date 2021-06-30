package worldBuilder;

import processing.core.PVector;

import java.util.ArrayList;

public class PairsHandler extends State {
    ArrayList<PVector> pairs = new ArrayList<>();
    public static final float circleRad = 50;

    int curState = 0;
    int curInd = 0;

    PairsHandler(Main owner) {
        super(owner);
    }

    @Override
    public void tick() {
        if (curState == 0) {
            if (instance.mousePressed) {
                pairs.add(new PVector(instance.mouseX, instance.mouseY));
            }
        }else{
            curInd++;
            if(curInd >= pairs.size()){
                instance.curState = new VanityHandler(instance);
            }
        }
    }

    @Override
    public void render() {
        if (curState == 0) {
            instance.stroke(0, 0, 255);
            instance.strokeWeight(2);
            for (PVector p : pairs) instance.point(p.x, p.y);
        }else{
            instance.fill(0);
            instance.noStroke();
            if(curInd < pairs.size()) instance.circle(pairs.get(curInd).x, pairs.get(curInd).y, circleRad);
        }
    }

    @Override
    public void keyPressed() {
        if (curState == 0) {
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
            curState = 1;
        }
    }

    @Override
    String getInstructions() {
        return "Trace out the path that bloons should take. Press any key to render the mouse movements and progress to the next step";
    }
}
