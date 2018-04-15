package damage;

import player.Player;

public class MeleeDamage extends Damage implements Attack, RangedAttack {

    public MeleeDamage(int damage) {
        super(damage);
    }

    @Override
    public void execute(Player enemy) {
        if (isInRange(enemy)) {
            enemy.receiveDamage(this.damage);
        }
    }

    @Override
    public boolean isInRange(Player enemy) {
        return enemy.getRange() < 2;
    }
}
