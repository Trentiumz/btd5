package ingame.world.towers.bomb_tower;

import ingame.world.towers.Tower;
import processing.core.PVector;

public class BombTower extends Tower {
    public BombTower(PVector center) {
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
