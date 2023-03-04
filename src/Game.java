import java.util.ArrayList;

public class Game {
    private final Player[] players;
    private final Board board;

    public Game(Player[] players) {
        this.players = players;
        this.board = new Board();
    }

    public Board getBoard() {
        return this.board;
    }

    public ArrayList<Integer[]> getMoves(int x, int y) {
        return this.board.getField(x, y).getMoves(this.board, null);
    }
}

