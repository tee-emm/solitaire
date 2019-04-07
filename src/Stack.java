import java.awt.*;
import java.util.LinkedList;

public abstract class Stack {

    private LinkedList stack = new LinkedList();

    Stack(){

    }

    public void movable(){

    }

    abstract void render (Graphics g);

}