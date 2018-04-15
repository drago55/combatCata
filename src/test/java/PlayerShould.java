import damage.Attack;
import damage.BoostDamage;
import damage.Damage;
import damage.ReduceDamage;
import player.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerShould {

    @Test
    public void beDead() {

        //Given
        Player player = new Player();
        //When
        player.receiveDamage(1000);
        //Then
        assertFalse(player.isAlive());

    }

    @Test
    public void beAlive() {
        //Given
        Player player = new Player();

        //Then
        assertTrue(player.isAlive());
    }

    @Test
    public void have_level_1() {
        //Given
        Player player = new Player();
        //Then
        assertEquals(1, player.getLevel());
    }


    @Test
    public void have_1000_health_points() {
        //Given
        Player player = new Player();
        //When

        //Then
        assertEquals(1000, player.getHealth());
    }

    @Test
    public void not_deal_damage_to_itself() {
        //Given
        Player player = new Player();

        //When
        player.dealDamage(new Damage(50), player);
        //Then
        assertEquals(1000, player.getHealth());
    }

    @Test
    public void dealDamage() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.dealDamage(new Damage(50), player2);
        //Then
        assertEquals(950, player2.getHealth());
    }

    @Test
    public void heal_himself() {
        //Given
        Player player = new Player();
        //When
        player.receiveDamage(900);
        player.heal(50, player);
        //Then
        assertEquals(150, player.getHealth());
    }

    @Test
    public void heal() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.dealDamage(new Damage(50), player2);
        player.heal(50, player2);
        //Then
        assertEquals(1000, player2.getHealth());
    }


    @Test
    public void not_heal_enemies() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player2.receiveDamage(50);
        player.addEnemies(player2);
        player.heal(50, player2);
        //Then
        assertEquals(950, player2.getHealth());
    }


    @Test
    public void not_healed_over_1000() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.heal(50, player2);
        //Then
        assertEquals(1000, player.getHealth());
    }

    @Test
    public void not_healed_when_dead() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.receiveDamage(1000);
        player2.heal(50, player);
        //Then
        assertEquals(0, player.getHealth());
    }

    @Test
    public void drop_health_to_zero_on_higher_damage_than_health() {
        //Given
        Player player = new Player();
        Player enemy = new Player();
        //When
        enemy.receiveDamage(970);
        player.dealDamage(new Damage(50), enemy);
        //Then
        assertEquals(0, enemy.getHealth());

    }

    @Test
    public void beDead_when_damage_higher_than_health() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player2.receiveDamage(970);
        player.dealDamage(new Damage(50), player2);
        //Then
        assertFalse(player2.isAlive());
    }

    @Test
    public void deal_50_more_damage_on_lower_level_target() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        Attack damage= new Damage(50);
        //When
        player.setLevel(7);
        player.dealDamage(new BoostDamage(50), player2);
        //Then
        assertEquals(925, player2.getHealth());
    }

    @Test
    public void deal_50_less_damage_on_higher_level_target() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player2.setLevel(14);
        player.dealDamage(new ReduceDamage(50), player2);
        //Then
        assertEquals(975, player2.getHealth());
    }

    @Test
    public void have_range_of_2() {
        //Given
        Player meleeFighter = new MeleeFighter();

        //Then
        assertEquals(2, meleeFighter.getRange());
    }

    @Test
    public void have_range_of_20() {
        //Given
        Player rangedFighter = new RangedFighter();

        //Then
        assertEquals(20, rangedFighter.getRange());
    }

}
