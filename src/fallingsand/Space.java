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
    }

    public void update() {
        for (var p:particelle) {
            p.moveDown();
        }
    }
}
