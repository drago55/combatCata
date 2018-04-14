import java.util.HashSet;
import java.util.Set;

public class Player {

    private int health = 1000;
    private boolean alive = true;
    private int level = 1;
    private Set<Player> enemies = new HashSet<>();

    private static int baseHeal = 50;
    private int baseDamage = 50;


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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

    public void dealDamage(Player player) {
        if (player != this) {
            player.setHealth(doDamage(player));
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


    public void heal(Player player) {
        if (player.isAlive() && !enemies.contains(player)) {
            player.setHealth(player.getHealth() + baseHeal);
        }
    }

    public void addEnemies(Player player2) {
        enemies.add(player2);
    }


}
