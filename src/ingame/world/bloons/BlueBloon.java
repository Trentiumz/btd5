package ingame.world.bloons;

import ingame.world.BloonType;
import ingame.world.DamageType;
import ingame.world.World;
import processing.core.PVector;

public class BlueBloon extends Bloon {
    public BlueBloon(boolean regen, boolean camo, BloonType maxBloon, PVector center) {
        super(regen, camo, maxBloon, center, 5);
    }

    @Override
    public void damage(int layers, DamageType damageType, World world) {
        if (layers > 0) {
            world.remove(this);

            Bloon red = new RedBloon(regen, camo, maxBloon, center);
            world.add(red);

            red.damage(layers - 1, damageType, world);
        }
    }

    @Override
    public void regenerate(World world) {

    }
}
