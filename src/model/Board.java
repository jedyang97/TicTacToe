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

    /**
     * @return all spaces that are valid
     */
    public abstract ArrayList<Space> validSpaceList();

    /**
     * @return true if some player has won the game
     */
    public abstract boolean checkWin();

    /**
     * Refresh the board after one run
     */
    public void runOnce() {
        if (this.getCurrentPlayer() == 'A') {
            this.setCurrentPlayer('B');
        } else {
            this.setCurrentPlayer('A');
        }
        if (checkWin() || (validSpaceList().size() == 0)) {
            this.setGameOver(true);
        }
    }

    /**
     * A method to simulate the taking of a space
     *
     * @param next the space to take in the next run
     * @throws Exception if the space passed in is not valid
     */
    public void take(Space next) throws Exception {
        if (!next.isValid()) {
            throw new Exception("Invalid space!");
        }
        next.setToken(getCurrentPlayer());
        next.setValid(false);
    }

}
