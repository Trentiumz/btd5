package ingame.world;

import ingame.world.bloons.Bloon;
import ingame.world.towers.Tower;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.HashSet;

public class World {
    public static World curWorld;
    private HashSet<Bloon> bloons;
    private ArrayList<Tower> towers;
    ArrayList<PVector> path;
    ArrayList<Entity> vanity;
    ArrayList<Entity> water;

    public void remove(Bloon toRemove){

    }
    public void add(Bloon toAdd){

    }
}
