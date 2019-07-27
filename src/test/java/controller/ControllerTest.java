package controller;

import constant.ApplicationConstants;
import implementation.CleanStrike;
import model.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    static ArrayList<Turn> turns = new ArrayList<>();

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
    public void findWinnerShouldPass() {
        try {
            ArrayList<Player> output = UserInput.findWinner(new CleanStrike(), turns);
            assert output.size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findWinnerShouldFail() {
        try {
            ArrayList<Player> output = UserInput.findWinner(new CleanStrike(), new ArrayList<>());
            System.out.println(output);
            assertEquals(0, output.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
