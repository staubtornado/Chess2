public class Board {
    private final Figure[][] board;

    public Board() {
        this.board = new Figure[8][8];

        for (int i = 0; i < 8; i++) {
            this.board[i][1] = new Figure(PlayerColor.BLACK, "Pawn", '♙', i, 1);
            this.board[i][6] = new Figure(PlayerColor.WHITE, "Pawn", '♟', i, 6);
        }
        this.board[0][0] = new Figure(PlayerColor.BLACK, "Rook", '♖', 0, 0);
        this.board[7][0] = new Figure(PlayerColor.BLACK, "Rook", '♖', 7, 0);
        this.board[0][7] = new Figure(PlayerColor.WHITE, "Rook", '♜', 0, 7);
        this.board[7][7] = new Figure(PlayerColor.WHITE, "Rook", '♜', 7, 7);
        this.board[1][0] = new Figure(PlayerColor.BLACK, "Knight", '♘', 1, 0);
        this.board[6][0] = new Figure(PlayerColor.BLACK, "Knight", '♘', 6, 0);
        this.board[1][7] = new Figure(PlayerColor.WHITE, "Knight", '♞', 1, 7);
        this.board[6][7] = new Figure(PlayerColor.WHITE, "Knight", '♞', 6, 7);
        this.board[2][0] = new Figure(PlayerColor.BLACK, "Bishop", '♗', 2, 0);
        this.board[5][0] = new Figure(PlayerColor.BLACK, "Bishop", '♗', 5, 0);
        this.board[2][7] = new Figure(PlayerColor.WHITE, "Bishop", '♝', 2, 7);
        this.board[5][7] = new Figure(PlayerColor.WHITE, "Bishop", '♝', 5, 7);
        this.board[3][0] = new Figure(PlayerColor.BLACK, "Queen", '♕', 3, 0);
        this.board[3][7] = new Figure(PlayerColor.WHITE, "Queen", '♛', 3, 7);
        this.board[4][0] = new Figure(PlayerColor.BLACK, "King", '♔', 4, 0);
        this.board[4][7] = new Figure(PlayerColor.WHITE, "King", '♚', 4, 7);
    }

    public int[] size() {
        return new int[]{this.board.length, this.board[0].length};
    }

    public Figure[][] getAllFields() {
        return this.board;
    }

    public Figure getField(int x, int y) {
        try {
            return this.board[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public void setField(int x, int y, Figure figure) {
        try {
            this.board[x][y] = figure;
        } catch (IndexOutOfBoundsException ignored) {}
    }

    public void move(int x1, int y1, int x2, int y2) {
        this.board[x2][y2] = this.board[x1][y1];
        this.board[x2][y2].setX(x2);
        this.board[x2][y2].setY(y2);

        if (this.board[x2][y2].getIdentifier().equals("Pawn") && y2 == 7) {
            char icon = this.board[x2][y2].getColor() == PlayerColor.WHITE ? '♛' : '♕';
            this.board[x2][y2].setIdentity("Queen", icon);
        }

    }
}
