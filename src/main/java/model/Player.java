package model;

public class Player {
    private String name;
    private int points;
    private int noOfFouls;
    private int scoreInThreeContinuousTurns;

    public Player(String name, int points, int noOfFouls, int scoreInThreeContinuousTurns) {
        this.name = name;
        this.points = points;
        this.noOfFouls = noOfFouls;
        this.scoreInThreeContinuousTurns = scoreInThreeContinuousTurns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNoOfFouls() {
        return noOfFouls;
    }

    public void setNoOfFouls(int noOfFouls) {
        this.noOfFouls = noOfFouls;
    }

    public int getScoreInThreeContinuousTurns() {
        return scoreInThreeContinuousTurns;
    }

    public void setScoreInThreeContinuousTurns(int scoreInThreeContinuousTurns) {
        this.scoreInThreeContinuousTurns = scoreInThreeContinuousTurns;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", noOfFouls=" + noOfFouls +
                ", scoreInThreeContinuousTurns=" + scoreInThreeContinuousTurns +
                '}';
    }
}
