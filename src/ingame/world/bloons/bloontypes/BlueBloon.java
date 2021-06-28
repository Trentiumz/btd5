package ingame.world.bloons.bloontypes;

import ingame.world.bloons.BloonType;
import processing.core.PVector;

public class BlueBloon extends BloonType {
    public BlueBloon(PVector center, float radius) {
        super(center, radius);
    }

    @Override
    public BloonType[] getChild() {
        return new BloonType[]{new RedBloon(center, radius)};
    }

    @Override
    public BloonType[] getParent() {
        return new BloonType[]{new GreenBloon(center, radius)};
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {

    }
}
