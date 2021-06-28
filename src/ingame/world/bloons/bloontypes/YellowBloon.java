package ingame.world.bloons.bloontypes;

import ingame.world.bloons.BloonType;
import processing.core.PVector;

public class YellowBloon extends BloonType {
    public YellowBloon(PVector center, float radius) {
        super(center, radius);
    }

    @Override
    public BloonType[] getChild() {
        return new BloonType[]{new GreenBloon(center, radius)};
    }

    @Override
    public void tick() {

    }

    @Override
    public void render() {

    }
}
