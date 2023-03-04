import java.util.ArrayList;

public class Figure {
    private final Color color;
    private String identifier;
    private char symbol;
    private int x;
    private int y;


    public Figure(Color color, String name, char symbol, int x, int y) {
        this.color = color;
        this.identifier = name;
        this.symbol = symbol;

        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return this.color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentity(String identifier, char symbol) {
        this.identifier = identifier;
        this.symbol = symbol;
    }

    public ArrayList<Integer[]> getMoves(Board board, String overwriteIdentifier) {
        ArrayList<Integer[]> _moves = new ArrayList<>();

        String identifier = overwriteIdentifier == null ? this.identifier : overwriteIdentifier;
        switch (identifier) {
            case "Pawn" -> {
                if (this.x == 7) {
                    break;
                }

                if (this.y == 1 && board.getField(this.x, this.y + 1) == null) {
                    _moves.add(new Integer[]{this.x, this.y + 1});

                    if (board.getField(this.x, this.y + 2) == null) {
                        _moves.add(new Integer[]{this.x, this.y + 2});
                    }
                }
                if (board.getField(this.x - 1, this.y + 1) != null) {
                    _moves.add(new Integer[]{this.x - 1, this.y + 1});
                }
                if (board.getField(this.x + 1, this.y + 1) != null) {
                    _moves.add(new Integer[]{this.x + 1, this.y + 1});
                }
            }
            case "Rook" -> {
                for (int i = 1; i + this.x < board.size()[0]; i++) {
                    _moves.add(new Integer[]{i + this.x, this.y});
                    if (board.getField(i, this.y) == null) {
                        continue;
                    }
                    break;
                }
                for (int i = 1; this.x - i > -1; i++) {
                    _moves.add(new Integer[]{this.x - i, this.y});
                    if (board.getField(i, this.y) == null) {
                        continue;
                    }
                    break;
                }
                for (int i = 1; this.y + i < board.size()[1]; i++) {
                    _moves.add(new Integer[]{this.x, this.y + i});
                    if (board.getField(this.x, this.y + i) == null) {
                        continue;
                    }
                    break;
                }
                for (int i = 1; this.y - i > -1; i++) {
                    _moves.add(new Integer[]{this.x, this.y - i});
                    if (board.getField(this.x, this.y - i) == null) {
                        continue;
                    }
                    break;
                }
            }
            case "Bishop" -> {
                for (int i = 1; this.x + i < board.size()[0] && this.y + i < board.size()[1]; i++) {
                    _moves.add(new Integer[]{this.x + i, this.y + i});

                    if (board.getField(this.x + i, this.y + i) != null) {
                        break;
                    }
                }
                for (int i = 1; this.x - i > -1 && this.y - i > -1; i++) {
                    _moves.add(new Integer[]{this.x - i, this.y - i});

                    if (board.getField(this.x - i, this.y - i) != null) {
                        break;
                    }
                }
                for (int i = 1; this.x + i < board.size()[0] && this.y - i > -1; i++) {
                    _moves.add(new Integer[]{this.x + i, this.y - i});

                    if (board.getField(this.x + i, this.y - i) != null) {
                        break;
                    }
                }
                for (int i = 1; this.x - i > -1 && this.y + i < board.size()[1]; i++) {
                    _moves.add(new Integer[]{this.x - i, this.y + i});

                    if (board.getField(this.x - i, this.y + i) != null) {
                        break;
                    }
                }
            }
            case "Queen" -> {
                _moves.addAll(this.getMoves(board, "Rook"));
                _moves.addAll(this.getMoves(board, "Bishop"));
            }
            case "King" -> {
                if (this.x + 1 < board.size()[0]) {
                    _moves.add(new Integer[]{this.x + 1, this.y});
                }
                if (this.x - 1 > -1) {
                    _moves.add(new Integer[]{this.x - 1, this.y});
                }
                if (this.x + 1 < board.size()[0] && this.y + 1 < board.size()[1]) {
                    _moves.add(new Integer[]{this.x + 1, this.y + 1});
                }
                if (this.x - 1 > -1 && this.y - 1 > -1) {
                    _moves.add(new Integer[]{this.x - 1, this.y - 1});
                }
                if (this.y + 1 < board.size()[1]) {
                    _moves.add(new Integer[]{this.x, this.y + 1});
                }
                if (this.y - 1 > -1) {
                    _moves.add(new Integer[]{this.x, this.y - 1});
                }
                if (this.x + 1 < board.size()[0] && this.y - 1 > -1) {
                    _moves.add(new Integer[]{this.x + 1, this.y - 1});
                }
                if (this.x - 1 > -1 && this.y + 1 < board.size()[1]) {
                    _moves.add(new Integer[]{this.x + 1, this.y});
                }
            }
            case "Knight" -> {
                if (this.x - 1 > -1 && this.y + 2 < board.size()[1]) {
                    _moves.add(new Integer[]{this.x - 1, this.y + 2});
                }
                if (this.x + 1 < board.size()[0] && this.y + 2 < board.size()[1]) {
                    _moves.add(new Integer[]{this.x + 1, this.y + 2});
                }
                if (this.x - 1 > -1 && this.y - 2 > -1) {
                    _moves.add(new Integer[]{this.x - 1, this.y - 2});
                }
                if (this.x + 1 < board.size()[0] && this.y - 2 > -1) {
                    _moves.add(new Integer[]{this.x + 1, this.y - 2});
                }
                if (this.x + 2 < board.size()[0] && this.y + 1 < board.size()[1]) {
                    _moves.add(new Integer[]{this.x + 2, this.y + 1});
                }
                if (this.x + 2 < board.size()[0] && this.y - 1 > -1) {
                    _moves.add(new Integer[]{this.x + 2, this.y - 1});
                }
                if (this.x - 2 > -1 && this.y + 1 < board.size()[1]) {
                    _moves.add(new Integer[]{this.x - 2, this.y + 1});
                }
                if (this.x - 2 > -1 && this.y - 1 > -1) {
                    _moves.add(new Integer[]{this.x - 2, this.y - 1});
                }
            }
        }
        ArrayList<Integer[]> moves = new ArrayList<>();

        for (Integer[] move : _moves) {
            Figure field = board.getField(move[0], move[1]);
            if (field == null) {
                moves.add(move);
                continue;
            }
            if (field.getColor() != this.color) {
                moves.add(move);
            }
        }
        return moves;
    }


    @Override
    public String toString() {
        return Character.toString(this.symbol);
    }

}
