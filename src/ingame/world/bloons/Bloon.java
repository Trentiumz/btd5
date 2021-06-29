package ingame.world.bloons;

import ingame.world.BloonType;
import ingame.world.DamageType;
import ingame.world.World;

public abstract class Bloon {

    public static final int REGEN_COOLDOWN = 60;

    protected BloonType maxBloon;
    protected int regenTimer;
    protected boolean regen;
    protected boolean camo;


    public Bloon(boolean regen, boolean camo, BloonType maxBloon) {
        this.regen = regen;
        this.camo = camo;
        this.maxBloon = maxBloon;
        regenTimer = 0;
    }

    public void tick() {
        if(regen){
            regenTimer -= 1;
            if(regenTimer <= 0){
                regenerate(World.curWorld);
                regenTimer = REGEN_COOLDOWN;
            }
        }
    }

    public void render() {

    }

    public abstract void damage(int layers, DamageType damageType, World world);
    public abstract void regenerate(World world);
}
