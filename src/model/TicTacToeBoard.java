package model;

import java.util.ArrayList;

/**
 * A 3 * 3 Tic Tac Toe implementation of Board
 * ­ "Connection" length: 3
 * ­ Board size: 3x3
 * ­ Acceptable "connection" directions: top­to­bottom, left­to­right,
 * diagonally up­and­to­the­right, diagonally up­and­to­the­left.
 * ­ Acceptable spaces: any available space that is not claimed already.
 */
public class TicTacToeBoard extends Board {

    @Override
    public ArrayList<Space> validSpaceList() {
        ArrayList<Space> result = new ArrayList<Space>();
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                if (this.getSpaces()[i][j].isValid()) {
                    result.add(this.getSpaces()[i][j]);
                }
            }
        }
        return result;
    }

    public TicTacToeBoard() {
        this.setSize(3);
        this.setCurrentPlayer('A');
        this.setGameOver(false);
        Space[][] spaces = new Space[this.getSize()][this.getSize()];
        for (int i = 0; i < spaces.length; i++) {
            for (int j = 0; j < spaces[i].length; j++) {
                spaces[i][j] = new Space();
            }
        }
        this.setSpaces(spaces);
    }


    @Override
    public boolean checkWin() {
        return (checkWinRow() || checkWinColumn() || checkWinDiagonal());

    }

    private boolean checkWinColumn() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(this.getSpaces()[0][i].getToken(), this.getSpaces
                    ()[1][i].getToken(), this.getSpaces()[2][i].getToken())
                    == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinRow() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(this.getSpaces()[i][0].getToken(), this.getSpaces
                    ()[i][1].getToken(), this.getSpaces()[i][2].getToken())
                    == true) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinDiagonal() {
        return (checkRowCol(this.getSpaces()[0][0].getToken(), this.getSpaces
                ()[1][1].getToken(), this.getSpaces()[2][2].getToken())
                == true) ||
                (checkRowCol(this.getSpaces()[0][2].getToken(),
                        this.getSpaces()[1][1].getToken(), this.getSpaces()
                                [2][0]
                                .getToken())
                        == true);
    }

    private boolean checkRowCol(char space1, char space2, char space3) {
        return (space1 != '-') && (space1 == space2) && (space2 == space3);
    }

}
