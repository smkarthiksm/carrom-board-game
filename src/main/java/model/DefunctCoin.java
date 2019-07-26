package model;

public class DefunctCoin extends Turn {

    public DefunctCoin() {
        this.points = -2;
        this.canPlayNext = false;
    }

    @Override
    public String toString() {
        return "MultiStrike{" +
                "points=" + points +
                ", canPlayNext=" + canPlayNext +
                '}';
    }
}
