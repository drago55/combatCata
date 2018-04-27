package damage;

import player.Player;

import static damage.DamageConstants.*;

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
