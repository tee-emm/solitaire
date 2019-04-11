import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

/**
 * Created by thomassmuir on 2019-02-12.
 */
public class Solitaire extends Canvas implements Runnable {

    Image testImage;
    private Thread thread;
    public Deck deck;
    public static boolean running = false;
    public static int WIDTH = 1280;
    public static int HEIGHT = 720;

    PlayStack[] playStacks = new PlayStack[7];
    BuildStack[] buildStacks = new BuildStack[4];
    DrawStack drawStack = new DrawStack();

    public Solitaire()  {

        Deck.imgArray();
        addMouseListener(new MouseClick());
        addMouseMotionListener(new MouseMovement());
        deck = new Deck();

        for(int i = 0; i < playStacks.length; i++)
            playStacks[i] = new PlayStack(deck.getDeck());

        try {
            testImage = ImageIO.read(Deck.class.getResource("solitaire (1).png"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        new Window(WIDTH, HEIGHT, this);
    }

    public static void main (String[] args) {

        new Solitaire();

    }


    public void run() {
        // Most common game loop, renders and does one tick every TICK_RATE a
        // second
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }

            if (running)
                render();

        }
        stop(); // Exit the program if running is set to false
    }

    private void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }


        Graphics g = bs.getDrawGraphics();
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.white);
        g.drawImage(testImage, 0, 0, null);
        deck.render(g);
        g.dispose();
        bs.show();

    }

    public synchronized void start() {
        // start new thread, set program to running
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        // Exit program
        try {
            thread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}