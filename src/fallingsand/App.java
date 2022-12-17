package fallingsand;

import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class App extends PApplet {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    private  Space space;

    public App() {

    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        space = new Space(getGraphics());
        for (int i = 10; i < 20; i++) {
            //particles.add(new Particle(5,3+i,getGraphics()));
            space.addParticle(5,3+i);
        }
    }

    @Override
    public void draw() {
        space.update();
        background(55);
//        for (var p:particles) {
//            p.moveDown();
//        }
       space.draw();
    }

    public static void main(String[] args) {
        PApplet.main("fallingsand.App");
    }
}
