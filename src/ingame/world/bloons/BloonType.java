package ingame.world.bloons;

import ingame.world.Entity;
import processing.core.PVector;

public abstract class BloonType extends Entity {
    public BloonType(PVector center, float radius) {
        super(center, radius);
    }

    public abstract BloonType[] getChild();
    public abstract void tick();
    public abstract void render();
}
