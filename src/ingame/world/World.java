package ingame.world;

import ingame.world.bloons.Bloon;
import ingame.world.towers.Projectile;
import ingame.world.towers.Tower;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class World {
    private static World curWorld;
    public List<PVector> path;

    private Set<Bloon> bloons;
    private Set<Projectile> projectiles;
    private List<Tower> towers;
    private List<Entity> vanity;
    private List<Entity> water;

    private World() {
        setup();
    }

    public static World getWorld() {
       if (curWorld == null) {
           curWorld = new World();
       }
       return curWorld;
    }

    private void setup() {
        path = new ArrayList<>();
        bloons = new HashSet<>();
        projectiles = new HashSet<>();
        towers = new ArrayList<>();
        vanity = new ArrayList<>();
        water = new ArrayList<>();
    }

    public void tick() {
        for (Bloon bloon : bloons) {
            bloon.tick();
        }
        for (Projectile projectile : projectiles) {
            projectile.tick();
        }
        for (Tower tower : towers) {
            tower.tick();
        }
    }

    public void render() {

    }

    public void remove(Bloon toRemove){

    }
    public void add(Bloon toAdd){

    }

    public boolean canAddTower(boolean onWater, Entity tower){
        // TODO code in logic
        return false;
    }

}
