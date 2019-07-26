package model;

public class RedStrike extends Turn {

    public RedStrike() {
        this.points = 3;
        this.canPlayNext = true;
    }

    @Override
    public String toString() {
        return "MultiStrike{" +
                "points=" + points +
                ", canPlayNext=" + canPlayNext +
                '}';
    }
}
