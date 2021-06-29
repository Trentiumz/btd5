package ingame.world;

import ingame.world.bloons.Bloon;
import ingame.world.towers.Tower;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.HashSet;

public class World {
    public static World curWorld;
    public ArrayList<PVector> path;

    private HashSet<Bloon> bloons;
    private ArrayList<Tower> towers;
    private ArrayList<Entity> vanity;
    private ArrayList<Entity> water;

    public void remove(Bloon toRemove){

    }
    public void add(Bloon toAdd){

    }

    public boolean canAddTower(boolean onWater, Entity tower){
        // TODO code in logic
        return false;
    }

}
