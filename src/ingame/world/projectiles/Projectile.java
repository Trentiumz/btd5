package ingame.world.projectiles;

import ingame.world.Entity;
import processing.core.PVector;

public abstract class Projectile extends Entity {

    public Projectile(PVector center, float radius) {
        super(center, radius);
    }

    public abstract void tick();
    public abstract void render();
}
