package worldBuilder;

import processing.core.PVector;

import java.util.ArrayList;

public class VanityHandler extends State {
    ArrayList<Circle> circles;
    PVector curCenter;

    VanityHandler(Main owner) {
        super(owner);
        circles = new ArrayList<>();
    }

    @Override
    void tick() {
    }

    @Override
    void render() {
        instance.fill(255, 0, 0, 50);
        instance.noStroke();
        for (Circle circle : circles) instance.circle(circle.center.x, circle.center.y, circle.radius);
        if (curCenter != null) {
            instance.fill(0, 0, 0, 0);
            instance.stroke(255);
            instance.strokeWeight(2);
            instance.circle(curCenter.x, curCenter.y, 2 * distanceFromCenter());
        }
    }

    @Override
    void mousePressed() {
        if (curCenter == null) curCenter = new PVector(instance.mouseX, instance.mouseY);
        else {
            circles.add(new Circle(curCenter, 2 * distanceFromCenter()));
            curCenter = null;
        }
    }

    @Override
    void keyPressed() {
        if(instance.key == 'z') {
            if (circles.size() > 0) circles.remove(circles.size() - 1);
        } else{
            instance.curState = new WaterHandler(instance);
            instance.vanityCircles = circles;
        }
    }

    @Override
    String getInstructions() {
        return "left click to set the center of the circle of a part of the \"vanity\", click again to set the size of the circle (denoted by the outline). Press 'z' to undo, and any other key to continue";
    }

    private float distanceFromCenter() {
        return new PVector(instance.mouseX, instance.mouseY).sub(curCenter).mag();
    }
}
