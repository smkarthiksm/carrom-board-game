package controller;

import constant.ApplicationConstants;
import exception.ExceptionHandler;
import implementation.CleanStrike;
import interfaces.Game;
import model.*;

import java.util.ArrayList;

public class UserInput extends Exception {

    public static void main(String[] args) {
        ArrayList<Turn> turns;
        ArrayList<Player> winner;
        Game game = new CleanStrike();

        try {
            turns = UserInput.getUserInput();
            winner = UserInput.findWinner(game, turns);
            if (winner.size() > 0) {
                System.out.println("\n" + ApplicationConstants.WINNER + winner.get(0));
                System.out.println("\n" + ApplicationConstants.LOSER + winner.get(1));
            } else {
                System.out.println(ApplicationConstants.DRAW);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * To mock the user input
     *
     * @return List of turns
     */
    static ArrayList<Turn> getUserInput() {
        ArrayList<Turn> turns = new ArrayList<>();
        Turn turn;
        Player playerOne = new Player(ApplicationConstants.PLAYERONE, 0, 0, 0);
        Player playerTwo = new Player(ApplicationConstants.PLAYERTWO, 0, 0, 0);
        StrikeType strike = new Strike();
        StrikeType multisStrike = new MultiStrike();
        StrikeType redStrike = new RedStrike();
        StrikeType strikerStrike = new StrikerStrike();
        StrikeType defunctCoin = new DefunctCoin();
        StrikeType none = new None();


        turn = new Turn(playerOne, multisStrike);
        turns.add(turn);

        turn = new Turn(playerTwo, redStrike);
        turns.add(turn);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        turn = new Turn(playerOne, defunctCoin);
        turns.add(turn);

        turn = new Turn(playerTwo, strikerStrike);
        turns.add(turn);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        turn = new Turn(playerOne, strike);
        turns.add(turn);

        turn = new Turn(playerTwo, multisStrike);
        turns.add(turn);

        turn = new Turn(playerOne, none);
        turns.add(turn);

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        turn = new Turn(playerOne, none);
        turns.add(turn);

        turn = new Turn(playerTwo, multisStrike);
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

        turn = new Turn(playerTwo, strike);
        turns.add(turn);

        return turns;
    }

    static ArrayList<Player> findWinner(Game game, ArrayList<Turn> turns) throws ExceptionHandler {
        try {
            Player playerOne = null;
            Player playerTwo = null;
            ArrayList<Player> winner = new ArrayList<>();

            // Iterate through all the turns
            for (int i = 0; i < turns.size(); i++) {
                ArrayList<Player> players = new ArrayList<>();

                // Check if there are coins available
                if (!game.areAllCoinsPlayed()) {

                    // If the player is player one or player two
                    if (turns.get(i).getPlayer().getName().equals(ApplicationConstants.PLAYERONE)) {
                        playerOne = game.playGame(turns.get(i));
                        System.out.println("\n" + turns.get(i).getStrikeType().getClass().getSimpleName() + "\t" + playerOne);
                    } else {
                        playerTwo = game.playGame(turns.get(i));
                        System.out.println("\n" + turns.get(i).getStrikeType().getClass().getSimpleName() + "\t" + playerTwo);
                    }
                    players.add(playerOne);
                    players.add(playerTwo);

                    // If there is a winner
                    if (game.findGameWinner(players).size() > 0) {
                        winner = game.findGameWinner(players);
                        break;
                    }
                }

                // If all the coins are played
                else {
                    // If there is a winner
                    if (game.findGameWinner(players) != null) {
                        winner = game.findGameWinner(players);
                    }
                    break;
                }
            }
            return winner;
        } catch (Exception e) {
            throw new ExceptionHandler(ApplicationConstants.UNABLE_TO_PLAY_GAME);
        }
    }
}
