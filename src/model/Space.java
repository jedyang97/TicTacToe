package model;

/**
 * Space is a unit squre on a board. A n*n board will have n^2 spaces.
 */
public class Space {
    private boolean valid;
    private char token;

    public char getToken() {
        return token;
    }

    public void setToken(char token) {
        this.token = token;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Space() {
        this.setValid(true);
        this.setToken('-');
    }
}
