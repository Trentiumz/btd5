package worldBuilder;

import processing.core.PVector;

import java.util.ArrayList;

public class PathHandler extends State {
    ArrayList<PVector> pairs = new ArrayList<>();
    public static final float circleRad = 50;

    int curState = 0; // current state
    int curInd = 0; // current index for when the circle is

    PathHandler(Main owner) {
        super(owner);
    }

    @Override
    public void tick() {
        if (curState == 0) {
            // in state 0, we're getting the user input for the path
            if (instance.mousePressed) {
                pairs.add(new PVector(instance.mouseX, instance.mouseY));
            }
        }else{
            // in state 1, we animate the circle, once we're at the end of the path go to the next state
            curInd++;
            if(curInd >= pairs.size()){
                instance.curState = new VanityHandler(instance);
            }
        }
    }

    @Override
    public void render() {
        if (curState == 0) {
            // draw the dots for the path
            instance.stroke(0, 0, 255);
            instance.strokeWeight(2);
            for (PVector p : pairs) instance.point(p.x, p.y);
        }else{
            // draw the circle following the path
            instance.fill(0);
            instance.noStroke();
            if(curInd < pairs.size()) instance.circle(pairs.get(curInd).x, pairs.get(curInd).y, circleRad);
        }
    }

    @Override
    public void keyPressed() {
        if (curState == 0) {
            // in state 0, we need to convert the path coordinates into a "constant speed"
            ArrayList<PVector> completed = new ArrayList<>();

            // add the first coordinate
            completed.add(pairs.get(0));
            PVector lastPair = pairs.get(0);

            // index for which coordinate we're moving to
            int moveTo = 1;
            float distLeft = Main.pathInterval;

            while (moveTo < pairs.size()) {
                // the vector to the place we're moving to (moveTo) from lastPair
                PVector vectorTo = pairs.get(moveTo).copy().sub(lastPair);
                float distTo = vectorTo.mag();
                if (distTo < distLeft) {
                    // if the distance to the vector is less than the distance we need to traverse, continue the moving
                    lastPair = pairs.get(moveTo);
                    distLeft -= distTo;
                    moveTo++;
                } else {
                    // if the distance to the vector is more, then we traverse the distance left, add it to completed, and set lastPair
                    PVector getsTo = vectorTo.copy().mult(distLeft / distTo);
                    completed.add(lastPair.copy().add(getsTo));
                    lastPair = lastPair.copy().add(getsTo);
                    distLeft = Main.pathInterval;
                }
            }
            // set the pairs to the fixed array
            pairs = completed;

            // update the storage variable in main
            instance.pairs = pairs;

            // set the current state to the animation
            curState = 1;
        }else{
            // if we're playing the animation and press a key, then we just continue
            instance.curState = new VanityHandler(instance);
        }
    }

    @Override
    String getInstructions() {
        return "Trace out the path that bloons should take. Press any key to render the mouse movements and progress to the next step";
    }
}
