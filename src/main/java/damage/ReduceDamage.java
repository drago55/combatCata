package damage;

import player.Player;

public class ReduceDamage extends Damage implements Attack {

    public ReduceDamage(int damage) {
        super(damage);
    }

    @Override
    public void execute(Player enemy) {
        enemy.receiveDamage(this.damage -= this.damage * 0.5);
    }
}
