package fallingsand;

import processing.core.PGraphics;

public class Segment {
    private final Position start;
    private final Position end;
    private final PGraphics gfx;

    public Segment(Position start, Position end, PGraphics gfx) {
        this.start = start;
        this.end = end;
        this.gfx = gfx;
    }

    public boolean collide(Position pos){
        var isVertical = (start.col == end.col);
        if (isVertical) {
            var minRow = Math.min(start.row,end.row);
            var maxRow = Math.max(start.row, end.row);
            return pos.col == start.col && (pos.row >= minRow && pos.row <= maxRow);
        }

        var minCol = Math.min(start.col,end.col);
        var maxCol = Math.max(start.col, end.col);
        return pos.row == start.row && (pos.col >= minCol && pos.col <= maxCol);
    }


}
