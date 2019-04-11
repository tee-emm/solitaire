import java.awt.*;
import java.util.LinkedList;

public class PlayStack extends Stack {

    PlayStack(LinkedList<Card> cards){
        stack = cards;
    }

    @Override
    void render(Graphics g) {

    }
}
