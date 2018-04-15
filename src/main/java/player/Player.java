package player;

import damage.Attack;

import java.util.HashSet;
import java.util.Set;


public class Player implements Attackable {

    private int health = 1000;
    private boolean alive = true;
    private int level = 1;
    private Set<Player> enemies = new HashSet<>();

    private static int baseHeal = 50;
    private int baseDamage = 50;

    protected int range;


    public void setHealth(int health) {
        if ((this.health += health) > 1000) {
            this.health = 1000;
        }
    }

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int damage) {
        if (isDamageHigherThanHealth(damage)){this.health=0;}
    }

    private boolean isDamageHigherThanHealth(int damage) {
        return (this.health -= damage) < 0;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isAlive() {
        return health > 0 ? alive : false;
    }

    @Override
    public void dealDamage(Attack attack, Player player) {
        if (player != this) {
            attack.execute(player);
        }
    }

    private int doDamage(Player player) {

        System.out.println("Level of a target " + player.getLevel());
        System.out.println("Attackers level " + this.level);
        int dmg = baseDamage;

        int dif = this.level - player.getLevel();

        if (dif > 0 && Math.abs(dif) >= 5) {
            System.out.println("Attacker is stronger");
            dmg += this.baseDamage * 0.5;
            System.out.println("damage is " + dmg);
        }
        if (dif < 0 && Math.abs(dif) >= 5) {
            System.out.println("Attacker is weaker");
            dmg -= this.baseDamage * 0.5;
            System.out.println("damage is " + dmg);
        }

        System.out.println("Difference between target and attacker " + dif);
        return player.getHealth() - dmg < 0 ? 0 : player.getHealth() - dmg;
    }


    public void heal(int healthPoints, Player player) {
        if (isAliveAndNotEnemy(player)) {
            player.setHealth(healthPoints);
        }
    }

    private boolean isAliveAndNotEnemy(Player player) {
        return player.isAlive() && !enemies.contains(player);
    }

    public void addEnemies(Player enemy) {
        enemies.add(enemy);
    }


    public int getRange() {
        return this.range;
    }
}
