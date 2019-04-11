import java.awt.*;
import java.util.LinkedList;

public abstract class Stack {

    public LinkedList<Card> stack = new LinkedList<>();

    public void movable(){

    }

    abstract void render (Graphics g);

}