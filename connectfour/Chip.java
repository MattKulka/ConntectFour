package edu.ysu.restaurantclient.connectfour;

public class Chip {
   private Boolean inUse = false;
    private Player player = Player.NoPlayer;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;

        inUse = true;
    }

    public Boolean getInUse() {
        return inUse;
    }





}

