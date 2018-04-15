package player;

import damage.Attack;

public interface Attackable {

    void dealDamage(Attack damage, Player player);
}
