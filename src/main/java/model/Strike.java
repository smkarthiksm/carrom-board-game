package model;

public class Strike extends Turn {

    public Strike() {
        this.points = 1;
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
