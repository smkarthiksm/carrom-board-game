package implementation;

import constant.ApplicationConstants;
import model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CleanStrikeTest {
    static ArrayList<Turn> turns = new ArrayList<>();
    static ArrayList<Player> players = new ArrayList<>();

    @BeforeClass
    public static void getUserInput() {

        Turn turn;
        Player playerOne = new Player(ApplicationConstants.PLAYERONE, 0, 0, 0);
        Player playerTwo = new Player(ApplicationConstants.PLAYERTWO, 0, 0, 0);
        StrikeType strike = new Strike();
        StrikeType multisStrike = new MultiStrike();
        StrikeType redStrike = new RedStrike();
        StrikeType strikerStrike = new StrikerStrike();
        StrikeType defunctCoin = new DefunctCoin();
        StrikeType none = new None();
        players.add(playerOne);
        players.add(playerTwo);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        turn = new Turn(playerOne, multisStrike);
        turns.add(turn);

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        turn = new Turn(playerOne, redStrike);
        turns.add(turn);

        turn = new Turn(playerTwo, strikerStrike);
        turns.add(turn);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        turn = new Turn(playerOne, defunctCoin);
        turns.add(turn);

        turn = new Turn(playerTwo, multisStrike);
        turns.add(turn);

        turn = new Turn(playerOne, none);
        turns.add(turn);

        turn = new Turn(playerTwo, none);
        turns.add(turn);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        turn = new Turn(playerOne, none);
        turns.add(turn);

        turn = new Turn(playerTwo, defunctCoin);
        turns.add(turn);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, multisStrike);
        turns.add(turn);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, multisStrike);
        turns.add(turn);
    }

    @Test
    public void playGameShouldPass() {
        try {
            Player output = new CleanStrike().playGame(turns.get(0));
            assert !output.getName().isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void playGameShouldFail() {
        try {
            new CleanStrike().playGame(null);
        } catch (Exception e) {
            assertEquals(ApplicationConstants.UNABLE_TO_PLAY_GAME, e.getMessage());
        }

    }

    @Test
    public void areAllCoinsPlayedShouldPass() {
        try {
            boolean output = new CleanStrike().areAllCoinsPlayed();
            assertEquals(false, output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findGameWinnerShouldPass() {
        try {
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("Player1", 5, 0, 0));
            players.add(new Player("Player2", 1, 0, 0));
            ArrayList<Player> output = new CleanStrike().findGameWinner(players);
            System.out.println(output);
            assert output.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findGameWinnerShouldFail() {
        try {
            ArrayList<Player> players = new ArrayList<>();
            players.add(new Player("Player1", 5, 0, 0));
            players.add(null);
            ArrayList<Player> output = new CleanStrike().findGameWinner(players);
            assertEquals(0, output.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
