package fallingsand;

public class Position {
    protected int row;
    protected int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void moveDown() {
        row = row + 1;
    }

    public Position getDownPos() {
        return new Position(row+1,col);
    }
}
