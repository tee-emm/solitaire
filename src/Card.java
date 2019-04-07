import java.awt.*;

public class Card {

    private char suit;
    private int face;
    private boolean faceUp;
    private int x, y;
    private int imgIndex;

    Card(char s, int f, int imgIndex) {

        suit = s;
        face = f;
        faceUp=false;
        x = 0;
        y = 0;
        this.imgIndex = imgIndex;
    }

        Card(char s, int f, int x, int y) {

            suit = s;
            face = f;
            faceUp=false;
            this.x = x;
            this.y = y;
        }

        public char getSuit()
        {

            return suit;

        }

        public int getFace()
        {

            return face;

        }

        public boolean getFaceUp()
        {

            return faceUp;

        }

        public void flipCard()
        {

            faceUp = !faceUp;

        }

        public void render(Graphics g)
        {
            g.drawImage(Deck.visual[imgIndex], x - Deck.visual[imgIndex].getWidth(null)/2, y -Deck.visual[imgIndex].getHeight(null)/2, null);
        }


    }

