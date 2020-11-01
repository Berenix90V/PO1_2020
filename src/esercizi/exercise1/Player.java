package esercizi.exercise1;

/**
 * This class represents a player of the game
 *
 * @since 1.0
 */
public class Player {
    private final Mark mark;
    /**
     * Intializes a player using the given Mark
     * @param mark the mark of the player
     */
    public Player(Mark mark) {
        this.mark = mark;
    }

    /**
     * Plays a round of the game.
     *
     * @param board
     * @return true if the player was able to
     */
    public boolean play(TicTacToeBoard board) {
        /*
        Random rn = new Random();
        int answer = rn.nextInt(10) + 1;

         */
        if(board.isFull() == false){
            int coords = (int) (Math.floor(Math.random() * 9)+0);
            while(board.getMark(coords/3, coords%3) != null){
                coords = (int) (Math.floor(Math.random() * 9)+0);
            }
            board.put(mark, coords/3, coords%3);
            return true;
        }
        else
            return false;

    }
}
