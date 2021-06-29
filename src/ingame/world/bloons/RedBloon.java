package ingame.world.bloons;

import ingame.world.BloonType;
import ingame.world.DamageType;
import ingame.world.World;

public class RedBloon extends Bloon{
    public RedBloon(boolean regen, boolean camo, BloonType maxBloon) {
        super(regen, camo, maxBloon);
    }

    @Override
    public void damage(int layers, DamageType damageType, World world) {
        world.remove(this);
    }

    @Override
    public void regenerate(World world) {
        if (maxBloon != BloonType.RED) {
            world.remove(this);
            world.add(new BlueBloon(regen, camo, maxBloon));
        }
    }
}
