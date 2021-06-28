package ingame.world.bloons.bloontypes;

import ingame.world.bloons.BloonType;
import processing.core.PVector;

public class RedBloon extends BloonType {
    public RedBloon(PVector center, float radius) {
        super(center, radius);
    }

    @Override
    public BloonType[] getChild() {
        return null;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {

    }
}
