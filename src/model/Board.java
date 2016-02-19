package model;

import java.util.ArrayList;

/**
 * An abstraction of the game board.
 */
public abstract class Board {
    private int size;
    private char currentPlayer;
    private Space[][] spaces;
    private boolean gameOver;

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public Space[][] getSpaces() {
        return spaces;
    }

    public void setSpaces(Space[][] spaces) {
        this.spaces = spaces;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public abstract ArrayList<Space> validSpaceList();

    public abstract boolean checkWin();

    public abstract void runOnce();

    public void take(Space next) throws Exception {
        if (!next.isValid()){
            throw new Exception("Invalid space!");
        }
        next.setToken(getCurrentPlayer());
        next.setValid(false);
    }

}
