package ru.netology.game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Players;
import ru.netology.game.Game;

class GameTest {

    @Test
    void shouldPlayerOneWin() {
        Game game = new Game();
        Players player1 = new Players(1, "Olya", 140);
        Players player2 = new Players(2, "Sveta", 95);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round("Olya", "Sveta");
        assertEquals(expected, actual);
    }

    @Test
    void shouldPlayerTwoWin() {
        Game game = new Game();
        Players player1 = new Players(1, "Olya", 20);
        Players player2 = new Players(2, "Sveta", 95);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round("Olya", "Sveta");
        assertEquals(expected, actual);
    }

    @Test
    void shouldDrawCase() {
        Game game = new Game();
        Players player1 = new Players(1, "Olya", 95);
        Players player2 = new Players(2, "Sveta", 95);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round("Olya", "Sveta");
        assertEquals(expected, actual);
    }

    @Test
    void shouldPlayerTwoUnregistered() {
        Game game = new Game();
        Players player1 = new Players(1, "Olya", 100);
        game.register(player1);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Sveta");
        });
    }

    @Test
    void shouldPlayerOneUnregistered() {
        Game game = new Game();
        Players player2 = new Players(2, "Sveta", 100);
        game.register(player2);
        assertThrows(NotRegisteredException.class, () -> {
            game.round("Olya", "Sveta");
        });
    }
}