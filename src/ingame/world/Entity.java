package ingame.world;

import processing.core.PVector;

public abstract class Entity {
    PVector center;
    float radius;

    public abstract void render();
}
