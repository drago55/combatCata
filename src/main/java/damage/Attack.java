package damage;

import player.Player;

public interface Attack {

    int BASE_DAMAGE = 0;

    void execute(Player enemy);

}
