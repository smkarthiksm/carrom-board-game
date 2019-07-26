package model;

public class None extends Turn {

    public None() {
        this.points = 0;
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
