package ingame.world.bloons;

import ingame.world.DamageType;
import ingame.world.World;

public class RedBloon extends Bloon{
    public RedBloon(boolean regen, boolean camo) {
        super(regen, camo);
    }

    @Override
    public void damage(int layers, DamageType damageType, World world) {
        world.remove(this);
    }
}
