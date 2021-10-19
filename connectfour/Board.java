package edu.ysu.restaurantclient.connectfour;


import java.util.Random;

import android.graphics.Color;
import android.widget.Button;


public class Board {
    public Player player = Player.Player1;
    private int column = 0;
    private int row = 0;
    public Player winner = Player.NoPlayer;

    private final Chip[][] gameBoard = new Chip[7][6];


    public void InitializeGame() {
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < 7; column++) {
                gameBoard[column][row] = new Chip();

            }
        }
    }

    public void positionChip(int column, Button[][] button) {             //set position for a chip of a specific player, updates row value for finding the corresponding and determines if that position wins
        this.column = column;
        for (int row = 0; row < 6; ) {
            if (gameBoard[column][5].getInUse()) {              //if top position of that column is full, exit loop.
                break;
            } else if (gameBoard[column][row].getInUse()) {
                row++;
            } else {
                this.row = row;
                gameBoard[column][row].setPlayer(player);

                if (player == Player.Player1) {                                            //change colour of chip based on which player's turn it is
                    button[column][row].setText("1");
                } else if (player == Player.Player2) {
                    button[column][row].setText("2");
                }
                break;
            }
        }
    }

    public void determineWin() {
        int count = 0;
        int checkMinus = 1;      //check chip behind
        int checkPlus = 1;      //check chip infront
        if (player == Player.Player1) {

            //horizontal
            for (int i = 0; i < 3; i++) {
                if (column - checkMinus >= 0 && gameBoard[column - checkMinus][row].getPlayer() == Player.Player1) {     //checkMinus left
                    checkMinus++;
                    count++;

                } else if
                (column + checkPlus <= 6 && gameBoard[column + checkPlus][row].getPlayer() == Player.Player1) {
                    checkPlus++;
                    count++;
                }
            }
            if (count == 3) {
                winner = Player.Player1;
                return;
            }

            count = 0;
            checkMinus = 1;
            checkPlus = 1;       //reset integers

            //vertical
            for (int i = 0; i < 3; i++) {
                if (row - checkMinus >= 0 && gameBoard[column][row - checkMinus].getPlayer() == Player.Player1) {     //checkMinus left
                    checkMinus++;
                    count++;
                } else if
                (row + checkPlus <= 6 && gameBoard[column][row + checkPlus].getPlayer() == Player.Player1) {
                    checkPlus++;
                    count++;
                }
            }
            if (count == 3) {
                winner = Player.Player1;
                return;
            }

            count = 0;
            checkMinus = 1;
            checkPlus = 1;       //reset integers

            //diagonal positive slope
            for (int i = 0; i < 3; i++) {
                if (column - checkMinus >= 0 && row - checkMinus >= 0 && gameBoard[column-checkMinus][row - checkMinus].getPlayer() == Player.Player1) {     //checkMinus left
                    checkMinus++;
                    count++;
                } else if
                (column + checkPlus <= 6 && row + checkPlus <= 5 && gameBoard[column + checkPlus][row + checkPlus].getPlayer() == Player.Player1) {
                    checkPlus++;
                    count++;
                }
            }
            if (count == 3) {
                winner = Player.Player1;
                return;
            }

            count = 0;
            checkMinus = 1;
            checkPlus = 1;       //reset integers

            //diagonal negative slope
            for (int i = 0; i < 3; i++) {
                if (column - checkMinus >= 0 && row + checkMinus < 6 && gameBoard[column-checkMinus][row + checkMinus].getPlayer() == Player.Player1) {     //checkMinus left
                    checkMinus++;
                    count++;
                } else if
                (column + checkPlus < 7 && row - checkPlus >= 0 && gameBoard[column + checkPlus][row - checkPlus].getPlayer() == Player.Player1) {
                    checkPlus++;
                    count++;
                }
            }
            if (count == 3) {
                winner = Player.Player1;
                return;
            }

        } else if (player == Player.Player2) {
            //horizontal
            for (int i = 0; i < 3; i++) {
                if (column - checkMinus >= 0 && gameBoard[column - checkMinus][row].getPlayer() == Player.Player2) {     //checkMinus left
                    checkMinus++;
                    count++;
                } else if
                (column + checkPlus <= 6 && gameBoard[column + checkPlus][row].getPlayer() == Player.Player2) {
                    checkPlus++;
                    count++;

                }
            }
            if (count == 3) {
                winner = Player.Player2;
                return;
            }
            count = 0;
            checkMinus = 1;
            checkPlus = 1;       //reset integers

            //vertical
            for (int i = 0; i < 3; i++) {
                if (row - checkMinus >= 0 && gameBoard[column][row - checkMinus].getPlayer() == Player.Player2) {     //checkMinus left
                    checkMinus++;
                    count++;
                } else if
                (row + checkPlus <= 6 && gameBoard[column][row + checkPlus].getPlayer() == Player.Player2) {
                    checkPlus++;
                    count++;
                }
            }
            if (count == 3) {
                winner = Player.Player2;
                return;
            }
            count = 0;
            checkMinus = 1;
            checkPlus = 1;       //reset integers

            //diagonal positive slope
            for (int i = 0; i < 3; i++) {
                if (column - checkMinus >= 0 && row - checkMinus >= 0 && gameBoard[column-checkMinus][row - checkMinus].getPlayer() == Player.Player2) {     //checkMinus left
                    checkMinus++;
                    count++;
                } else if
                (column + checkPlus <= 6 && row + checkPlus <= 5 && gameBoard[column + checkPlus][row + checkPlus].getPlayer() == Player.Player2){
                    checkPlus++;
                    count++;
                }
            }
            if (count == 3) {
                winner = Player.Player2;
                return;
            }

            count = 0;
            checkMinus = 1;
            checkPlus = 1;       //reset integers

            //diagonal negative slope
            for (int i = 0; i < 3; i++) {
                if (column - checkMinus >= 0 && row + checkMinus <= 5 && gameBoard[column-checkMinus][row + checkMinus].getPlayer() == Player.Player2) {     //checkMinus left
                    checkMinus++;
                    count++;
                } else if
                (column + checkPlus <= 6 && row - checkPlus >= 0 && gameBoard[column + checkPlus][row - checkPlus].getPlayer() == Player.Player2) {
                    checkPlus++;
                    count++;
                }
            }
            if (count == 3) {
                winner = Player.Player2;
            }


        }

    }


    public Player getPlayer() {
        return player;
    }

    public void switchTurns() {
        if (player == Player.Player1) {                                //Switch turns
            player = Player.Player2;
        }
        else if (player == Player.Player2) {
            player = Player.Player1;
        }
    }

    public String displayWinner() {
        if (winner == Player.Player1) {
            return "Player 1 Wins!";
        }

        if (winner == Player.Player2) {
            return "Player 2 Wins!";
        }
        return "No Winner";
    }




}