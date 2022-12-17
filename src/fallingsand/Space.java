package fallingsand;

import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private final List<Particle> particelle;
    private final List<Segment> segmenti;
    private final PGraphics gfx;

    public Space(PGraphics gfx) {
        this.gfx = gfx;
        particelle = new ArrayList<>();
        segmenti = new ArrayList<>();
    }

    public void addSegment(Segment s) {
        segmenti.add(s);
    }

    public void addSegment(Position start, Position end) {
        segmenti.add(new Segment(start,end,gfx));
    }

    public void addParticle(Particle p){
        particelle.add(p);
    }

    public void addParticle(int row, int col){
        particelle.add(new Particle(row,col, gfx));
    }

    public void addParticle(Position pos) {
        addParticle(pos.row,pos.col);
    }

    public void draw() {
        for (var p:particelle) {
            p.draw();
        }
        gfx.fill(20);
        for (var s:segmenti) {
            s.draw();
        }
    }

    public void update() {
        for (var p:particelle) {
            p.moveDown();
        }
    }
}
