package fallingsand;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class App extends PApplet {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private final List<Particle> particles;

    public App() {
        particles = new ArrayList<>();
    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        for (int i = 10; i < 20; i++) {
            particles.add(new Particle(5,3+i,getGraphics()));
        }
    }

    @Override
    public void draw() {
        background(55);
        for (var p:particles) {
            p.moveDown();
        }
        for (var p:particles) {
            p.draw();
        }
    }

    public static void main(String[] args) {
        PApplet.main("fallingsand.App");
    }
}
