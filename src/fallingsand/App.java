package fallingsand;

import processing.core.PApplet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        for (int i = 10; i < 50; i++) {
            //particles.add(new Particle(5,3+i,getGraphics()));
            space.addParticle(-2*i,25);
        }
        var path = Paths.get("world.txt");
        try {
            var reader = Files.newBufferedReader(path);
            String line;
            while((line = reader.readLine()) !=null) {
                var fields = line.split(" ");
                var row0 = Integer.valueOf(fields[0]).intValue();
                var col0 = Integer.valueOf(fields[1]).intValue();
                var row1 = Integer.valueOf(fields[2]).intValue();
                var col1 = Integer.valueOf(fields[3]).intValue();
                space.addSegment(new Position(row0,col0), new Position(row1,col1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        space.addSegment(new Position(10,20), new Position(20,20));
        space.addSegment(new Position(20,20), new Position(20,30));
        space.addSegment(new Position(20,30), new Position(10,30));
        space.addSegment(new Position(80,0), new Position(0,0));
        space.addSegment(new Position(80,0), new Position(80,100));
        //frameRate(20);
    }

    @Override
    public void draw() {
        space.addParticle(-2,25);
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
