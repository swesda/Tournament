package ru.netology.game;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Players;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Players> players = new ArrayList<>();

    public Game() {
    }

    public void register(Players player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int strengthPlayer1 = strengthFound(playerName1);
        int strengthPlayer2 = strengthFound(playerName2);

        if (strengthPlayer1 == 0) {
            throw new NotRegisteredException("Первый игрок не зарегистрирован!");
        }
        if (strengthPlayer2 == 0) {
            throw new NotRegisteredException("Второй игрок не зарегистрирован!");
        }
        //сравниваем силу игроков
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        }
        if (strengthPlayer1 < strengthPlayer2) {
            return 2;
        }
        return 0;
    }

    public int strengthFound(String playerName) {
        for (Players player : players) {
            if (player.getName() == playerName) {
                int strengthPlayer = player.getStrength();
                return strengthPlayer;
            }
        }
        return 0;
    }
}