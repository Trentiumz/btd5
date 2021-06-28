package ingame.world.bloons.bloontypes;

import ingame.world.bloons.BloonType;
import processing.core.PVector;

public class GreenBloon extends BloonType {
    public GreenBloon(PVector center, float radius) {
        super(center, radius);
    }

    @Override
    public BloonType[] getChild() {
        return new BloonType[]{new BlueBloon(center, radius)};
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {

    }
}
