package damage;

import player.Player;

public interface RangedAttack {
    boolean isInRange(Player enemy);
}
