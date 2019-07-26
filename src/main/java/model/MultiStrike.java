package model;

public class MultiStrike extends Turn {

    public MultiStrike() {
        this.points = 2;
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
