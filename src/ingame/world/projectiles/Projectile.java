package ingame.world.projectiles;

import ingame.world.Entity;

public abstract class Projectile extends Entity {

    abstract void tick();

    @Override
    public void render() {

    }
}
