package ingame.world.towers;

import ingame.world.Entity;
import processing.core.PImage;
import processing.core.PVector;

public abstract class Tower extends Entity {

    int leftLevel, rightLevel;
    PImage upgradingIcon;
    int[] leftCosts, rightCosts;
    int initialCost;
    int popCount;
    String displayName;

    int targetInd;
    String[] targetType;

    int framesPerAttack;
    int attackTimer;

    float towerRange;

    public Tower(int leftLevel, int rightLevel, PImage upgradingIcon, int[] leftCosts, int[] rightCosts, int initialCost,
                 String displayName, String[] targetType, int framesPerAttack, PVector center, float towerArea, float towerRange) {
        super(center, towerArea);
        this.towerRange = towerRange;
        this.upgradingIcon = upgradingIcon;
        this.leftLevel = leftLevel;
        this.rightLevel = rightLevel;
        this.leftCosts = leftCosts;
        this.rightCosts = rightCosts;
        this.initialCost = initialCost;
        this.displayName = displayName;
        this.targetType = targetType;
        this.targetInd = 0;
        this.popCount = 0;
        this.framesPerAttack = framesPerAttack;
        this.attackTimer = framesPerAttack;
    }

    public Tower(PImage upgradingIcon, int[] leftCosts, int[] rightCosts, int initialCost, String displayName,
                 int framesPerAttack, PVector center, float towerArea, float towerRange) {
        this(0, 0, upgradingIcon, leftCosts, rightCosts, initialCost, displayName,
                new String[]{"First", "Last", "Close", "Strong"}, framesPerAttack, center, towerArea, towerRange);
    }

    public void tick(){
        --attackTimer;
        if(attackTimer <= 0 && canAttack()){
            attack();
            attackTimer = framesPerAttack;
        }
    }

    protected abstract boolean canAttack();
    protected abstract void attack();
    public abstract void render();

    public int getSellCost() {
        int sum = 0;
        for (int i = 0; i < leftLevel; ++i)
            sum += leftCosts[i];
        for (int i = 0; i < rightLevel; ++i)
            sum += rightCosts[i];
        sum += initialCost;
        return (int) (0.7 * sum);
    }
}
