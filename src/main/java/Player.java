public class Player {

    private int health = 1000;
    private boolean alive = true;
    private int level = 1;

    private static int baseDamage = 50;

    private static int baseHeal = 50;

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

        player.setHealth(returnHealth(player));
    }

    private int returnHealth(Player player) {
        return player.getHealth() - baseDamage < 0 ? 0 : player.getHealth() - baseDamage;
    }

    public void heal(Player player) {
        if (player.isAlive()) {
            player.setHealth(player.getHealth() + baseHeal);
        }
    }
}
