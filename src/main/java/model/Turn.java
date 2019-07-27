package model;

public class Turn {
    private Player player;
    private StrikeType strikeType;

    public Turn(Player player, StrikeType strikeType) {
        this.player = player;
        this.strikeType = strikeType;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public StrikeType getStrikeType() {
        return strikeType;
    }

    public void setStrikeType(StrikeType strikeType) {
        this.strikeType = strikeType;
    }

    @Override
    public String toString() {
        return "Turn{" +
                "player=" + player +
                ", strikeType=" + strikeType +
                '}';
    }
}
