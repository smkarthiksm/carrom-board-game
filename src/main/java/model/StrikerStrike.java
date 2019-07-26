package model;

public class StrikerStrike extends Turn {

    public StrikerStrike() {
        this.points = -1;
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
