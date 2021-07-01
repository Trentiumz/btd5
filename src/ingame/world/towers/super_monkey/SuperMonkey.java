package ingame.world.towers.super_monkey;

import ingame.world.towers.Tower;
import processing.core.PImage;
import processing.core.PVector;

public class SuperMonkey extends Tower {
    public SuperMonkey(PVector center) {
        // TODO set proper defaults
        super(null, null, null, 0, null, 0, center, 0, 0);
    }

    @Override
    protected boolean canAttack() {
        return false;
    }

    @Override
    protected void attack() {

    }

    @Override
    public void render() {

    }
}
