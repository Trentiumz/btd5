package ingame.world;

import processing.core.PVector;

public abstract class Entity {
    public PVector center;
    public float radius;

    public Entity(PVector center, float radius){
        this.center = center;
        this.radius = radius;
    }

    public abstract void render();
}
