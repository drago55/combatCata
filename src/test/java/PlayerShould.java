import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerShould {

    @Test
    public void beDead() {

        //Given
        Player player = new Player();
        //When
        player.setHealth(0);
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
    public void dealDamage() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.dealDamage(player2);
        //Then
        assertEquals(950, player2.getHealth());
    }

    @Test
    public void heal() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.dealDamage(player2);
        player.heal(player2);
        //Then
        assertEquals(1000, player2.getHealth());
    }

    @Test
    public void not_healed_over_1000() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.heal(player2);
        //Then
        assertEquals(1000, player.getHealth());
    }

    @Test
    public void not_healed_when_dead() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player.setHealth(0);
        player2.heal(player);
        //Then
        assertEquals(0, player.getHealth());
    }

    @Test
    public void drop_health_to_zero_on_higher_damage_than_health() {
        //Given
        Player player = new Player();
        Player player2 = new Player();
        //When
        player2.setHealth(20);
        player.dealDamage(player2);
        //Then
        assertEquals(0, player2.getHealth());
        assertFalse(player2.isAlive());
    }

}
