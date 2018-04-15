package damage;

import player.Player;

public class BoostDamage extends Damage implements Attack {

    public BoostDamage(int damage) {
        super(damage);
    }

    @Override
    public void execute(Player enemy) {
        enemy.receiveDamage(this.damage += this.damage * 0.5);
    }
}
