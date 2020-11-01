package esercizi.exercise1;

/**
 * This class represents a tic tac toe board
 *
 * @since 1.0
 */
public class TicTacToeBoard {
    private Mark [][] board = new Mark[3][3];


    /**
     * Puts a mark in a given cell
     *
     * @param c the mark to put in the board
     * @param x the x coordinate of the cell to be filled
     * @param y the y coordinate of the cell to be filled
     * @return true if the cell was empty, the game was not ended (e.g., no winner yet) and
     * it filled it, false otherwise
     */
    public boolean put(Mark c, int x, int y) {
        if(this.getMark(x,y) == null && this.winner() == null ){
            board[x][y] = c;
            return true;
        }
        else
            return false;
    }

    /**
     * Returns the mark of a cell, null if empty
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @return the mark in the given cell, null if the cell is empty
     */
    public Mark getMark(int x, int y) {
        boolean condX = x>=0 && x<=2;
        boolean condY = y>=0 && y<=2;
        if(condX && condY && board[x][y] != null){
            return board[x][y];
        }
        else
            return null;
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    public Mark winner() {
        Mark winner=null;
        //check vertical
        for(int i=0; i<3 && winner==null; i++){
            boolean cond1 = this.getMark(0,i)==this.getMark(1,i);
            boolean cond2 = this.getMark(1,i)==this.getMark(2,i);
            if(this.getMark(0,i) !=null && cond1 && cond2)
                winner = this.getMark(2,i);
        }
        //check horizontal
        for(int i=0; i<3 && winner==null; i++){
            boolean cond1 = this.getMark(i,0)==this.getMark(i,1);
            boolean cond2 = this.getMark(i,1)==this.getMark(i,2);
            if(this.getMark(i,0) !=null &&cond1 && cond2)
                winner = this.getMark(i,2);
        }
        // check diagonal1
        boolean cond1 = this.getMark(0,0)==this.getMark(1,1);
        boolean cond2 = this.getMark(1,1)==this.getMark(2,2);
        if(this.getMark(0,0)!= null && cond1 && cond2)
            winner = this.getMark(1,1);
        // check diagonal2
        boolean cond3 = this.getMark(0,2)==this.getMark(1,1);
        boolean cond4 = this.getMark(1,1)==this.getMark(0,2);
        if(this.getMark(0,2) != null && cond3 && cond4)
            winner = this.getMark(1,1);
        return winner;
        /*
        if(nRound >=5){

        }
        else
            return null;

         */
    }

    /**
     * Returns true if the board is full
     *
     * @return true iff the board is full
     */
    public boolean isFull() {
        int i;
        for(i=0; this.getMark(i/3, i%3) != null && i<9;i++){

        }
        if(i==9)
            return true;
        else
            return false;
    }

}
