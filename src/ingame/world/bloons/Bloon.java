package ingame.world.bloons;

import ingame.world.BloonType;
import ingame.world.DamageType;

// TODO use better design patterns once game is finished
public class Bloon {

    public static final int REGEN_COOLDOWN = 60;

    private BloonType curBloon;
    private BloonType maxBloon;
    private int health;
    private int regenTimer;
    private boolean regen;
    private boolean camo;
    private boolean dartResistant;
    private boolean explosionResistant;
    private boolean freezeResistant;


    public Bloon() {

    }

    public void damage(int damage, DamageType damageType) {
        health -= damage;
        if (health <= 0) {

        }
    }
}
