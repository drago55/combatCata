package damage;

import player.Player;

public class RangedDamage extends Damage implements Attack {

    public RangedDamage(int damage) {
        super(damage);
    }

    @Override
    public void execute(Player enemy) {
        if (isInRange(enemy)) {
            enemy.receiveDamage(this.damage);
        }
    }

    private boolean isInRange(Player enemy) {
        return enemy.getRange() < 20;
    }
}
