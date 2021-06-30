package ingame.world.bloons;

import ingame.world.BloonType;
import ingame.world.DamageType;
import ingame.world.Entity;
import ingame.world.World;
import processing.core.PVector;

/**
 * The bloon class provides the blueprint for all types of bloons.
 *
 * The class extends the Entity interface, which is the blueprint for
 * all objects in the world.
 * @see Entity
 *
 */

public abstract class Bloon extends Entity {

    /**
     * This constant represents the cooldown, in frames, that bloons
     * that with the {@code regen} tag must wait after their
     * last regeneration.
     *
     */

    public static final int REGEN_COOLDOWN = 60;

    /**
     * Bloon properties.
     *
     * {@code maxBloon} indicates the maximum type of bloon an instance
     * can be. This value is static for bloons with the {@code regen} set
     * to false.
     *
     * {@code regenTimer} indicates the time elapsed since the last regeneration.
     *
     * {@code regen} indicates whether the bloon is able to regenerate.
     *
     * {@code camo} indicates whether the bloon is camouflaged, which means only certain
     * bloons and bloon upgrades are able to pop them.
     *
     */

    protected BloonType maxBloon;
    protected int regenTimer;
    protected boolean regen;
    protected boolean camo;

    /**
     * Constructor for bloons.
     * @param regen
     * Whether the bloon is able to regenerate.
     * @param camo
     * Whether the bloon is camouflaged, which means only certain
     * bloons and bloon upgrades are able to pop them.
     * @param maxBloon
     * The maximum type of bloon an instance can be.
     *
     * @param center
     * This parameter is based off of the entity superclass.
     * @param radius
     * This parameter is based off of the entity superclass.
     * @see Entity
     */

    public Bloon(boolean regen, boolean camo, BloonType maxBloon, PVector center, float radius) {
        super(center, radius);
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
