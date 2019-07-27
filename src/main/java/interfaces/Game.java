package interfaces;

import exception.ExceptionHandler;
import model.Player;
import model.Turn;

import java.util.ArrayList;

public interface Game {

    Player playGame(Turn turn) throws ExceptionHandler;

    boolean areAllCoinsPlayed() throws ExceptionHandler;

    ArrayList<Player> findGameWinner(ArrayList<Player> players) throws ExceptionHandler;
}
