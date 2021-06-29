package ingame.world.bloons;

public class Bloon {
    BloonType curBloon;
    BloonType startingBloon; // a reference to the starting balloon so that regrows don't overgrow?

    public Bloon(BloonType startingBloon) {
        this.curBloon = startingBloon;
    }
}
