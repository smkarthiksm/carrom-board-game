package model;

public abstract class StrikeType {
    protected int points;
    protected int noOfPlayableCoins;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNoOfPlayableCoins() {
        return noOfPlayableCoins;
    }

    public void setNoOfPlayableCoins(int noOfPlayableCoins) {
        this.noOfPlayableCoins = noOfPlayableCoins;
    }

    @Override
    public String toString() {
        return "StrikeType{" +
                "points=" + points +
                ", noOfPlayableCoins=" + noOfPlayableCoins +
                '}';
    }
}
