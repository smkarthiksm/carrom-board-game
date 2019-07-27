package implementation;

import constant.ApplicationConstants;
import exception.ExceptionHandler;
import interfaces.Game;
import model.Player;
import model.StrikeType;
import model.Turn;

import java.util.ArrayList;

public class CleanStrike implements Game {
    public static int noOfPlayableCoins = 10;

    /**
     * Logic to implement the Clear strike game
     *
     * @param turn
     * @return Latest player status
     */
    @Override
    public Player playGame(Turn turn) throws ExceptionHandler {
        try {
            StrikeType strikeType = turn.getStrikeType();
            Player player = turn.getPlayer();
            int points = player.getPoints();

            // Update the user point based on the coin pocketed and the given constraints
            points = points + strikeType.getPoints();

            // If foul, increment the foul count and the continuous foul count
            if (strikeType.getPoints() < 1) {
                player.setNoOfFouls(player.getNoOfFouls() + 1);
                player.setScoreInThreeContinuousTurns(player.getScoreInThreeContinuousTurns() + 1);
            }
            // If no foul, reset continuous foul count
            else {
                player.setScoreInThreeContinuousTurns(0);
            }

            // If 3 continuous fouls, decrease the point and reset the continuous foul count
            if (player.getScoreInThreeContinuousTurns() == 3) {
                points = points - 1;
                player.setScoreInThreeContinuousTurns(0);
            }

            // If 3 fouls, decrease the point and reset the number of foul count
            if (player.getNoOfFouls() == 3) {
                points = points - 1;
                player.setNoOfFouls(0);
            }
            player.setPoints(points);

            // Update the coint count
            noOfPlayableCoins = noOfPlayableCoins - strikeType.getNoOfPlayableCoins();
            return player;
        } catch (Exception e) {
            throw new ExceptionHandler(ApplicationConstants.UNABLE_TO_PLAY_GAME);
        }
    }

    /**
     * Check if there are available coins to play
     *
     * @return Boolean
     */
    @Override
    public boolean areAllCoinsPlayed() throws ExceptionHandler {
        try {
            if (noOfPlayableCoins < 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new ExceptionHandler(ApplicationConstants.UNABLE_TO_PLAY_GAME);
        }
    }

    /**
     * Checks player points and inserts winner player in 0 position and loser player in 1 position. Else returns null
     *
     * @param players
     * @return List of players or null.
     */
    @Override
    public ArrayList<Player> findGameWinner(ArrayList<Player> players) throws ExceptionHandler {
        Player playerOne = null;
        Player playerTwo = null;
        ArrayList<Player> winner = new ArrayList<>();
        try {
            // Identify player one and player two
            for (Player player : players) {
                if (player != null) {
                    if (player.getName().equals(ApplicationConstants.PLAYERONE)) {
                        playerOne = player;
                    } else {
                        playerTwo = player;
                    }
                }
            }

            // If both players are there and if anyone gets above 4 points and their difference is more than 2
            if ((playerOne != null && playerTwo != null) && (playerOne.getPoints() > 4 || playerTwo.getPoints() > 4)) {

                // Winner is added in 0 position and loser is added in 1 position
                if ((playerOne.getPoints() - playerTwo.getPoints()) > 2) {
                    winner.add(playerOne);
                    winner.add(playerTwo);
                } else {
                    winner.add(playerTwo);
                    winner.add(playerOne);
                }
            }
            return winner;
        } catch (Exception e) {
            throw new ExceptionHandler(ApplicationConstants.UNABLE_TO_PLAY_GAME);
        }
    }

}
