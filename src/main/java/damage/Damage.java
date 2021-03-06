package damage;

import player.Player;


public class Damage implements Attack {

    protected int damage = BASE_DAMAGE;

    public Damage(int damage) {
        this.damage += damage;
    }

    @Override
    public void execute(Player enemy) {
        enemy.receiveDamage(damage);
    }
}
