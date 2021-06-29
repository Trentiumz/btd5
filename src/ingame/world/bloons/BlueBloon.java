package ingame.world.bloons;

import ingame.world.DamageType;
import ingame.world.World;

public class BlueBloon extends Bloon {
    public BlueBloon(boolean regen, boolean camo) {
        super(regen, camo);
    }

    @Override
    public void damage(int layers, DamageType damageType, World world) {
        if (layers > 0) {
            world.remove(this);

            Bloon red = new RedBloon(regen, camo);
            world.add(red);

            red.damage(layers - 1, damageType, world);
        }
    }
}
